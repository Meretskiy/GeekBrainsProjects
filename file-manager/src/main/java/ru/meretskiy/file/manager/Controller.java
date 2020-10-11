package ru.meretskiy.file.manager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Controller {

    @FXML
    VBox leftPanel, rightPanel;

    public void exitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void copyBtnAction(ActionEvent actionEvent) {
        PanelController leftPC = (PanelController) leftPanel.getProperties().get("ctrl");
        PanelController rightPC = (PanelController) rightPanel.getProperties().get("ctrl");

        if (leftPC.getSelectedFileName() == null && rightPC.getSelectedFileName() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "no file was selected", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        PanelController srcPC = null;
        PanelController dstPC = null;
        if (leftPC.getSelectedFileName() != null) {
            srcPC = leftPC;
            dstPC = rightPC;
        }

        if (rightPC.getSelectedFileName() != null) {
            dstPC = leftPC;
            srcPC = rightPC;
        }

        Path srcPath = Paths.get(srcPC.getCurrentPath(), srcPC.getSelectedFileName());
        Path dscPAth = Paths.get(dstPC.getCurrentPath()).resolve(srcPath.getFileName().toString());

        try {
            Files.copy(srcPath, dscPAth);
            dstPC.updateList(Paths.get(dstPC.getCurrentPath()));
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to copy the specified file. File already exists", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
