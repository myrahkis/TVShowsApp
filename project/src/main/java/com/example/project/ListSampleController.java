package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListSampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label list;

    @FXML
    private Button stopWatchingButton;

    @FXML
    private Button watchedButton;

    @FXML
    private Button watchingButton;

    @FXML
    private Button exitButton;

    @FXML
    private ListView<String> listOfTVShows;

    String[] name = {"Breaking bad", "House, M.D.", "Stranger Things"};

    String currentTVShow;

//    public void initialize() {
//        listOfTVShows.getItems().addAll(name);
//    }

    public void initialize() {
        listOfTVShows.getItems().addAll(name);

        listOfTVShows.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                currentTVShow = listOfTVShows.getSelectionModel().getSelectedItem();

//                System.out.println(currentTVShow);
            }
        });
    }

//    @FXML
//    void initialize() {
//        addButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку добавления");
//        });
//
//        deleteButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку удаления");
//        });
//
//        stopWatchingButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку Заброшено");
//        });
//
//        watchedButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку Просмотрено");
//        });
//
//        watchingButton.setOnAction(actionEvent -> {
//            System.out.println("Вы нажали на кнопку Смотрю");
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

    public void switchToExampleOfView(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

