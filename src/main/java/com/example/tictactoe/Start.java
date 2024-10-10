package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Start {

    @FXML
    public Button idStory, idNormalTris;

    public void on1Vs1ButtonClicked() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TrisController.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) idNormalTris.getScene().getWindow();
            stage.setScene(new Scene(root));
    }

    public void onStoryButtonClicked() throws IOException {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("BotMode.fxml"));
            Parent root1 = fxmlLoader1.load();
            Stage stage = (Stage) idStory.getScene().getWindow();
            stage.setScene(new Scene(root1));
    }
}