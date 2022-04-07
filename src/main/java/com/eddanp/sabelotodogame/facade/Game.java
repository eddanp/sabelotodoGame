package com.eddanp.sabelotodogame.facade;

import com.eddanp.sabelotodogame.model.FileOperations;
import com.eddanp.sabelotodogame.model.PredefinedQuestions;
import com.eddanp.sabelotodogame.model.Score;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    int totalScore=0;
    int round=0;
    int question=0;
    int n;
    ArrayList<List> categoryOne;
    ArrayList<List> categoryTwo;
    ArrayList<List> categoryThree;
    ArrayList<List> categoryFour;
    ArrayList<List> categoryFive;

    //constructor vacío
    public Game() {
        categoryOne = new ArrayList<>();
        categoryTwo = new ArrayList<>();
        categoryThree = new ArrayList<>();
        categoryFour = new ArrayList<>();
        categoryFive = new ArrayList<>();
    }

    //método verificar si existe archivo de preguntas y si cuenta con mínimo 5 preguntas por categoría
    public boolean checkFileQuestions(){
        boolean existingFile=false;
        File questionsFile = new File("questions.txt");
        if (questionsFile.exists()){
            existingFile=true;
        }
        return existingFile;
    }

    //método generar archivo con preguntas predefinidas
    public void predefinedQuestionsFile(){
        PredefinedQuestions predefined = new PredefinedQuestions();
        String [][] questions = predefined.getQuestions();
        FileOperations.createPredefinedFile(questions);
    }

    //método para guardar preguntas en array list según categoría
    public void sortQuestions(){
        ArrayList<List> listObtained = new ArrayList<>();
        listObtained=FileOperations.readFile();
        categoryOne.clear();
        categoryTwo.clear();
        categoryThree.clear();
        categoryFour.clear();
        categoryFive.clear();
        for (List<String> temp: listObtained) {
             if(temp.get(5).equals("1")){
                 categoryOne.add(temp);
             }else if(temp.get(5).equals("2")){
                 categoryTwo.add(temp);
             }else if(temp.get(5).equals("3")) {
                 categoryThree.add(temp);
             }else if(temp.get(5).equals("4")) {
                 categoryFour.add(temp);
             }else if(temp.get(5).equals("5")) {
                 categoryFive.add(temp);
             }
        }
    }

    //método para verificar que haya el mínimo de preguntas requeridas
    public boolean minimumNumberQuestions(){
        boolean minimum= false;
        if(categoryOne.size()>=5 && categoryTwo.size()>=5 && categoryThree.size()>=5 &&
                categoryFour.size()>=5 && categoryFive.size()>=5){
            minimum=true;
        }
        return minimum;
    }

    //método generar o modificar archivo de preguntas, con preguntas personalizadas
    public void addQuestions(ArrayList<String> questions){
        FileOperations.addQuestions(questions);
    }

    //método eliminar banco de preguntas
    public void deleteQuestionsFile(){
        FileOperations.deleteFile();
        categoryOne.clear();
        categoryTwo.clear();
        categoryThree.clear();
        categoryFour.clear();
        categoryFive.clear();
    }

    //metodo obtener preguntas aleatorias por categoria
    public ArrayList<Integer> randomQuestions(int n){
        this.n=n;
        ArrayList<Integer> random;
        switch (n){
            case 1:
                random = new ArrayList<>();
                random.add((int)(Math.random()*categoryOne.size()));
                random.add((int)(Math.random()*categoryTwo.size()));
                random.add((int)(Math.random()*categoryThree.size()));
                random.add((int)(Math.random()*categoryFour.size()));
                random.add((int)(Math.random()*categoryFive.size()));
                break;
            case 2:
                random = new ArrayList<>();
                while (random.size()<=2){
                    int x=(int)(Math.random()*categoryOne.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=4 && random.size()>=2){
                    int x=(int)(Math.random()*categoryTwo.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=6 && random.size()>=4){
                    int x=(int)(Math.random()*categoryThree.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=8 && random.size()>=6){
                    int x=(int)(Math.random()*categoryFour.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=10 && random.size()>=8){
                    int x=(int)(Math.random()*categoryFive.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
            case 3:
                random = new ArrayList<>();
                while (random.size()<=3){
                    int x=(int)(Math.random()*categoryOne.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=6 && random.size()>=3){
                    int x=(int)(Math.random()*categoryTwo.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=9 && random.size()>=6){
                    int x=(int)(Math.random()*categoryThree.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=12 && random.size()>=9){
                    int x=(int)(Math.random()*categoryFour.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=15 && random.size()>=12){
                    int x=(int)(Math.random()*categoryFive.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
            case 4:
                random = new ArrayList<>();
                while (random.size()<=4){
                    int x=(int)(Math.random()*categoryOne.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=8 && random.size()>=4){
                    int x=(int)(Math.random()*categoryTwo.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=12 && random.size()>=8){
                    int x=(int)(Math.random()*categoryThree.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=16 && random.size()>=12){
                    int x=(int)(Math.random()*categoryFour.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=20 && random.size()>=16){
                    int x=(int)(Math.random()*categoryFive.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
            case 5:
                random = new ArrayList<>();
                while (random.size()<=5){
                    int x=(int)(Math.random()*categoryOne.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=10 && random.size()>=5){
                    int x=(int)(Math.random()*categoryTwo.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=15 && random.size()>=10){
                    int x=(int)(Math.random()*categoryThree.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=20 && random.size()>=15){
                    int x=(int)(Math.random()*categoryFour.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
                while (random.size()<=25 && random.size()>=20){
                    int x=(int)(Math.random()*categoryFive.size());
                    if(!random.contains(x)){
                        random.add(x);
                    }
                }
            default:
                random = new ArrayList<>();
        }
        return random;
    }

    //método obtener orden aleatorio de respuestas
    public ArrayList<Integer> randomOptions(){
        question=question+1;
        this.scoreGame();
        int x=0;
        ArrayList<Integer> random = new ArrayList<>();
        while(random.size()!=4){
            x=(int)(Math.random()*4+1);
            if(!random.contains(x)){
                random.add(x);
            }
        }
        return random;
    }

    //método obtener puntuacion y tonda actual
    public void scoreGame(){
        Score score=new Score();
        switch (n) {
            case 1 -> {
                int[] scoreOne = score.getScoreOne();
                totalScore = totalScore + scoreOne[question-1];
                round = round + 1;
            }
            case 2 -> {
                if (question == 1 || question == 3 || question == 5 || question == 7 || question == 9) {
                    round = round + 1;
                }
                int[] scoreTwo = score.getScoreTwo();
                totalScore = totalScore + scoreTwo[question-1];
            }
            case 3 -> {
                if (question == 1 || question == 4 || question == 7 || question == 10 || question == 13) {
                    round = round + 1;
                }
                int[] scoreThree = score.getScoreThree();
                totalScore = totalScore + scoreThree[question-1];
            }
            case 4 -> {
                if (question == 1 || question == 5 || question == 9 || question == 13 || question == 17) {
                    round = round + 1;
                }
                int[] scoreFour = score.getScoreFour();
                totalScore = totalScore + scoreFour[question-1];
            }
            case 5 -> {
                if (question == 1 || question == 6 || question == 11 || question == 16 || question == 21) {
                    round = round + 1;
                }
                int[] scoreFive = score.getScoreFive();
                totalScore = totalScore + scoreFive[question-1];
            }
        }
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getRound() {
        return round;
    }

    public int getQuestion() {
        return question;
    }

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<List> getCategoryOne() {
        return categoryOne;
    }

    public ArrayList<List> getCategoryTwo() {
        return categoryTwo;
    }

    public ArrayList<List> getCategoryThree() {
        return categoryThree;
    }

    public ArrayList<List> getCategoryFour() {
        return categoryFour;
    }

    public ArrayList<List> getCategoryFive() {
        return categoryFive;
    }
}
