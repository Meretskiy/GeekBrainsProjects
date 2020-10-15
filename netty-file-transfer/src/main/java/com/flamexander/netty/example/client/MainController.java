package com.flamexander.netty.example.client;

import com.flamexander.netty.example.common.AbstractMessage;
import com.flamexander.netty.example.common.FileMessage;
import com.flamexander.netty.example.common.FileRequest;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;

//Управляющий контроллер
public class MainController implements Initializable {
   //Текстовое поле с именем интересующего файла
    @FXML
    TextField tfFileName;
    //список локальных файлов
    @FXML
    ListView<String> filesList;
    //при запуске клиента мы подключаемся к серверу.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Network.start();
        Thread t = new Thread(() -> { //запускаем демон тред который будет ожидать сообщение от сервера
            try {
                while (true) {
                    AbstractMessage am = Network.readObject(); //тут блокировка, ждем любые сообщения от сервака
                    if (am instanceof FileMessage) { //если сервак прислал файлМессадж, значит нам пришел файл
                        FileMessage fm = (FileMessage) am; //кастуем в ФМ
                        //Вытягиваем из ФМ все байты и записываем этот файл к себе в клиентСторадж
                        Files.write(Paths.get("client_storage/" + fm.getFilename()), fm.getData(), StandardOpenOption.CREATE);
                        refreshLocalFilesList(); //иобновляем список файлов
                    }
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } finally {
                Network.stop();
            }
        });
        t.setDaemon(true);
        t.start();
        refreshLocalFilesList();
    }

    //при нажатии на кнопку скачать клиент посылает в сторону сервака файлРеквест с именем интересующего нас файла
    public void pressOnDownloadBtn(ActionEvent actionEvent) {
        if (tfFileName.getLength() > 0) {
            Network.sendMsg(new FileRequest(tfFileName.getText()));
            tfFileName.clear();
        }
    }

    //обновление списка локальных файлов
    public void refreshLocalFilesList() {
        updateUI(() -> {
            try {
                filesList.getItems().clear();
                //очищаем листВью и записываем в нее все файлы которые у нас есть в клаентСторадже
                Files.list(Paths.get("client_storage")).map(p -> p.getFileName().toString()).forEach(o -> filesList.getItems().add(o));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateUI(Runnable r) {
        if (Platform.isFxApplicationThread()) {
            r.run();
        } else {
            Platform.runLater(r);
        }
    }
}
