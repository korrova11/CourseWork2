package pro.sky.java.course2.CourseWork2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.service.JavaQuestionService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/java")

public class JavaController {
    @Qualifier("javaQuestionService")
    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService question) {
        this.javaQuestionService = question;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {

        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return javaQuestionService.remove(question1);
    }

    @GetMapping
    public List<Question> getQuestions() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return javaQuestionService.find(question);
    }

}

