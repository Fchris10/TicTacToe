package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BotMode {

    @FXML
    public TextField idAI, idHuman, idTextWin;
    public Button idButton11, idButton22, idButton33, idButton44, idButton55, idButton66, idButton77, idButton88, idButton99;
    public ImageView idHome;

    List<Button> listOfButtons;
    boolean playerHuman = true;
    int count = 0;
    int pointHuman = 0, pointAi = 0;
    boolean gameOver = false;

    public void initialize(){
        listOfButtons = List.of(idButton11, idButton22, idButton33, idButton44, idButton55, idButton66, idButton77, idButton88, idButton99);
    }
    public void onButtonClicked(Button button) {
        if (gameOver) return;
        if (playerHuman && button.getText().equals("x")) {
            button.setText("X");
            button.setOpacity(1);
            button.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
            playerHuman = false;
            count++;
            checkWin();
            if (!gameOver) randomNumber();
        }
    }

    public void onButton11Clicked() { onButtonClicked(idButton11); }
    public void onButton22Clicked() { onButtonClicked(idButton22); }
    public void onButton33Clicked() { onButtonClicked(idButton33); }
    public void onButton44Clicked() { onButtonClicked(idButton44); }
    public void onButton55Clicked() { onButtonClicked(idButton55); }
    public void onButton66Clicked() { onButtonClicked(idButton66); }
    public void onButton77Clicked() { onButtonClicked(idButton77); }
    public void onButton88Clicked() { onButtonClicked(idButton88); }
    public void onButton99Clicked() { onButtonClicked(idButton99); }

    public void randomNumber() {
        if (gameOver) return;

        Random random = new Random();
        int value = random.nextInt(9) + 1;
        playerHuman = true;

        switch (value) {
            case 1:
                if (idButton11.getText().equals("x")) {
                    idButton11.setText("O");
                    idButton11.setOpacity(1);
                    idButton11.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 2:
                if (idButton22.getText().equals("x")) {
                    idButton22.setText("O");
                    idButton22.setOpacity(1);
                    idButton22.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 3:
                if (idButton33.getText().equals("x")) {
                    idButton33.setText("O");
                    idButton33.setOpacity(1);
                    idButton33.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 4:
                if (idButton44.getText().equals("x")) {
                    idButton44.setText("O");
                    idButton44.setOpacity(1);
                    idButton44.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 5:
                if (idButton55.getText().equals("x")) {
                    idButton55.setText("O");
                    idButton55.setOpacity(1);
                    idButton55.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 6:
                if (idButton66.getText().equals("x")) {
                    idButton66.setText("O");
                    idButton66.setOpacity(1);
                    idButton66.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 7:
                if (idButton77.getText().equals("x")) {
                    idButton77.setText("O");
                    idButton77.setOpacity(1);
                    idButton77.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 8:
                if (idButton88.getText().equals("x")) {
                    idButton88.setText("O");
                    idButton88.setOpacity(1);
                    idButton88.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
            case 9:
                if (idButton99.getText().equals("x")) {
                    idButton99.setText("O");
                    idButton99.setOpacity(1);
                    idButton99.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
                    checkWin();
                    count++;
                    return;
                }
                break;
        }
        randomNumber();
    }

    public void checkWin() {
        Button[][] winPatterns = {
                {idButton11, idButton22, idButton33},
                {idButton44, idButton55, idButton66},
                {idButton77, idButton88, idButton99},
                {idButton11, idButton44, idButton77},
                {idButton22, idButton55, idButton88},
                {idButton33, idButton66, idButton99},
                {idButton11, idButton55, idButton99},
                {idButton33, idButton55, idButton77}
        };

        for (Button[] pattern : winPatterns) {
            if (checkPattern(pattern, "X")) {
                pointHuman++;
                idTextWin.setText("HUMAN WINS");
                setGreenButtons(pattern);
                idHuman.setText(String.valueOf(pointHuman));
                setDefault();
                gameOver = true;
                return;
            } else if (checkPattern(pattern, "O")) {
                pointAi++;
                idTextWin.setText("BOT WINS");
                setGreenButtons(pattern);
                idAI.setText(String.valueOf(pointAi));
                setDefault();
                gameOver = true;
                return;
            }
        }
        if (count == 9) {
            idTextWin.setText("DRAW");
            setDefault();
            gameOver = true;
        }
    }

    private boolean checkPattern(Button[] buttons, String player) {
        return buttons[0].getText().equals(player) && buttons[1].getText().equals(player) && buttons[2].getText().equals(player);
    }

    private void setGreenButtons(Button... buttons) {
        setNullBackground();
        for (Button button : buttons) {
            button.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
        }
    }

    private void setDefault() {
        for (Button button : listOfButtons) {
            button.setDisable(true);
        }
    }

    private void setNullBackground() {
        for (Button button : listOfButtons) {
            button.setBackground(null);
        }
    }

    public void onRetryClicked() {
        idTextWin.clear();
        for(Button b : listOfButtons){
            b.setText("x");
            b.setOpacity(0);
            b.setDisable(false);
        }

        setNullBackground();
        playerHuman = true;
        count = 0;
        gameOver = false;
    }
    public void onHomeClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sceneStart.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) idHome.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
