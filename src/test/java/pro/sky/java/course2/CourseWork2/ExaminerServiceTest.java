package pro.sky.java.course2.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.CourseWork2.exception.FullSet;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.service.ExaminerService;
import pro.sky.java.course2.CourseWork2.service.ExaminerServiceImpl;
import pro.sky.java.course2.CourseWork2.service.JavaQuestionService;
import pro.sky.java.course2.CourseWork2.service.QuestionService;

import java.util.Random;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;


    public static final Question QUESTION_1 = new Question("Вопрос1", "Ответ1");
    private static final Question QUESTION_2 = new Question("Вопрос2", "Ответ2");
    public static final Question QUESTION_3 = new Question("Вопрос3", "Ответ3");
    public static final Question QUESTION_4 = new Question("Вопрос4", "Ответ4");
    private static final Question QUESTION_5 = new Question("Вопрос5", "Ответ5");


    @Test
    public void getQuestionTestOnThrow() {
        when(questionService.size()).thenReturn(5);
              assertThrows(FullSet.class, () -> out.getQuestion(7));

    }

    @Test
    public void getQuestionTest() {
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5);
        when(questionService.size()).thenReturn(10);
        assertEquals(out.getQuestion(5).size(), 5);

    }
    @Test
    public void getQuestionTestOnContains() {
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5);
        when(questionService.size()).thenReturn(10);
       assertTrue(out.getQuestion(5).contains(QUESTION_3));

    }



}
