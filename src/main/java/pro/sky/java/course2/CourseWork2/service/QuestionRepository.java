package pro.sky.java.course2.CourseWork2.service;

import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question,String answer);
    Question remove (String question,String answer);
    Collection<Question> getAll();
}
