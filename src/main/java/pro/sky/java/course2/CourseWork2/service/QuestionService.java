package pro.sky.java.course2.CourseWork2.service;

import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question,String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question find(String question);
    Question getRandomQuestion();
    int size();
}
