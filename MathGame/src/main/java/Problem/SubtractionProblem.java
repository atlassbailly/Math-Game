package Problem;

import Problem.MathProblem;

//subtraction variety of mathproblem
public class SubtractionProblem extends MathProblem {

    //integer answer, and the two numbers being subtracted
    int answer, num1, num2;
    //question to be displayed
    String question;

    //constructs a general math problem and calls a method to generate numbers
    public SubtractionProblem() {
        super();
        generateQuestion();
    }

    //randomly generates two numbers from 0 to 99 whose difference is positive and less than 101. the result is assigne to the integer answer and an appropriate question is generated.
    public void generateQuestion(){
        num1 = (int) (Math.random() * 100);
        num2 = (int) (Math.random() * 100);
        while(num1 - num2 > 100 || num1 - num2 < 0){
            num1 = (int) (Math.random() * 100);
            num2 = (int) (Math.random() * 100);
        }
        answer = num1 - num2;
        question = num1 + " - " + num2 + " = ?";
        setQuestion(question);
        setAnswer(answer);
    }
}
