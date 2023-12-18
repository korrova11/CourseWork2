package pro.sky.java.course2.CourseWork2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.CourseWork2.exception.FullSet;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.service.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ExaminerServiceTest {


    private final JavaQuestionService javaService = mock(JavaQuestionService.class);

    private final MathQuestionService mathService = mock(MathQuestionService.class);

    private ExaminerService outJ;

    private ExaminerService outM;

    @BeforeEach
    public void setUp() {
        outJ = new ExaminerServiceImpl(javaService, mathService);
    }


    public static final Question QUESTION_1 = new Question("Вопрос1", "Ответ1");
    private static final Question QUESTION_2 = new Question("Вопрос2", "Ответ2");
    public static final Question QUESTION_3 = new Question("Вопрос3", "Ответ3");
    public static final Question QUESTION_4 = new Question("Вопрос4", "Ответ4");
    private static final Question QUESTION_5 = new Question("Вопрос5", "Ответ5");


    @Test
    public void getQuestionJavaTestOnThrow() {
        when(javaService.size()).thenReturn(5);
        assertThrows(FullSet.class, () -> outJ.getQuestion(7));

    }

    @Test
    public void getQuestionMathTestOnThrow() {
        when(mathService.size()).thenReturn(5);
        assertThrows(FullSet.class, () -> outJ.getQuestion(7));

    }


    @Test
    public void getQuestionJavaTest() {
        when(javaService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2);
        when(mathService.getRandomQuestion())
                .thenReturn(QUESTION_3, QUESTION_4);
        when(javaService.size()).thenReturn(10);
        when(mathService.size()).thenReturn(10);

        assertEquals(outJ.getQuestion(4).size(), 4);

    }

    @Test
    public void getQuestionJavaTestOnContains() {
        when(javaService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2);
        when(mathService.getRandomQuestion())
                .thenReturn(QUESTION_3, QUESTION_4);
        when(javaService.size()).thenReturn(10);
        when(mathService.size()).thenReturn(10);
        assertTrue(outJ.getQuestion(4).contains(QUESTION_4));

    }


}
