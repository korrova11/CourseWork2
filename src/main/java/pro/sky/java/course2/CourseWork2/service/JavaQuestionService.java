package pro.sky.java.course2.CourseWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2.exception.QuestionNotFound;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaRepository;

    public JavaQuestionService(JavaQuestionRepository javaRepository) {
        this.javaRepository = javaRepository;
    }


    @Override
    public Question add(String question, String answer) {
        return javaRepository.add(question, answer);
    }


    @Override
    public Question remove(Question question) {

        return javaRepository.remove(question);
    }

    @Override
    public List<Question> getAll() {

        return javaRepository.getAll();
    }

    @Override
    public Question find(String question) {
        return javaRepository.find(question);

    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(javaRepository.getAll().size());

        return javaRepository.getAll().get(i);
    }
    public int size(){
        return javaRepository.getAll().size();
    }

}
