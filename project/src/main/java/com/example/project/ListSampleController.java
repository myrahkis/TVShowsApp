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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListSampleController implements Initializable {
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
    private TableView<TVShows> listOfWatching;

    @FXML
    private TableView<TVShows> listOfWatched;

    @FXML
    private TableView<TVShows> listOfStoppedWatching;

    @FXML
    private TableColumn<TVShows, String> columnGenreStopped;

    @FXML
    private TableColumn<TVShows, String> columnGenreWatched;

    @FXML
    private TableColumn<TVShows, String> columnGenreWatching;

    @FXML
    private TableColumn<TVShows, String> columnNameStopped;

    @FXML
    private TableColumn<TVShows, String> columnNameWatched;

    @FXML
    private TableColumn<TVShows, String> columnNameWatching;

    @FXML
    private TableColumn<TVShows, Integer> columnYearStopped;

    @FXML
    private TableColumn<TVShows, Integer> columnYearWatched;

    @FXML
    private TableColumn<TVShows, Integer> columnYearWatching;

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

    // initializing columns
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // watching
        columnNameWatching.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnYearWatching.setCellValueFactory(new PropertyValueFactory<>("year"));
        columnGenreWatching.setCellValueFactory(new PropertyValueFactory<>("genre"));

        // watched
        columnNameWatched.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnYearWatched.setCellValueFactory(new PropertyValueFactory<>("year"));
        columnGenreWatched.setCellValueFactory(new PropertyValueFactory<>("genre"));

        //stopped watching
        columnNameStopped.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnYearStopped.setCellValueFactory(new PropertyValueFactory<>("year"));
        columnGenreStopped.setCellValueFactory(new PropertyValueFactory<>("genre"));
    }

    @FXML
    void addNameToWatching(MouseEvent event) {
        TVShows tvShows = new TVShows(name.getText(), Integer.parseInt(year.getText()), genre.getText());
        listOfWatching.getItems().add(tvShows);
    }

//    @FXML
//    void deleteNameFromWatching(MouseEvent event) {
//        int selectedTVShow = listOfWatching.getSelectionModel().getSelectedIndex();
//        listOfWatching.getItems().remove(selectedTVShow);
//    }

    @FXML
    void addNameToWatched(MouseEvent event) {
        TVShows tvShows = new TVShows(name.getText(), Integer.parseInt(year.getText()), genre.getText());
        listOfWatched.getItems().add(tvShows);
    }

//    @FXML
//    void deleteNameFromWatched(MouseEvent event) {
//        int selectedTVShow = listOfWatched.getSelectionModel().getSelectedIndex();
//        listOfWatched.getItems().remove(selectedTVShow);
//    }

    @FXML
    void addNameToStoppedWatching(MouseEvent event) {
        TVShows tvShows = new TVShows(name.getText(), Integer.parseInt(year.getText()), genre.getText());
        listOfStoppedWatching.getItems().add(tvShows);
    }

//    @FXML
//    void deleteNameFromStoppedWatching(MouseEvent event) {
//        int selectedTVShow = listOfStoppedWatching.getSelectionModel().getSelectedIndex();
//        listOfStoppedWatching.getItems().remove(selectedTVShow);
//    }

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


