package model;

import java.util.List;

public class Question {
    private String questionText;
    private List<Answer> answers;
    private int correctIndex;

    public Question(String questionText, List<Answer> answers, int correctIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public boolean isCorrect(int chosenIndex) {
        return chosenIndex == correctIndex;
    }
}
