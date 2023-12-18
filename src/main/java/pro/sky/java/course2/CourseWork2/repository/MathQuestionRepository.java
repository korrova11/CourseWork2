package pro.sky.java.course2.CourseWork2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.CourseWork2.exception.QuestionNotFound;
import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.*;

@Repository

public class MathQuestionRepository implements QuestionRepository {
  //  private final List<Question> listQuestion = new ArrayList<>();

    private final ArrayList<Question> listQuestion = new ArrayList<>(List.of(
            new Question(
                    "Что такое функция",
                    "ответ"),
            new Question(
                    "Дайте определение предела функции",
                    "ответ"),
            new Question(
                    "Дайте определение производной",
                    "ответ"),

            new Question(
                    "Какой геометрический смысл производной?",
                    "ответ"),
            new Question(
                    "Как выглядит уравнение для нахождения ассимптот?",
                    "ответ"),

            new Question(
                    "Расскажите об области значений функции",
                    "ответ"),
            new Question(
                    "Как связаны знак производной и области возрастания или убывания функции",
                    "ответ"),
            new Question(
                    "Как можно найти экстремумы?",
                    "ответ"),
            new Question(
                    "Как выглядит уравнение окружности?",
                    "ответ"),
            new Question(
                    "Какую геометрическую фигуру представляет колобок?",
                    "ответ")

    ));
    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (listQuestion.contains(q)) {
            throw new IllegalArgumentException("Данный вопрос уже есть в списке");
        }
        listQuestion.add(q);
        return q;
    }

    @Override
    public Question remove(Question question) {

        if (listQuestion.remove(question)) {
            return question;
        }
        throw new QuestionNotFound("Элемента нет в списке");
    }

    @Override
    public List<Question> getAll() {
        return listQuestion;
    }

    @Override
    public Question find(String question) {
        return listQuestion.stream()
                .filter(e -> e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(QuestionNotFound::new);

    }

}
