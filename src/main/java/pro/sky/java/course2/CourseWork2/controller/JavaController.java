package pro.sky.java.course2.CourseWork2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")

public class JavaController {
private final JavaQuestionService ques;

    public JavaController(JavaQuestionService question) {
        this.ques = question;
    }
    @GetMapping("/add")
    public Question add(@RequestParam String question,@RequestParam String answer){
        Question question1 = new Question(question,answer);
        return ques.add(question1);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question,@RequestParam String answer){
        Question question1 = new Question(question,answer);
        return ques.remove(question1);
    }
    @GetMapping
    public Collection<Question> getQuestions(){
        return ques.getAll();
    }

}

