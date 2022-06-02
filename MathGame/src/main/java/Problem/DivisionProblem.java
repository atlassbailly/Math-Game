package Problem;

//division variety of mathproblem
public class DivisionProblem extends MathProblem {

    //integer answer
    int answer;
    //question to be displayed
    String question;

    //constructs a blank math problem, calls on a method to add info
    public DivisionProblem() {
        super();
        generateQuestion();
    }

    //generates a dividend less than 100, and creates an appropriate divisor. creates an appropriate question and assigns the quotient to the answer integer
    public void generateQuestion(){
        int num1 = (int) (Math.random() * 100.0);
        int num2 = (int) ((Math.random() * num1/2) + 1);
        num1 -= num1%num2;
        answer = num1/num2;
        question = num1 + " / " + num2 + " = ?";
        setAnswer(answer);
        setQuestion(question);
    }
}