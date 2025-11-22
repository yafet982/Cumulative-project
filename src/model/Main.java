package model;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Answer q1a1 = new Answer("Paris", true);
        Answer q1a2 = new Answer("London", false);
        Answer q1a3 = new Answer("Berlin", false);

        Question question1 = new Question(
                "What is the capital of France?",
                List.of(q1a1, q1a2, q1a3)
        );

        Answer q2a1 = new Answer("3", false);
        Answer q2a2 = new Answer("4", true);
        Answer q2a3 = new Answer("5", false);

        Question question2 = new Question(
                "What is 2 + 2?",
                List.of(q2a1, q2a2, q2a3)
        );

        Answer q3a1 = new Answer("Blue Whale", true);
        Answer q3a2 = new Answer("Elephant", false);
        Answer q3a3 = new Answer("Giraffe", false);

        Question question3 = new Question(
                "What is the largest animal on Earth?",
                List.of(q3a1, q3a2, q3a3)
        );

        Quiz quiz = new Quiz(
                "General Knowledge Quiz",
                List.of(question1, question2, question3)
        );

        Scanner input = new Scanner(System.in);
        int score = 0;

        for (IQuestion q : quiz.getQuestions()) {
            System.out.println(q.getQuestionText());

            List<IAnswer> answers = q.getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i).getText());
            }

            System.out.print("Your answer (1-" + answers.size() + "): ");
            int userChoice = input.nextInt();
            int index = userChoice - 1;

            if (index >= 0 && index < answers.size() && answers.get(index).isCorrect()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }
        }

        System.out.println("Quiz complete!");
        System.out.println("Your final score: " + score + " out of " + quiz.getQuestions().size());
    }
}
