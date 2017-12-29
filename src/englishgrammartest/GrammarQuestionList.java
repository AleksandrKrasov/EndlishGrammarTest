/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishgrammartest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Саня
 */
public class GrammarQuestionList {
    
    private ArrayList<String> questions;
    private String [][] answers;
    private int [] answerIndex;

    public GrammarQuestionList() {
        questions = new ArrayList<>();
        answers = new String [10][3];
        answerIndex = new int[10];
    }
    
    public void fill(String qRoot, String aRoot) throws FileNotFoundException{
        readQuestions(qRoot);
        readAnswears(aRoot);
    }
    
    public void showQ(){
        System.out.println(questions);
    }
    
    public void showA(){
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<answers[i].length; j++){
                System.out.print(answers[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void clearList(){
        questions.clear();
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }
    
    public void readAnswears(String root) throws FileNotFoundException{
        Scanner scn = new Scanner(new File(root));
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<answers[i].length; j++){
                answers[i][j] = scn.next();
                if(answers[i][j].contains("_"))
                    answers[i][j] = answers[i][j].replaceAll("_", " ");
            }
        }
        for(int i=0; i<answerIndex.length; i++){
            answerIndex[i] = scn.nextInt();
        }
    }
    
    public void readQuestions(String root) throws FileNotFoundException{
        Scanner scn = new Scanner(new File(root));
        while(scn.hasNextLine())
            questions.add(scn.nextLine());
    }

    public String[][] getAnswers() {
        return answers;
    }

    public void setAnswers(String[][] answers) {
        this.answers = answers;
    }
    
    public void showIndex(){
        for(int i=0; i<answerIndex.length; i++){
            System.out.print(answerIndex[i] + " ");
        }
    }

    public int[] getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int[] answerIndex) {
        this.answerIndex = answerIndex;
    }
}
