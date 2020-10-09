package ru.meretskiy.file.manager;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Controller implements Initializable{

//    @FXML
//    ListView<String> filesList;

    @FXML
    TableView<FileInfo> filesTable;



    public void menuItemFileExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void btnExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<FileInfo, String> fileTypeColumn = new TableColumn<>();
        fileTypeColumn.setCellValueFactory(parm -> new SimpleStringProperty(parm.getValue().getType().getName()));
        fileTypeColumn.setPrefWidth(24);

        TableColumn<FileInfo, String> fileNameColumn = new TableColumn<>("name");
        fileNameColumn.setCellValueFactory(parm -> new SimpleStringProperty(parm.getValue().getFilename()));
        fileNameColumn.setPrefWidth(400);

        TableColumn<FileInfo, Long> fileSizeColumn = new TableColumn<>("size");
        fileSizeColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getSize()));
        fileSizeColumn.setPrefWidth(150);
        fileSizeColumn.setCellFactory(column -> {
           return new TableCell<FileInfo, Long>() {
               @Override
               protected void updateItem(Long item, boolean empty) {
                   super.updateItem(item, empty);
                   if (item == null || empty) {
                       setText(null);
                       setStyle("");
                   } else {
                       String text = String.format("%,d bytes", item);
                       if (item == -1L) {
                           text = "[DIR]";
                       }
                       setText(text);
                   }
               }
           };
        });

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TableColumn<FileInfo, String> fileDateColumn = new TableColumn<>("date");
        fileDateColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLastModified().format(dtf)));
        fileDateColumn.setPrefWidth(150);

        filesTable.getColumns().addAll(fileTypeColumn, fileNameColumn, fileSizeColumn, fileDateColumn);
        filesTable.getSortOrder().add(fileTypeColumn);

        updateList(Paths.get(".", "file-manager", "A"));
    }

    public void updateList(Path path) {
        try {
            filesTable.getItems().clear();
            filesTable.getItems().addAll(Files.list(path).map(FileInfo::new).collect(Collectors.toList()));
            filesTable.sort();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Failed to update the file list", ButtonType.OK);
            alert.showAndWait();
        }
    }
}