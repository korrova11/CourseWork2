package pro.sky.java.course2.CourseWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2.exception.QuestionNotFound;
import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final ArrayList<Question> listQuestion = new ArrayList<>(List.of(
            new Question(
                    "Что такое «переменная»?",
                    "ответ"),
            new Question(
                    "По каким параметрам переменные различаются?",
                    "ответ"),
            new Question(
                    "Перечислите типы переменных и действия, которые с ними можно осуществлять.",
                    "ответ"),

            new Question(
                    "Что означает <<инициализация>>?",
                    "ответ"),
            new Question(
                    "Какие особенности инициализации вы можете назвать ?",
                    "ответ"),

            new Question(
                    "Какие условные операторы вы знаете ? Дайте краткое определение каждому из них.",
                    "ответ"),
            new Question(
                    "Что такое «цикл»?",
                    "ответ"),
            new Question(
                    "Какие циклы вы знаете, в чем их отличия ?",
                    "ответ"),
            new Question(
                    "Что вы знаете о массивах ?",
                    "ответ"),
            new Question(
                    "Дайте определение строке",
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
    public Question add(Question question) {
        listQuestion.add(question);
        return question;

    }

    @Override
    public Question remove(Question question) {

        if (listQuestion.remove(question)) {
            return question;
        }
        throw new QuestionNotFound("Элемента нет в списке");
    }

    @Override
    public Collection<Question> getAll() {
        return listQuestion;
    }

    @Override
    public Question find(String question) {
        return listQuestion.stream()
                .filter(e -> e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(QuestionNotFound::new);

    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(listQuestion.size());

        return listQuestion.get(i);
    }

    @Override
    public int size() {
        return listQuestion.size();
    }
}
