package com.example.javafx1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import java.util.ArrayList;
import Problem.*;

//manages user interaction with the game
public class Controller {


    //buttons to select types of questions
    @FXML
    private Button addButton;
    @FXML
    private Button subButton;
    @FXML
    private Button mulButton;
    @FXML
    private Button divButton;
    //slider to set the amount of questions
    @FXML
    private Slider slider;
    //label to display the question
    @FXML
    private Label questionBox;
    //spot for user to type in the answer
    @FXML
    private TextField answerBox;
    //label provides information about the user's performance so far
    @FXML
    private Label stats;


    //arraylist of problems in the current test
    private ArrayList<MathProblem> problems;
    //string type of questions in the exam
    private String type;
    //int answer to the current question
    private int answer;
    //currently displayed question
    private String question;
    //keeps track of accuracy statistics
    private int addQuestionsRight, addQuestionsWrong,
            subQuestionsRight, subQuestionsWrong,
            mulQuestionsRight, mulQuestionsWrong,
            divQuestionsRight, divQuestionsWrong, testsTaken;

    //no argument constructor for fxml file
    public Controller(){

    }

    //initializes the arraylist of problems
    @FXML
    public void initialize(){
        problems = new ArrayList<MathProblem>();
    }

    //after a question is answered, moves on to the next question
    public void nextQuestion(){
        problems.remove(0);
        if(problems.size() != 0) {
            answer = problems.get(0).getAnswer();
            question = problems.get(0).getQuestion();
            questionBox.setText(question);
        } else {
            updateStatistics();
        }
    }

    //provides statistics about the users performance
    public void updateStatistics(){
        questionBox.setText("Study more!!");
        testsTaken++;
        String addition = " Addition: No information yet";
        String subtraction = "Subtraction: No information yet";
        String multiplication = "Multiplication: No information yet";
        String division = "Division: No information yet";
        if(addQuestionsRight + addQuestionsWrong != 0)
            addition = " Addition: " + addQuestionsRight + " right; " + addQuestionsWrong + " wrong; " + ((int) (((double) addQuestionsRight)/(addQuestionsRight + addQuestionsWrong) * 100)) + " percent correct";
        if(subQuestionsRight + subQuestionsWrong != 0)
            subtraction = "Subtraction: " + subQuestionsRight + " right; " + subQuestionsWrong + " wrong; " + ((int) (((double) subQuestionsRight)/(subQuestionsRight + subQuestionsWrong) * 100)) + " percent correct";
        if(mulQuestionsRight + mulQuestionsWrong != 0)
            multiplication = "Multiplication: " + mulQuestionsRight + " right; " + mulQuestionsWrong + " wrong; " + ((int) (((double)mulQuestionsRight)/(mulQuestionsRight + mulQuestionsWrong) * 100)) + " percent correct";
        if(divQuestionsRight + divQuestionsWrong != 0)
            division = "Division: " + divQuestionsRight + " right; " + divQuestionsWrong + " wrong; " + ((int) (((double) divQuestionsRight)/(divQuestionsRight + divQuestionsWrong) * 100)) + " percent correct";
        stats.setText("STATISTICS: \n" +
                        addition + " \n " +
                subtraction + " \n " +
                multiplication + " \n " +
                division + " \n " +
                        "Tests taken: " + testsTaken
                );
    }

    //checks the users answer and increments accuracy statistics accordingly
    public void guess(){
        answer = java.lang.Integer.parseInt(answerBox.getText());
        if(answer == problems.get(0).getAnswer()) {
            if(type.equals("Division"))
                divQuestionsRight++;
            else if(type.equals("Multiplication"))
                mulQuestionsRight++;
            else if(type.equals("Addition"))
                addQuestionsRight++;
            else if(type.equals("Subtraction"))
                subQuestionsRight++;
        } else{
            if(type.equals("Division"))
                divQuestionsWrong++;
            else if(type.equals("Multiplication"))
                mulQuestionsWrong++;
            else if(type.equals("Addition"))
                addQuestionsWrong++;
            else if(type.equals("Subtraction"))
                subQuestionsWrong++;
        }
        clearAnswerBox();
        nextQuestion();
    }

    //clears the answer box after an answer is submitted
    public void clearAnswerBox(){
        answerBox.setText("");
    }

    //repopulates the arraylist with a new set of questions
    public void newQuestions(){
        if(problems.size() != 0)
            problems.clear();
        if(type.equals("Division")){
            for(int i = 0; i < slider.getValue(); i++){
                problems.add(new DivisionProblem());
            }
        }
        else if(type.equals("Multiplication")) {
            for(int i = 0; i < slider.getValue(); i++){
                problems.add(new MultiplicationProblem());
            }
        }
        else if(type.equals("Addition")){
            for(int i = 0; i < slider.getValue(); i++){
                problems.add(new AdditionProblem());
            }
        }
        else if(type.equals("Subtraction")){
            for(int i = 0; i < slider.getValue(); i++){
                problems.add(new SubtractionProblem());
            }
        }

        answer = problems.get(0).getAnswer();
        question = problems.get(0).getQuestion();
        questionBox.setText(question);
    }

    //selects the addition test
    public void setTypeAddition(){
        type = "Addition";
        addButton.setStyle("-fx-background-color: #999999; ");
        subButton.setStyle("-fx-background-color: #cccccc; ");
        mulButton.setStyle("-fx-background-color: #cccccc; ");
        divButton.setStyle("-fx-background-color: #cccccc; ");
    }

    //selects the subtraction test
    public void setTypeSubtraction(){
        type = "Subtraction";
        addButton.setStyle("-fx-background-color: #cccccc; ");
        subButton.setStyle("-fx-background-color: #999999; ");
        mulButton.setStyle("-fx-background-color: #cccccc; ");
        divButton.setStyle("-fx-background-color: #cccccc; ");
    }

    //selects the multiplication test
    public void setTypeMultiplication(){
        type = "Multiplication";
        addButton.setStyle("-fx-background-color: #cccccc; ");
        subButton.setStyle("-fx-background-color: #cccccc; ");
        mulButton.setStyle("-fx-background-color: #999999; ");
        divButton.setStyle("-fx-background-color: #cccccc; ");
    }

    //selects the division test
    public void setTypeDivision(){
        type = "Division";
        addButton.setStyle("-fx-background-color: #cccccc; ");
        subButton.setStyle("-fx-background-color: #cccccc; ");
        mulButton.setStyle("-fx-background-color: #cccccc; ");
        divButton.setStyle("-fx-background-color: #999999; ");
    }
}
