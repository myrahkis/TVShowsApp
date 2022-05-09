package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

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

    @FXML
    void initialize() {
        okayButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку Готово");
        });

        signUpButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку регистрации");
        });
    }

}
