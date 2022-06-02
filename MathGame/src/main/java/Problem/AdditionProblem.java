package Problem;

import Problem.MathProblem;
//addition variety of mathproblem
public class AdditionProblem extends MathProblem {

    //integer answer, and the two numbers to be added
    int answer, num1, num2;
    //question to be displayed
    String question;

    //constructs an addition problem and calls the generateQuestion method
    public AdditionProblem() {
        super();
        generateQuestion();
    }

    //selects two values at random, whose sum is less than 101. intializes the question and sets the answer to the sum
    public void generateQuestion(){
        num1 = (int) (Math.random() * 100);
        num2 = (int) (Math.random() * 100);
        while(num1 + num2 > 100){
            num1 = (int) (Math.random() * 100);
            num2 = (int) (Math.random() * 100);
        }
        answer = num1 + num2;
        question = num1 + " + " + num2 + " = ?";
        setQuestion(question);
        setAnswer(answer);
    }
}
