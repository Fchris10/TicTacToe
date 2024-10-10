package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrisController {
    @FXML public Button idButton1, idButton2, idButton3, idButton4, idButton5, idButton6, idButton7, idButton8, idButton9;
    @FXML public Button idRematch, idReset;
    @FXML public TextField idBlue, idRed, idText;
    @FXML public ImageView idImageBlue, idImageRed, idBackground, idHome;

    List<Button> listOfButtons;
    int pointBlue = 0, pointRed = 0;
    boolean PlayerX = true;
    boolean valueDraw = true;
    int count = 0;

    String nameSong = "C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\java\\media\\summerSong.mp3";
    Media song = new Media(new File(nameSong).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(song);

    public void initialize(){
        listOfButtons = new ArrayList<>(List.of(idButton1, idButton2, idButton3, idButton4, idButton5, idButton6, idButton7, idButton8, idButton9));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }

    public void onButton1Clicked() { onButtonClicked(idButton1); }
    public void onButton2Clicked() { onButtonClicked(idButton2); }
    public void onButton3Clicked() { onButtonClicked(idButton3); }
    public void onButton4Clicked() { onButtonClicked(idButton4); }
    public void onButton5Clicked() { onButtonClicked(idButton5); }
    public void onButton6Clicked() { onButtonClicked(idButton6); }
    public void onButton7Clicked() { onButtonClicked(idButton7); }
    public void onButton8Clicked() { onButtonClicked(idButton8); }
    public void onButton9Clicked() { onButtonClicked(idButton9); }

    public void setValueDraw(boolean valueDraw) {
        if (valueDraw) {
            count++;
        }
        if (count == 9) {
            idText.setText("DRAW");
            disableAllButtons();
        }
    }

    public void setButtonBackground(Button button, Color color) {
        button.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    public void setWinningCombinationBackground(Button... buttons) {
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGREEN, null, null);
        Background background = new Background(backgroundFill);
        for (Button button : buttons) {
            button.setBackground(background);
        }
        setOtherButtonsBackground(null, buttons);
    }

    public void setOtherButtonsBackground(Background background, Button... winningButtons) {
        Button[] allButtons = {idButton1, idButton2, idButton3, idButton4, idButton5, idButton6, idButton7, idButton8, idButton9};
        for (Button button : allButtons) {
            boolean isWinningButton = false;
            for (Button winButton : winningButtons) {
                if (button == winButton) {
                    isWinningButton = true;
                    break;
                }
            }
            if (!isWinningButton) {
                button.setBackground(background);
            }
        }
    }

    public void onButtonClicked(Button button) {
        if (PlayerX) {
            button.setText("X");
            setButtonBackground(button, Color.LIGHTBLUE);
            button.setOpacity(1);
            PlayerX = false;
        } else {
            button.setText("O");
            setButtonBackground(button, Color.CORAL);
            button.setOpacity(1);
            PlayerX = true;
        }
        button.setDisable(true);
        checkWinner();
    }

    public void checkWinner() {
        Button[][] winningCombinations = {
                {idButton1, idButton2, idButton3},
                {idButton4, idButton5, idButton6},
                {idButton7, idButton8, idButton9},
                {idButton1, idButton4, idButton7},
                {idButton2, idButton5, idButton8},
                {idButton3, idButton6, idButton9},
                {idButton1, idButton5, idButton9},
                {idButton3, idButton5, idButton7}
        };

        for (Button[] combination : winningCombinations) {
            if (combination[0].getText().equals("X") && combination[1].getText().equals("X") && combination[2].getText().equals("X")) {
                valueDraw = false;
                idText.setText("BLUE WINS");
                pointBlue++;
                BlueImages();
                idBlue.setText(String.valueOf(pointBlue));
                setWinningCombinationBackground(combination);
                return;
            }
            if (combination[0].getText().equals("O") && combination[1].getText().equals("O") && combination[2].getText().equals("O")) {
                valueDraw = false;
                idText.setText("RED WINS");
                pointRed++;
                RedImages();
                idRed.setText(String.valueOf(pointRed));
                setWinningCombinationBackground(combination);
                return;
            }
        }
        setValueDraw(valueDraw);
    }

    public void onRematchButtonClicked() {
        idText.clear();
        for(Button b : listOfButtons){
            b.setText("");
            b.setDisable(false);
            b.setBackground(new Background(new BackgroundFill(null, null, null)));
        }

        DefaultImages();
        PlayerX = true;
        count = 0;
        valueDraw = true;
    }

    public void onResetButtonClicked() {
        pointBlue = 0;
        pointRed = 0;
        idBlue.clear();
        idRed.clear();
        DefaultImages();
        onRematchButtonClicked();
    }

    public void disableAllButtons() {
        for(Button b : listOfButtons){
            b.setDisable(true);
        }
    }

    public void BlueImages() {
        File happyBlue = new File("C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\resources\\Image\\HappyBlue.png");
        File sadRed = new File("C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\resources\\Image\\SadRed.png");
        idImageBlue.setImage(new Image(happyBlue.toURI().toString()));
        idImageRed.setImage(new Image(sadRed.toURI().toString()));
    }

    public void RedImages() {
        File happyRed = new File("C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\resources\\Image\\HappyRed.png");
        File sadBlue = new File("C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\resources\\Image\\SadBlue.png");
        idImageRed.setImage(new Image(happyRed.toURI().toString()));
        idImageBlue.setImage(new Image(sadBlue.toURI().toString()));
    }

    public void DefaultImages() {
        File Red = new File("C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\resources\\Image\\Red.png");
        File Blue = new File("C:\\Users\\comet\\IdeaProjects\\TicTacToe\\src\\main\\resources\\Image\\Blue.png");
        idImageRed.setImage(new Image(Red.toURI().toString()));
        idImageBlue.setImage(new Image(Blue.toURI().toString()));
    }

    public void onHomeClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sceneStart.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) idHome.getScene().getWindow();
        stage.setScene(new Scene(root));
        mediaPlayer.stop();
    }
}
