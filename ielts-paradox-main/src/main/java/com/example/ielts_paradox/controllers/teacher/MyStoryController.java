package com.example.ielts_paradox.controllers.teacher;

import com.example.ielts_paradox.controllers.cardControllers.MyStoryCardController;
import com.example.ielts_paradox.database.ForStories;
import com.example.ielts_paradox.models.StoryInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MyStoryController implements Initializable {

    @FXML
    private VBox myBlogTable;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setMyBlogTable();
    }
    public void setMyBlogTable(){
        ArrayList<StoryInfo> asi = new ForStories().getMyStories();
        myBlogTable.getChildren().clear();
        for (StoryInfo si:asi){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxmls/teacher/pages/stories/myStoryCard.fxml"));
            try {
                HBox paneee = fxmlLoader.load();
                MyStoryCardController mscc = fxmlLoader.getController();
                mscc.setData(si);
                myBlogTable.getChildren().add(paneee);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void reloadPage(javafx.event.ActionEvent event) {
        setMyBlogTable();
    }
}