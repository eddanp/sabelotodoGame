package com.eddanp.sabelotodogame.controller;

import com.eddanp.sabelotodogame.facade.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SabelotodoController implements Initializable {

    // atributos globales
    Game game = new Game();

    //atributos AnchorPane
    @FXML private AnchorPane initialPanel;
    @FXML private AnchorPane homePanel;
    @FXML private AnchorPane registrationPanel;
    @FXML private AnchorPane gamePanel;
    @FXML private AnchorPane settingsPanel;

    //atributos homePanel
    @FXML private Button gameButton;
    @FXML private Button settingsButton;
    @FXML private Button historyButton;

    //atributis settingsPanel
    @FXML private Button predefinedQuestionsButton;
    @FXML private Button generateQuestionsButton;
    @FXML private Button deleteFileButton;
    @FXML private Text categoryOneText;
    @FXML private Text categoryTwoText;
    @FXML private Text categoryThreeText;
    @FXML private Text categoryFourText;
    @FXML private Text categoryFiveText;

    //método ejecutar al inicializar el programa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialPanel.setVisible(true);
        homePanel.setVisible(true);
        registrationPanel.setVisible(false);
        gamePanel.setVisible(false);
        settingsPanel.setVisible(false);
        boolean existingFile=game.checkFileQuestions();
        if(!existingFile){
            gameButton.setDisable(true);
            historyButton.setDisable(true);
            predefinedQuestionsButton.setDisable(false);
            deleteFileButton.setDisable(true);
        }else{
            predefinedQuestionsButton.setDisable(true);
            game.sortQuestions();
            categoryOneText.setText(Integer.toString(game.getCategoryOne().size()));
            categoryTwoText.setText(Integer.toString(game.getCategoryTwo().size()));
            categoryThreeText.setText(Integer.toString(game.getCategoryThree().size()));
            categoryFourText.setText(Integer.toString(game.getCategoryFour().size()));
            categoryFiveText.setText(Integer.toString(game.getCategoryFive().size()));
        }
    }

    //metodo para entrar a configuración
    public void onSettingsButtonClick(ActionEvent event){
        homePanel.setVisible(false);
        settingsPanel.setVisible(true);
    }

    //método generar archivo de preguntas predefinidas
    public void onPredefinedQuestionsFileClick(ActionEvent event){
        game.predefinedQuestionsFile();
        game.sortQuestions();
        categoryOneText.setText(Integer.toString(game.getCategoryOne().size()));
        categoryTwoText.setText(Integer.toString(game.getCategoryTwo().size()));
        categoryThreeText.setText(Integer.toString(game.getCategoryThree().size()));
        categoryFourText.setText(Integer.toString(game.getCategoryFour().size()));
        categoryFiveText.setText(Integer.toString(game.getCategoryFive().size()));
        predefinedQuestionsButton.setDisable(true);
    }
}