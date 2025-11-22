import model.IAnswer;
import model.IQuestion;
import model.Answer;
import model.Question;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IAnswer a1 = new Answer("Paris", true);
        IAnswer a2 = new Answer("London", false);
        IAnswer a3 = new Answer("Rome", false);

        IQuestion q1 = new Question(
                "What is the capital of France?",
                List.of(a1, a2, a3)
        );

        IAnswer b1 = new Answer("3", false);
        IAnswer b2 = new Answer("4", true);
        IAnswer b3 = new Answer("5", false);

        IQuestion q2 = new Question(
                "What is 2 + 2?",
                List.of(b1, b2, b3)
        );

        List<IQuestion> quiz = List.of(q1, q2);

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (IQuestion q : quiz) {
            System.out.println(q.getQuestionText());
            List<IAnswer> answers = q.getAnswers();

            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i).getText());
            }

            System.out.print("Choose the correct answer (1-" + answers.size() + "): ");
            int userChoice = scanner.nextInt();
            int index = userChoice - 1;

            if (q instanceof Question) {
                if (((Question) q).isCorrectAnswer(index)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            }

            System.out.println();
        }

        System.out.println("Quiz finished. Your score: " + score + " out of " + quiz.size());
    }
}
