package com.example.ielts_paradox.controllers;

import com.example.ielts_paradox.Alerts.FormAlert;
import com.example.ielts_paradox.models.UserInfo;
import com.example.ielts_paradox.singletons.UserSingleTon;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable{
    @FXML
    private Label bio;

    @FXML
    private MFXButton bioEditor;

    @FXML
    private Label contact;

    @FXML
    private Label email;

    @FXML
    private Label name;

    @FXML
    private Label password;

    @FXML
    private MFXButton profilePicEditor;

    @FXML
    private Label topName;

    @FXML
    private Label userType;

    @FXML
    public void bioEditor(ActionEvent event) {
        System.out.println("I am here");
        FormAlert.displayCustomAlert("Bio","0");
        setData();
        System.out.println("Work Done");
    }

    @FXML
    public void contactEditor(ActionEvent event) {
        FormAlert.displayCustomAlert("Contact","0");
        setData();
    }

    @FXML
    public void emailEditor(ActionEvent event) {
        FormAlert.displayCustomAlert("Email","0");
        setData();
    }

    @FXML
    public void nameEditor(ActionEvent event) {
        FormAlert.displayCustomAlert("Full Name","0");
        setData();
    }

    @FXML
    public void passwordEditor(ActionEvent event) {
        FormAlert.displayCustomAlert("Password","0");
        setData();
    }

    @FXML
    public void profilePicEditor(ActionEvent event) {

    }
    public void setData(){
        UserInfo info = UserSingleTon.getInstance(new UserInfo()).getUser();
        topName.setText(info.fullName);
        if(info.isTeacher){
            userType.setText("Teacher");
        }else{
            userType.setText("Student");
        }
        email.setText(info.email);
        name.setText(info.fullName);
        contact.setText(info.contactNumber);
        bio.setText(info.bio);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
