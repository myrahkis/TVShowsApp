package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationSceneController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okaySignUpButton;

    @FXML
    private TextField signUpEmail;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    private ChoiceBox<String> signUpSexChoice;

    private final String[] sex = {"female", "male"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUpSexChoice.getItems().addAll(sex);
    }
}