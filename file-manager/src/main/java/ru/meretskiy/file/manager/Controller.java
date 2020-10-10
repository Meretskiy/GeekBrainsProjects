package ru.meretskiy.file.manager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


public class Controller {

    public void exitAction(ActionEvent actionEvent) {
        Platform.exit();
    }
}
