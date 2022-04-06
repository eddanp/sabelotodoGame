package com.eddanp.sabelotodogame.facade;

import com.eddanp.sabelotodogame.model.FileOperations;
import com.eddanp.sabelotodogame.model.PredefinedQuestions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    FileOperations operation;
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
        listObtained=FileOperations.ReadFile();
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
