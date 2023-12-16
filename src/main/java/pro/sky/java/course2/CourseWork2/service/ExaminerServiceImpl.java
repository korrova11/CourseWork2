package pro.sky.java.course2.CourseWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2.exception.FullSet;
import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    // Random random;
    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {

        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestion(int amount) {
        if (amount > questionService.size()) {
            throw new FullSet("Максимальное количество вопросов = " + questionService.size());
        }

        Set<Question> list = new HashSet<Question>();
        while (list.size() < amount) {
            list.add(questionService.getRandomQuestion());
        }
        return list;
    }
}
