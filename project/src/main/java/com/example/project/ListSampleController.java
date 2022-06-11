package com.example.project;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListSampleController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButtonStoppedWatching;

    @FXML
    private Button addButtonWatched;

    @FXML
    private Button addButtonWatching;

    @FXML
    private Button deleteButtonStoppedWatching;

    @FXML
    private Button deleteButtonWatched;

    @FXML
    private Button deleteButtonWatching;

    @FXML
    private Button clearStoppedWatching;

    @FXML
    private Button clearWatched;

    @FXML
    private Button clearWatching;

    @FXML
    private Label list;

    @FXML
    private Button exitButton;

    @FXML
    private TableView<?> listOfWatching;

    @FXML
    private TableView<?> listOfWatched;

    @FXML
    private TableView<?> listOfStoppedWatching;

    @FXML
    private TableColumn<?, ?> columnGenreStopped;

    @FXML
    private TableColumn<?, ?> columnGenreWatched;

    @FXML
    private TableColumn<?, ?> columnGenreWatching;

    @FXML
    private TableColumn<?, ?> columnNameStopped;

    @FXML
    private TableColumn<?, ?> columnNameWatched;

    @FXML
    private TableColumn<?, ?> columnNameWatching;

    @FXML
    private TableColumn<?, ?> columnYearStopped;

    @FXML
    private TableColumn<?, ?> columnYearWatched;

    @FXML
    private TableColumn<?, ?> columnYearWatching;

    @FXML
    private TextField name;

    @FXML
    private TextField year;

    @FXML
    private TextField genre;

    @FXML
    private AnchorPane scenePane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void addNameToWatching(MouseEvent event) {
        listOfWatching.getItems().add(name.getText());
    }

    @FXML
    void deleteNameFromWatching(MouseEvent event) {
        int selectedTVShow = listOfWatching.getSelectionModel().getSelectedIndex();
        listOfWatching.getItems().remove(selectedTVShow);
    }

    @FXML
    void addNameToWatched(MouseEvent event) {
        listOfWatched.getItems().add(name.getText());
    }

    @FXML
    void deleteNameFromWatched(MouseEvent event) {
        int selectedTVShow = listOfWatched.getSelectionModel().getSelectedIndex();
        listOfWatched.getItems().remove(selectedTVShow);
    }

    @FXML
    void addNameToStoppedWatching(MouseEvent event) {
        listOfStoppedWatching.getItems().add(name.getText());
    }

    @FXML
    void deleteNameFromStoppedWatching(MouseEvent event) {
        int selectedTVShow = listOfStoppedWatching.getSelectionModel().getSelectedIndex();
        listOfStoppedWatching.getItems().remove(selectedTVShow);
    }

    @FXML
    void clearWatching(MouseEvent event) {
        listOfWatching.getItems().clear();
    }

    @FXML
    void clearWatched(MouseEvent event) {
        listOfWatched.getItems().clear();
    }

    @FXML
    void clearStoppedWatching(MouseEvent event) {
        listOfStoppedWatching.getItems().clear();
    }

    @FXML
    void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выход");
        alert.setHeaderText("Вы собираетесь выйти!");
        alert.setContentText("Вы уверены, что хотите выйти?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Вы вышли из приложения!");
            stage.close();
        }
    }
}

//    public void switchToHelloView(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

//    String[] name = {"Breaking bad", "House, M.D.", "Stranger Things"};
//
//    String currentTVShow;

//    public void initialize() {
//        listOfTVShows.getItems().addAll(name);
//    }

//    public void initialize() {
//        listOfTVShows.getItems().addAll(name);
//
//        listOfTVShows.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                currentTVShow = listOfTVShows.getSelectionModel().getSelectedItem();
//
//                System.out.println(currentTVShow);
//            }
//        });
//    }

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
}

