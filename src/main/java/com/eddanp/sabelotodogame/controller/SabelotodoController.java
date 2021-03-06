package com.eddanp.sabelotodogame.controller;

import com.eddanp.sabelotodogame.facade.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SabelotodoController implements Initializable {

    // atributos globales
    Game game;
    private ArrayList<Integer> randomQuestions;
    private ArrayList<Integer> randomOptions;
    private String validator;
    File historyFile;
    URL url;
    ResourceBundle resource;

    //atributos AnchorPane
    @FXML
    private AnchorPane initialPanel;
    @FXML
    private AnchorPane homePanel;
    @FXML
    private AnchorPane registrationPanel;
    @FXML
    private AnchorPane gamePanel;
    @FXML
    private AnchorPane settingsPanel;
    @FXML
    private AnchorPane addQuestionsPanel;

    //atributos homePanel
    @FXML
    private Button gameButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button historyButton;
    @FXML private Text notificationText;

    //atributis settingsPanel
    @FXML
    private Button predefinedQuestionsButton;
    @FXML
    private Button generateQuestionsButton;
    @FXML
    private Button deleteFileButton;
    @FXML
    private Text categoryOneText;
    @FXML
    private Text categoryTwoText;
    @FXML
    private Text categoryThreeText;
    @FXML
    private Text categoryFourText;
    @FXML
    private Text categoryFiveText;

    //atributos addQuestionsPanel
    @FXML
    private TextArea addQuestionAreaText;
    @FXML
    private TextField trueAnswerTextField;
    @FXML
    private TextField oneFalseAnswerTextField;
    @FXML
    private TextField twoFalseAnswerTextField;
    @FXML
    private TextField threeFalseAnswerTextField;
    @FXML
    private ComboBox<String> difficultyComboBox;
    ObservableList<String> itemsDifficultyComboBox =
            FXCollections.observableArrayList("1", "2", "3", "4", "5");

    //atributos panel de registro jugador
    @FXML
    private TextField nameGamerTextField;
    @FXML
    private ComboBox questionsRoundComboBox;
    ObservableList<Integer> questionsRound =
            FXCollections.observableArrayList(1,2,3,4,5);

    //atributos panel de juego
    @FXML
    private Text questionsText;
    @FXML
    private Button questionsOneButton;
    @FXML
    private Button questionsTwoButton;
    @FXML
    private Button questionsThreeButton;
    @FXML
    private Button questionsFourButton;
    @FXML
    private Text scoreText;
    @FXML
    private Text roundText;
    @FXML private Text questionsNText;

    //atributos panel de historicos
    @FXML private AnchorPane historyPanel;
    @FXML private TextArea historyTextArea;


    //m??todo ejecutar al inicializar el programa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        historyFile = new File("history.txt");
        historyButton.setDisable(!historyFile.exists());
        game = new Game();
        this.url = location;
        this.resource = resources;
        initialPanel.setVisible(true);
        homePanel.setVisible(true);
        registrationPanel.setVisible(false);
        gamePanel.setVisible(false);
        settingsPanel.setVisible(false);
        addQuestionsPanel.setVisible(false);
        historyPanel.setVisible(false);
        difficultyComboBox.setItems(itemsDifficultyComboBox);
        questionsRoundComboBox.setItems(questionsRound);
        boolean existingFile = game.checkFileQuestions();
        if (!existingFile) {
            gameButton.setDisable(true);
            predefinedQuestionsButton.setDisable(false);
            deleteFileButton.setDisable(true);notificationText.setFill(Color.RED);
            notificationText.setText("Agregar Preguntas para Jugar...\nM??nimo 5 preguntas por categor??a");
        } else {
            predefinedQuestionsButton.setDisable(true);
            game.sortQuestions();
            boolean minimum = game.minimumNumberQuestions();
            categoryOneText.setText(Integer.toString(game.getCategoryOne().size()));
            categoryTwoText.setText(Integer.toString(game.getCategoryTwo().size()));
            categoryThreeText.setText(Integer.toString(game.getCategoryThree().size()));
            categoryFourText.setText(Integer.toString(game.getCategoryFour().size()));
            categoryFiveText.setText(Integer.toString(game.getCategoryFive().size()));
            notificationText.setFill(Color.GREENYELLOW);
            notificationText.setText("Juega y Divi??rtete...");
            if (!minimum) {
                gameButton.setDisable(true);
                notificationText.setFill(Color.RED);
                notificationText.setText("Agregar m??s preguntas...\nM??nimo 5 preguntas por categor??a");
            }
        }
    }

    //metodo para entrar a configuraci??n
    public void onSettingsButtonClick(ActionEvent event) {
        homePanel.setVisible(false);
        settingsPanel.setVisible(true);
    }

    //m??todo generar archivo de preguntas predefinidas
    public void onPredefinedQuestionsFileClick(ActionEvent event) {
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

    //m??todo para bot??n agregar preguntas personalizadas
    public void onGenerateQuestionsButtonClick(ActionEvent event) {
        settingsPanel.setVisible(false);
        addQuestionsPanel.setVisible(true);
        deleteFileButton.setDisable(false);
    }

    //m??todo para regresar al panel home
    public void onReturnHomeButtonClick(ActionEvent event) {
        boolean minimum = game.minimumNumberQuestions();
        if (minimum) {
            gameButton.setDisable(false);
            notificationText.setFill(Color.GREENYELLOW);
            notificationText.setText("Juega y Divi??rtete...");
        } else {
            gameButton.setDisable(true);
            notificationText.setFill(Color.RED);
            notificationText.setText("Agregar Preguntas...\nM??nimo 5 preguntas por categor??a");
        }
        settingsPanel.setVisible(false);
        homePanel.setVisible(true);
    }

    //m??todo para bot??n cancelar agregar pregunta
    public void onCancelAddQuestionButtonClick(ActionEvent event) {
        addQuestionsPanel.setVisible(false);
        settingsPanel.setVisible(true);
        addQuestionAreaText.setText("");
        trueAnswerTextField.setText("");
        oneFalseAnswerTextField.setText("");
        twoFalseAnswerTextField.setText("");
        threeFalseAnswerTextField.setText("");
        difficultyComboBox.setValue(null);
    }

    //m??todo para boton eliminar banco de preguntas
    public void onDeleteFileButton(ActionEvent event) {
        game.deleteQuestionsFile();
        categoryOneText.setText("0");
        categoryTwoText.setText("0");
        categoryThreeText.setText("0");
        categoryFourText.setText("0");
        categoryFiveText.setText("0");
        predefinedQuestionsButton.setDisable(false);
        deleteFileButton.setDisable(true);
    }

    //m??todo agregar preguntas personalizadas
    public void onAddQuestionButton(ActionEvent event) {
        if (addQuestionAreaText.getText().isBlank() || trueAnswerTextField.getText().isBlank() ||
                oneFalseAnswerTextField.getText().isBlank() || twoFalseAnswerTextField.getText().isBlank() ||
                threeFalseAnswerTextField.getText().isBlank() || difficultyComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Error *****");
            alert.setHeaderText(null);
            alert.setContentText("Verifique que ha llenado todos los campos");

            alert.showAndWait();
        } else {
            ArrayList<String> tempQuestion = new ArrayList<>();
            tempQuestion.add(addQuestionAreaText.getText());
            tempQuestion.add(trueAnswerTextField.getText());
            tempQuestion.add(oneFalseAnswerTextField.getText());
            tempQuestion.add(twoFalseAnswerTextField.getText());
            tempQuestion.add(threeFalseAnswerTextField.getText());
            tempQuestion.add(difficultyComboBox.getValue());
            game.addQuestions(tempQuestion);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("***** EXCELENTE *****");
            alert.setHeaderText(null);
            alert.setContentText("Pregunta agregada con ??xito");
            alert.showAndWait();

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
    }

    //m??todo bot??n jugar
    public void onGameButtonClick(ActionEvent event) {
        homePanel.setVisible(false);
        registrationPanel.setVisible(true);
        nameGamerTextField.setText("");
        questionsRoundComboBox.setValue(null);
    }

    //m??todo bot??n aceptar juego
    public void onAcceptGameButtonClick(ActionEvent event) {
        if (nameGamerTextField.getText().isBlank() || questionsRoundComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Error *****");
            alert.setHeaderText(null);
            alert.setContentText("Verifique que ha llenado todos los campos");
            alert.showAndWait();
        } else {
            registrationPanel.setVisible(false);
            gamePanel.setVisible(true);
            game.setName(nameGamerTextField.getText());
            randomQuestions = game.randomQuestions((int) (questionsRoundComboBox.getValue()));
            randomOptions = game.randomOptions();
            int c = randomOptions.indexOf(1);
            validator = (String) (game.getCategoryOne().get(randomQuestions.get(0)).get(randomOptions.get(c)));
            questionsText.setText((String) (game.getCategoryOne().get(randomQuestions.get(0)).get(0)));
            questionsOneButton.setText((String) (game.getCategoryOne().get(randomQuestions.get(0)).get(randomOptions.get(0))));
            questionsTwoButton.setText((String) (game.getCategoryOne().get(randomQuestions.get(0)).get(randomOptions.get(1))));
            questionsThreeButton.setText((String) (game.getCategoryOne().get(randomQuestions.get(0)).get(randomOptions.get(2))));
            questionsFourButton.setText((String) (game.getCategoryOne().get(randomQuestions.get(0)).get(randomOptions.get(3))));
            scoreText.setText("Puntaje: " + game.getTotalScore());
            roundText.setText("Ronda: " + game.getRound());
            questionsNText.setText("Pregunta N??: "+game.getQuestion());
        }
    }

    //m??todo bonton volver a home desde panel de registro jugador
    public void onTwoReturnHomeButtonClick(ActionEvent event) {
        registrationPanel.setVisible(false);
        homePanel.setVisible(true);
        nameGamerTextField.setText("");
        questionsRoundComboBox.setValue(null);

    }

    //m??todo bot??n de respuesta 1
    public void onAnswerOneButtonClick(ActionEvent event) {
        ArrayList<List> temp;
        if (questionsOneButton.getText().equals(validator)) {
            randomOptions = game.randomOptions();
            int question = game.getQuestion();
            int c = randomOptions.indexOf(1);
            if(game.getRound()>5){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("***** GANASTE *****");
                alert.setHeaderText("Eres un Ganador");
                alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
                alert.showAndWait();
                game.historyFile();
                this.initialize(url, resource);
            }else {
                temp = switch (game.getRound()) {
                    case 1 -> game.getCategoryOne();
                    case 2 -> game.getCategoryTwo();
                    case 3 -> game.getCategoryThree();
                    case 4 -> game.getCategoryFour();
                    case 5 -> game.getCategoryFive();
                    default -> new ArrayList<>();
                };
                validator = (String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(c)));
                questionsText.setText((String) (temp.get(randomQuestions.get(question - 1)).get(0)));
                questionsOneButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(0))));
                questionsTwoButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(1))));
                questionsThreeButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(2))));
                questionsFourButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(3))));
                scoreText.setText("Puntaje: " + game.getTotalScore());
                roundText.setText("Ronda: " + game.getRound());
                questionsNText.setText("Pregunta N??: "+question);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Lo Sentimos, Ha perdido *****");
            alert.setHeaderText(null);
            alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
            alert.showAndWait();
            game.historyFile();
            this.initialize(url, resource);
        }
    }

    //m??todo bot??n de respuesta 2
    public void onAnswerTwoButtonClick(ActionEvent event) {
        ArrayList<List> temp;
        if (questionsTwoButton.getText().equals(validator)) {
            randomOptions = game.randomOptions();
            int question = game.getQuestion();
            int c = randomOptions.indexOf(1);
            if(game.getRound()>5){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("***** GANASTE *****");
                alert.setHeaderText("Eres un Ganador");
                alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
                alert.showAndWait();
                game.historyFile();
                this.initialize(url, resource);
            }else {
                temp = switch (game.getRound()) {
                    case 1 -> game.getCategoryOne();
                    case 2 -> game.getCategoryTwo();
                    case 3 -> game.getCategoryThree();
                    case 4 -> game.getCategoryFour();
                    case 5 -> game.getCategoryFive();
                    default -> new ArrayList<>();
                };
                validator = (String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(c)));
                questionsText.setText((String) (temp.get(randomQuestions.get(question - 1)).get(0)));
                questionsOneButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(0))));
                questionsTwoButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(1))));
                questionsThreeButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(2))));
                questionsFourButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(3))));
                scoreText.setText("Puntaje: " + game.getTotalScore());
                roundText.setText("Ronda: " + game.getRound());
                questionsNText.setText("Pregunta N??: "+question);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Lo Sentimos, Ha perdido *****");
            alert.setHeaderText(null);
            alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
            alert.showAndWait();
            game.historyFile();
            this.initialize(url, resource);
        }
    }

    //m??todo bot??n de respuesta 3
    public void onAnswerThreeButtonClick(ActionEvent event) {
        ArrayList<List> temp;
        if (questionsThreeButton.getText().equals(validator)) {
            randomOptions = game.randomOptions();
            int question = game.getQuestion();
            int c = randomOptions.indexOf(1);
            if(game.getRound()>5){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("***** GANASTE *****");
                alert.setHeaderText("Eres un Ganador");
                alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
                alert.showAndWait();
                game.historyFile();
                this.initialize(url, resource);
            }else {
                temp = switch (game.getRound()) {
                    case 1 -> game.getCategoryOne();
                    case 2 -> game.getCategoryTwo();
                    case 3 -> game.getCategoryThree();
                    case 4 -> game.getCategoryFour();
                    case 5 -> game.getCategoryFive();
                    default -> new ArrayList<>();
                };
                validator = (String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(c)));
                questionsText.setText((String) (temp.get(randomQuestions.get(question - 1)).get(0)));
                questionsOneButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(0))));
                questionsTwoButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(1))));
                questionsThreeButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(2))));
                questionsFourButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(3))));
                scoreText.setText("Puntaje: " + game.getTotalScore());
                roundText.setText("Ronda: " + game.getRound());
                questionsNText.setText("Pregunta N??: "+question);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Lo Sentimos, Ha perdido *****");
            alert.setHeaderText(null);
            alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
            alert.showAndWait();
            game.historyFile();
            this.initialize(url, resource);
        }
    }

    //m??todo bot??n de respuesta 4
    public void onAnswerFourButtonClick(ActionEvent event) {
        ArrayList<List> temp;
        if (questionsFourButton.getText().equals(validator)) {
            randomOptions = game.randomOptions();
            int question = game.getQuestion();
            int c = randomOptions.indexOf(1);
            if(game.getRound()>5){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("***** GANASTE *****");
                alert.setHeaderText("Eres un Ganador");
                alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
                alert.showAndWait();
                game.historyFile();
                this.initialize(url, resource);
            }else {
                temp = switch (game.getRound()) {
                    case 1 -> game.getCategoryOne();
                    case 2 -> game.getCategoryTwo();
                    case 3 -> game.getCategoryThree();
                    case 4 -> game.getCategoryFour();
                    case 5 -> game.getCategoryFive();
                    default -> new ArrayList<>();
                };
                validator = (String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(c)));
                questionsText.setText((String) (temp.get(randomQuestions.get(question - 1)).get(0)));
                questionsOneButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(0))));
                questionsTwoButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(1))));
                questionsThreeButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(2))));
                questionsFourButton.setText((String) (temp.get(randomQuestions.get(question - 1)).get(randomOptions.get(3))));
                scoreText.setText("Puntaje: " + game.getTotalScore());
                roundText.setText("Ronda: " + game.getRound());
                questionsNText.setText("Pregunta N??: "+question);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Lo Sentimos, Ha perdido *****");
            alert.setHeaderText(null);
            alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
            alert.showAndWait();
            game.historyFile();
            this.initialize(url, resource);
        }
    }

    //metodo boton rendirse
    public void onFinishButtonClick(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("***** Lo Sentimos, Ha perdido *****");
        alert.setHeaderText(null);
        alert.setContentText("Puntaje Obtenido: " + game.getTotalScore() + "/1000");
        alert.showAndWait();
        game.historyFile();
        this.initialize(url, resource);
    }

    //m??todo boton historial
    public void onHistoryButtonClick(ActionEvent event){
        homePanel.setVisible(false);
        historyPanel.setVisible(true);
        historyTextArea.setText(game.readHistoryFile());
    }

    //m??todo regresar a home desde historico
    public void onReturnHistoryHome(ActionEvent event){
        historyPanel.setVisible(false);
        homePanel.setVisible(true);
    }

    //m??todo eliminar archivo historico
    public void onDeleteHistoryFile(ActionEvent event){
        game.deleteHistoryFile();
        this.initialize(url, resource);
    }
}