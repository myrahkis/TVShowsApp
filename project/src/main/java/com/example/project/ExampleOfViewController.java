package com.example.project;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExampleOfViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea actorsTextFeild;

    @FXML
    private TextArea annotationTextField;

    @FXML
    private TextField directorTextField;

    @FXML
    private AnchorPane genreTextField;

    @FXML
    private TextField ratingTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private Button backButton;

//    @FXML
//    void initialize() {
//        backButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку Назад");
//        });
//    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

