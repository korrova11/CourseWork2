package pro.sky.java.course2.CourseWork2.service;

import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestion(int amount);
}
