package pro.sky.java.course2.CourseWork2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.service.ExaminerService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/get")

public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }

    @GetMapping("{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }

}
