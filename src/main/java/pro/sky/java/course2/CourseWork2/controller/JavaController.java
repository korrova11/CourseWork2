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
    @Qualifier
    private final JavaQuestionService question3;

    public JavaController(JavaQuestionService question) {
        this.question3 = question;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {

        return question3.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return question3.remove(question1);
    }

    @GetMapping
    public List<Question> getQuestions() {
        return question3.getAll();
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return question3.find(question);
    }

}

