package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sceneStart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }
    public void showTrisScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tris.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("TicTacToe");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
