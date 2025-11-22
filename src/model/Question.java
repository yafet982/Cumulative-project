package model;

import java.util.List;

public class Question implements IQuestion {
    private String questionText;
    private List<IAnswer> answers;

    public Question(String questionText, List<IAnswer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<IAnswer> getAnswers() {
        return answers;
    }

    public boolean isCorrectAnswer(int index) {
        if (index < 0 || index >= answers.size()) {
            return false;
        }
        return answers.get(index).isCorrect();
    }
}
