package com.example.project;

//imports
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class ListSampleController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //add
    @FXML
    private Button addButtonStoppedWatching;

    @FXML
    private Button addButtonWatched;

    @FXML
    private Button addButtonWatching;

    //delete
    @FXML
    private Button deleteButtonStoppedWatching;

    @FXML
    private Button deleteButtonWatched;

    @FXML
    private Button deleteButtonWatching;

    //clear
    @FXML
    private Button clearStoppedWatching;

    @FXML
    private Button clearWatched;

    @FXML
    private Button clearWatching;

    //save
    @FXML
    private Button saveButtonStoppedWatching;

    @FXML
    private Button saveButtonWatched;

    @FXML
    private Button saveButtonWatching;

    @FXML
    private Label list;

    @FXML
    private Button exitButton;

    //table view
    @FXML
    private TableView<TVShows> listOfWatching;

    @FXML
    private TableView<TVShows> listOfWatched;

    @FXML
    private TableView<TVShows> listOfStoppedWatching;

    //all columns
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

    //texts adds
    @FXML
    private TextField name;

    @FXML
    private TextField year;

    @FXML
    private TextField genre;

    @FXML
    private AnchorPane scenePane;

    ObservableList<TVShows> observableShowsList = FXCollections.observableArrayList();
    FileChooser fileChooser = new FileChooser();
    Stage secStage = new Stage();

    //    private Scene scene;
    //    private Parent root;

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

    // watching
    @FXML
    void addNameToWatching(MouseEvent event) {
        TVShows tvShows = new TVShows(name.getText(), year.getText(), genre.getText());
        listOfWatching.getItems().add(tvShows);
        observableShowsList.add(tvShows);
    }

    @FXML
    void deleteNameFromWatching(MouseEvent event) {
        int selectedTVShow = listOfWatching.getSelectionModel().getSelectedIndex();
        listOfWatching.getItems().remove(selectedTVShow);
        observableShowsList.remove(selectedTVShow);
    }

    @FXML
    void clearWatching(MouseEvent event) {
        observableShowsList.removeAll(listOfWatching.getItems());
        listOfWatching.getItems().clear();
    }

    // watched
    @FXML
    void addNameToWatched(MouseEvent event) {
        TVShows tvShows = new TVShows(name.getText(), year.getText(), genre.getText());
        listOfWatched.getItems().add(tvShows);
        observableShowsList.add(tvShows);
    }

    @FXML
    void deleteNameFromWatched(MouseEvent event) {
        int selectedTVShow = listOfWatched.getSelectionModel().getSelectedIndex();
        listOfWatched.getItems().remove(selectedTVShow);
        observableShowsList.remove(selectedTVShow);
    }

    @FXML
    void clearWatched(MouseEvent event) {
        observableShowsList.removeAll(listOfWatched.getItems());
        listOfWatched.getItems().clear();
    }

    // stopped watching
    @FXML
    void addNameToStoppedWatching(MouseEvent event) {
        TVShows tvShows = new TVShows(name.getText(), year.getText(), genre.getText());
        listOfStoppedWatching.getItems().add(tvShows);
        observableShowsList.add(tvShows);
    }

    @FXML
    void deleteNameFromStoppedWatching(MouseEvent event) {
        int selectedTVShow = listOfStoppedWatching.getSelectionModel().getSelectedIndex();
        listOfStoppedWatching.getItems().remove(selectedTVShow);
        observableShowsList.remove(selectedTVShow);
    }

    @FXML
    void clearStoppedWatching(MouseEvent event) {
        observableShowsList.removeAll(listOfStoppedWatching.getItems());
        listOfStoppedWatching.getItems().clear();
    }

    // exit
    @FXML
    void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выход");
        alert.setHeaderText("Вы собираетесь выйти!");
        alert.setContentText("Вы уверены, что хотите выйти?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Вы вышли из приложения!");
            stage.close();
        }
    }

    @FXML
    void savingAll(MouseEvent event) {
        fileChooser.setTitle("Saving TV shows");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        if (observableShowsList.isEmpty()) {
            Alert emptyList = new Alert(Alert.AlertType.ERROR, "Пустая таблица!", ButtonType.OK);
            emptyList.setContentText("Ваш список пуст!");
            emptyList.showAndWait();
            if (emptyList.getResult() == ButtonType.OK) {
                emptyList.close();
            }
        } else {
            File file = fileChooser.showSaveDialog(secStage);
            if (file != null) {
                save(file, listOfWatching.getItems());
            }
        }
    }

    public void save(File file, ObservableList<TVShows> tvShows) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (TVShows tvShow : observableShowsList) {
                bw.write(tvShow.toString());
                bw.newLine();
            }
            System.out.println(observableShowsList.toString());
            bw.close();
        } catch (IOException e) {
            System.out.println("Ошибка с файлом");
        }
    }
}

//just in case
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


