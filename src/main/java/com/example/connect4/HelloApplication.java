package com.example.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

            GridPane rootGridPane = loader.load();

            controller = loader.getController();
            controller.createPlayground();

            MenuBar menuBar= createMenu();
            menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

            Scene scene= new Scene(rootGridPane);
            stage.setScene(scene);
            stage.setTitle("CONNECT FOUR");
            stage.setResizable(false);
            stage.show();

    }

    private MenuBar createMenu(){
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        MenuItem  resetGame = new MenuItem("Reset game");
        resetGame.setOnAction(actionEvent -> controller.resetGame() );

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit game");
        exitGame.setOnAction(actionEvent -> exitGame());
        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        Menu helpMenu = new Menu("Help");

        MenuItem aboutgame = new MenuItem("About Connect4");
        aboutgame.setOnAction(actionEvent -> aboutConnect());
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutMe());

        helpMenu.getItems().addAll(aboutgame,separator,aboutMe);

        MenuBar menuBar =new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;


    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("ARYAN RAMEDWAR");
        alert.setContentText("JUST PLAY THIS GAME AND CHILL PEOPLE");
        alert.show();
    }

    private void aboutConnect() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();

    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}