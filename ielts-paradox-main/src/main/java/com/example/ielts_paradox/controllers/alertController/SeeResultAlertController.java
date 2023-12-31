package com.example.ielts_paradox.controllers.alertController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class SeeResultAlertController{
    @FXML
    private Stage stage;
    private Parent root;
    private Scene scene;
    private Stage dialogStage;
    String urii;


    @FXML
    private Label bandscore;

    @FXML
    private Label title;

    @FXML
    public void setDialogStage(Stage stage) {
        dialogStage = stage;
    }

    @FXML
    public void setTitle(String m) {
        title.setText(m);
    }
    @FXML
    public void setUrii(String m) {
        urii = m;
    }

    @FXML
    public void setBandscore(String m) {
        bandscore.setText(m);
    }



    @FXML
    void closeAlert(ActionEvent event) {
        dialogStage.close();

    }

    @FXML
    void studentPaperLink(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI(urii));
    }
}
