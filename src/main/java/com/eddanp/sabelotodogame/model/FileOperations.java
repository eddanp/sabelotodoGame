package com.eddanp.sabelotodogame.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
    //método crear archivo "questions.txt" compuesto con las preguntas predefinidas en la clase "PredefinedQuestions"
    public static void createPredefinedFile(String[][] questions){
        File file = new File("questions.txt");
        if(!file.exists() && !file.isDirectory()) {
            FileWriter writer = null;
            try {
                writer = new FileWriter("questions.txt");
                BufferedWriter bufer = new BufferedWriter(writer);
                for (int i = 0; i < questions.length; i++) {
                    for (int j = 0; j < questions[i].length; j++) {
                        bufer.write(questions[i][j] + " - ");
                    }
                    bufer.write("\n");
                }
                bufer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //leer archivo de texto "questions.txt" y guardar en array list
    public static ArrayList<List> readFile(){
        File file = new File("questions.txt");
        ArrayList<List> questions = new ArrayList<>();
        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                Scanner delimiter = new Scanner(line);
                delimiter.useDelimiter("\\s* - \\s*");
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(delimiter.next());
                temp.add(delimiter.next());
                temp.add(delimiter.next());
                temp.add(delimiter.next());
                temp.add(delimiter.next());
                temp.add(delimiter.next());
                questions.add(temp);
                delimiter.close();
            }
            scan.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return questions;
    }
}
