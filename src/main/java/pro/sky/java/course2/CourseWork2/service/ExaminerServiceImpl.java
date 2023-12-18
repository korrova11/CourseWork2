package pro.sky.java.course2.CourseWork2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2.exception.FullSet;
import pro.sky.java.course2.CourseWork2.model.Question;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionServiceJ;
    private final MathQuestionService questionServiceM;

    @Autowired
    public ExaminerServiceImpl(/*@Qualifier("mathQuestionService")*/
            JavaQuestionService questionServiceJ, MathQuestionService questionServiceM) {
        this.questionServiceJ = questionServiceJ;

        this.questionServiceM = questionServiceM;
    }

    @Override
    public Set<Question> getQuestion(int amount) {
        int j = amount / 2;
        int m = amount - j;
        if (amount > questionServiceM.size() + questionServiceJ.size()) {
            throw new FullSet("Максимальное количество вопросов = "
                    + questionServiceM.size() + questionServiceJ.size());
        }

        Set<Question> list = new HashSet<>();
        while (list.size() < m) {
            list.add(questionServiceM.getRandomQuestion());
        }
        while (list.size() < amount) {
            list.add(questionServiceJ.getRandomQuestion());
        }
        return list;
    }
}

