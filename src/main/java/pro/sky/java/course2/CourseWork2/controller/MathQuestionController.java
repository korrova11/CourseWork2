package pro.sky.java.course2.CourseWork2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.CourseWork2.model.Question;

import pro.sky.java.course2.CourseWork2.service.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    @Qualifier("mathQuestionService")
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService question) {
        this.mathQuestionService = question;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {

        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return mathQuestionService.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return mathQuestionService.getAll();
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return mathQuestionService.find(question);
    }

}


