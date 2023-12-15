package pro.sky.java.course2.CourseWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService{
   // Random random;
    QuestionService questionService;
    ExaminerServiceImpl(QuestionService questionService){
        this.questionService=questionService;
    }

    @Override
    public Set<Question> getQuestion(int amount) {

        Set<Question> list = new HashSet<Question>();
        for (int i=0; i<=amount;i++){
            list.add(questionService.getRandomQuestion());
        }
        return list;
    }
}
