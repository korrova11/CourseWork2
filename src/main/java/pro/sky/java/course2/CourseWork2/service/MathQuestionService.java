package pro.sky.java.course2.CourseWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2.exception.QuestionNotFound;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.repository.JavaQuestionRepository;
import pro.sky.java.course2.CourseWork2.repository.MathQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathRepository;

    public MathQuestionService(MathQuestionRepository mathRepository) {
        this.mathRepository = mathRepository;
    }


    @Override
    public Question add(String question, String answer) {
        return mathRepository.add(question, answer);
    }


    @Override
    public Question remove(Question question) {

        return mathRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return mathRepository.getAll();
    }

    @Override
    public Question find(String question) {
        return mathRepository.find(question);

    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(mathRepository.getAll().size());

        return mathRepository.getAll().get(i);
    }

    public int size() {
        return mathRepository.getAll().size();
    }

}
