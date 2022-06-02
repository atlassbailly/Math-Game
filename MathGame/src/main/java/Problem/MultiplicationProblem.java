package Problem;


//represents a multiplication variety of mathproblem
public class MultiplicationProblem extends MathProblem {

    //integer answer, and the two numbers whose product is the answer
    int answer, num1, num2;
    //question to be displayed to the reader
    String question;

    //creates a general math problem and then calls a method to generate the numbers
    public MultiplicationProblem() {
        super();
        generateQuestion();
    }

    //randomly generates two integers who are between 2 and 50 and whose product is less than 101. an appropriate question is generated and the product is assigned to the integer answer
    public void generateQuestion(){
        num1 = (int) (Math.random() * 100);
        num2 = (int) (Math.random() * 100);
        while(num1 * num2 > 100){
            num1 = (int) (Math.random() * 100) + 2;
            num2 = (int) (Math.random() * 100) + 2;
        }
        answer = num1 * num2;
        question = num1 + " * " + num2 + " = ?";
        setQuestion(question);
        setAnswer(answer);
    }
}
