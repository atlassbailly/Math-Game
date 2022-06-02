package Problem;

//represents a general math problem
public abstract class MathProblem {

    //integer answer to the problem
    private int answer;
    //question to present to the reader
    private String question;

    //constructor
    public MathProblem() {

    }

    //returns the answer to the problem
    public int getAnswer() { return answer; }
    //returns the question
    public String getQuestion() { return question; }

    //sets the integer answer- passthrough for subclasses
    public void setAnswer(int i) { answer = i; }
    //sets the string question- passthrough for subclasses
    public void setQuestion(String s) { question = s; }

    //returns true if the parameter guess is the answer
    public boolean checkAnswer(int i) {
        return answer == i;
    }
}
