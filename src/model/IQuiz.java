package model;

import java.util.List;

public interface IQuiz {
    String getTitle();
    List<IQuestion> getQuestions();
}
