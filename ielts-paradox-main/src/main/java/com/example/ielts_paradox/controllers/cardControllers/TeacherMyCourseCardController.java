package com.example.ielts_paradox.controllers.cardControllers;

import com.example.ielts_paradox.Alerts.DeleteAlert;
import com.example.ielts_paradox.SocketNetworking.Course.MultiThreadedSocketServer;
import com.example.ielts_paradox.SocketNetworking.Course.SocketClient;
import com.example.ielts_paradox.controllers.AllControl.TeacherApprovedStudentsTableController;
import com.example.ielts_paradox.controllers.AllControl.TeacherCourseRequestController;
import com.example.ielts_paradox.database.ForChat;
import com.example.ielts_paradox.database.ForCourse;
import com.example.ielts_paradox.models.CourseInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherMyCourseCardController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label title;

    @FXML
    private Label id_;
    @FXML
    private Label msgPort;


    public void goToReqTable(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/teacher/pages/courses/teacherCourseRequest.fxml"));
        root = fxmlLoader.load();
        TeacherCourseRequestController tcrt = fxmlLoader.getController();
        CourseInfo ci = new ForCourse().getCourseById(id_.getText());
        tcrt.setData(ci,"0");
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void approvedHandler(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/teacher/pages/courses/teacherApprovedStudentsTable.fxml"));
        root = fxmlLoader.load();
        TeacherApprovedStudentsTableController tastc = fxmlLoader.getController();
        CourseInfo ci = new ForCourse().getCourseById(id_.getText());
        tastc.setData(ci,"0");
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void removeHandler(ActionEvent event) {
        DeleteAlert.displayCustomAlert("Course",id_.getText());
    }

    public void chatHandler(ActionEvent event) throws IOException {
        if(!new ForChat().isRunning(Integer.parseInt(msgPort.getText()))){
            new MultiThreadedSocketServer().startThreading(Integer.parseInt(msgPort.getText()));
            new ForChat().updatePort(Integer.parseInt(msgPort.getText()),true);
        }

        new SocketClient().runClient(Integer.parseInt(msgPort.getText()),new ForCourse().getCourseById(id_.getText()));
    }
    public void setData(CourseInfo bi){
        title.setText(bi.title);
        id_.setText(bi._id);
        msgPort.setText(bi.messagePort+"");
    }
}
