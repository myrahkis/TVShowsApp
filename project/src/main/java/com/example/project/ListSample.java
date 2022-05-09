package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ListSample {

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
    void initialize() {
        addButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку добавления");
        });

        deleteButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку удаления");
        });

        stopWatchingButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку Заброшено");
        });

        watchedButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку Просмотрено");
        });

        watchingButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали на кнопку Смотрю");
        });
    }
}
