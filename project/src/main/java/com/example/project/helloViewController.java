package com.example.project;

//imports
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class helloViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginInput;

    @FXML
    private Button okayButton;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button signUpButton;

    //just in case
//    @FXML
//    void initialize() {
//        okayButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку Готово");
//        });
//
//        signUpButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку регистрации");
//        });
//    }

    private Stage stage;
    private Scene scene;
    //private Parent root;

    public void switchToListSample(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListSample.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegistrationScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
