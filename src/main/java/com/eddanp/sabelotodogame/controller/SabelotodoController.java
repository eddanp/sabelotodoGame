package com.eddanp.sabelotodogame.controller;

import com.eddanp.sabelotodogame.facade.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SabelotodoController implements Initializable {

    // atributos globales
    Game game = new Game();
    int[] randomQuestions;
    ArrayList<Integer> randomOptions;

    //atributos AnchorPane
    @FXML private AnchorPane initialPanel;
    @FXML private AnchorPane homePanel;
    @FXML private AnchorPane registrationPanel;
    @FXML private AnchorPane gamePanel;
    @FXML private AnchorPane settingsPanel;
    @FXML private AnchorPane addQuestionsPanel;

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

    //atributos addQuestionsPanel
    @FXML private TextArea addQuestionAreaText;
    @FXML private TextField trueAnswerTextField;
    @FXML private TextField oneFalseAnswerTextField;
    @FXML private TextField twoFalseAnswerTextField;
    @FXML private TextField threeFalseAnswerTextField;
    @FXML private ComboBox<String> difficultyComboBox;
    ObservableList<String> itemsDifficultyComboBox =
            FXCollections.observableArrayList("1","2","3","4","5");

    //atributos panel de registro jugador
    @FXML private TextField nameGamerTextField;
    @FXML private ComboBox questionsRoundComboBox;
    ObservableList<Integer> questionsRound =
            FXCollections.observableArrayList(1);

    //atributos panel de juego
    @FXML private Text questionsText;
    @FXML private Button questionsOneButton;
    @FXML private Button questionsTwoButton;
    @FXML private Button questionsThreeButton;
    @FXML private Button questionsFourButton;
    @FXML private Text scoreText;
    @FXML private Text roundText;


    //método ejecutar al inicializar el programa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialPanel.setVisible(true);
        homePanel.setVisible(true);
        registrationPanel.setVisible(false);
        gamePanel.setVisible(false);
        settingsPanel.setVisible(false);
        addQuestionsPanel.setVisible(false);
        difficultyComboBox.setItems(itemsDifficultyComboBox);
        questionsRoundComboBox.setItems(questionsRound);
        boolean existingFile=game.checkFileQuestions();
        if(!existingFile){
            gameButton.setDisable(true);
            historyButton.setDisable(true);
            predefinedQuestionsButton.setDisable(false);
            deleteFileButton.setDisable(true);
        }else {
            predefinedQuestionsButton.setDisable(true);
            game.sortQuestions();
            boolean minimum = game.minimumNumberQuestions();
            categoryOneText.setText(Integer.toString(game.getCategoryOne().size()));
            categoryTwoText.setText(Integer.toString(game.getCategoryTwo().size()));
            categoryThreeText.setText(Integer.toString(game.getCategoryThree().size()));
            categoryFourText.setText(Integer.toString(game.getCategoryFour().size()));
            categoryFiveText.setText(Integer.toString(game.getCategoryFive().size()));
            if(!minimum){
                gameButton.setDisable(true);
            }
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
        deleteFileButton.setDisable(false);
    }

    //método para botón agregar preguntas personalizadas
    public void onGenerateQuestionsButtonClick(ActionEvent event){
        settingsPanel.setVisible(false);
        addQuestionsPanel.setVisible(true);
        deleteFileButton.setDisable(false);
    }

    //método para regresar al panel home
    public void onReturnHomeButtonClick(ActionEvent event){
        boolean minimum = game.minimumNumberQuestions();
        if(minimum){
            gameButton.setDisable(false);
        }else{
            gameButton.setDisable(true);
        }
        settingsPanel.setVisible(false);
        homePanel.setVisible(true);
    }

    //método para botón cancelar agregar pregunta
    public void onCancelAddQuestionButtonClick(ActionEvent event){
        addQuestionsPanel.setVisible(false);
        settingsPanel.setVisible(true);
    }

    //mŕtodo para boton eliminar banco de preguntas
    public void onDeleteFileButton(ActionEvent event){
        game.deleteQuestionsFile();
        game.sortQuestions();
        categoryOneText.setText(Integer.toString(game.getCategoryOne().size()));
        categoryTwoText.setText(Integer.toString(game.getCategoryTwo().size()));
        categoryThreeText.setText(Integer.toString(game.getCategoryThree().size()));
        categoryFourText.setText(Integer.toString(game.getCategoryFour().size()));
        categoryFiveText.setText(Integer.toString(game.getCategoryFive().size()));
        predefinedQuestionsButton.setDisable(false);
        deleteFileButton.setDisable(true);
    }

    //método agregar preguntas personalizadas
    public void onAddQuestionButton(ActionEvent event){
        ArrayList<String> tempQuestion = new ArrayList<>();
        tempQuestion.add(addQuestionAreaText.getText());
        tempQuestion.add(trueAnswerTextField.getText());
        tempQuestion.add(oneFalseAnswerTextField.getText());
        tempQuestion.add(twoFalseAnswerTextField.getText());
        tempQuestion.add(threeFalseAnswerTextField.getText());
        tempQuestion.add(difficultyComboBox.getValue());
        game.addQuestions(tempQuestion);
        addQuestionAreaText.setText("");
        trueAnswerTextField.setText("");
        oneFalseAnswerTextField.setText("");
        twoFalseAnswerTextField.setText("");
        threeFalseAnswerTextField.setText("");
        difficultyComboBox.setValue(null);
        game.sortQuestions();
        categoryOneText.setText(Integer.toString(game.getCategoryOne().size()));
        categoryTwoText.setText(Integer.toString(game.getCategoryTwo().size()));
        categoryThreeText.setText(Integer.toString(game.getCategoryThree().size()));
        categoryFourText.setText(Integer.toString(game.getCategoryFour().size()));
        categoryFiveText.setText(Integer.toString(game.getCategoryFive().size()));
        predefinedQuestionsButton.setDisable(true);
    }

    //método botón jugar
    public void onGameButtonClick(ActionEvent event){
        homePanel.setVisible(false);
        registrationPanel.setVisible(true);
    }

    //método botón aceptar juego
    public void onAcceptGameButtonClick(ActionEvent event){
        registrationPanel.setVisible(false);
        gamePanel.setVisible(true);
        game.setName(nameGamerTextField.getText());
        randomQuestions = game.randomQuestions((int)(questionsRoundComboBox.getValue()));
        randomOptions=game.randomOptions();
        for (int i = 0; i < randomQuestions.length; i++) {
            System.out.println(randomQuestions[i]);
        }
        for (int i = 0; i < randomOptions.size(); i++) {
            System.out.println(randomOptions.get(i));
        }
        questionsText.setText((String)(game.getCategoryOne().get(randomQuestions[0]).get(0)));
        questionsOneButton.setText((String)(game.getCategoryOne().get(randomQuestions[0]).get(randomOptions.get(0))));
        questionsTwoButton.setText((String)(game.getCategoryOne().get(randomQuestions[0]).get(randomOptions.get(1))));
        questionsThreeButton.setText((String)(game.getCategoryOne().get(randomQuestions[0]).get(randomOptions.get(2))));
        questionsFourButton.setText((String)(game.getCategoryOne().get(randomQuestions[0]).get(randomOptions.get(3))));
        scoreText.setText("Puntaje: "+game.getTotalScore());
        roundText.setText("Ronda: "+game.getRound());
    }

    //método bonton volver a home desde panel de registro jugador
    public void onTwoReturnHomeButtonClick(ActionEvent event){
        registrationPanel.setVisible(false);
        homePanel.setVisible(true);
        nameGamerTextField.setText("");
        questionsRoundComboBox.setValue(null);

    }
    //método botón de respuesta 1
    public void onAnswerOneButtonClick(ActionEvent event){

    }
}