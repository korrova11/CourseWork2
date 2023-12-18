package pro.sky.java.course2.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.CourseWork2.exception.QuestionNotFound;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.repository.JavaQuestionRepository;
import pro.sky.java.course2.CourseWork2.repository.MathQuestionRepository;
import pro.sky.java.course2.CourseWork2.service.JavaQuestionService;
import pro.sky.java.course2.CourseWork2.service.MathQuestionService;
import pro.sky.java.course2.CourseWork2.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuestionServiceTest {
    private final JavaQuestionRepository javaRepository = mock(JavaQuestionRepository.class);
    private final MathQuestionRepository mathRepository = mock(MathQuestionRepository.class);
    private QuestionService outJ;
    private QuestionService outM;

    @BeforeEach
    public void initOut() {
        outJ = new JavaQuestionService(javaRepository);
        outM = new MathQuestionService(mathRepository);

    }


    private final String QUESTION1 = "Вопрос1";
    private final String QUESTION2 = "Вопрос2";
    private final String ANSWER1 = "Ответ1";
    private final String ANSWER2 = "Ответ2";
    private final Question questionJ = new Question(QUESTION1, ANSWER1);
    private final Question questionM = new Question(QUESTION2, ANSWER2);
    private final List QUESTIONS = new ArrayList<>(List.of(questionJ, questionM));

    @Test
    public void addTest() {
        when(javaRepository.add(QUESTION1, ANSWER1)).thenReturn(questionJ);
        when(mathRepository.add(QUESTION2, ANSWER2)).thenReturn(questionM);

        assertEquals(questionJ, outJ.add(QUESTION1, ANSWER1));
        assertEquals(questionM, outM.add(QUESTION2, ANSWER2));
        verify(javaRepository, times(1)).add(QUESTION1, ANSWER1);
        verify(mathRepository, times(1)).add(QUESTION2, ANSWER2);
    }

    @Test
    public void addWhenThrowTest() {
        when(javaRepository.add(any(), any())).thenThrow(IllegalArgumentException.class);
        when(mathRepository.add(any(), any())).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> outJ.add(QUESTION1, ANSWER1));
        assertThrows(IllegalArgumentException.class, () -> outM.add(QUESTION2, ANSWER2));
    }

    @Test
    public void removeTest() {
        when(javaRepository.remove(questionJ)).thenReturn(questionJ);
        when(mathRepository.remove(questionM)).thenReturn(questionM);

        assertEquals(questionJ, outJ.remove(questionJ));
        assertEquals(questionM, outM.remove(questionM));
        verify(javaRepository, times(1)).remove(questionJ);
        verify(mathRepository, times(1)).remove(questionM);

    }

    @Test
    public void removeWhenThrowTest() {
        when(javaRepository.remove(any())).thenThrow(QuestionNotFound.class);
        when(mathRepository.remove(any())).thenThrow(QuestionNotFound.class);
        assertThrows(QuestionNotFound.class, () -> outJ.remove(questionJ));
        assertThrows(QuestionNotFound.class, () -> outM.remove(questionM));
    }

    @Test
    public void getAllTestJava() {
        when(javaRepository.getAll()).thenReturn(QUESTIONS);
        assertIterableEquals(QUESTIONS, outJ.getAll());
    }

    @Test
    public void getAllTestMath() {
        when(mathRepository.getAll()).thenReturn(QUESTIONS);
        assertIterableEquals(QUESTIONS, outM.getAll());
    }

    @Test
    public void findTest() {
        when(javaRepository.find(QUESTION1)).thenReturn(questionJ);
        when(mathRepository.find(QUESTION2)).thenReturn(questionM);

        assertEquals(questionJ, outJ.find(QUESTION1));
        assertEquals(questionM, outM.find(QUESTION2));
        verify(javaRepository, times(1)).find(QUESTION1);
        verify(mathRepository, times(1)).find(QUESTION2);
    }

    @Test
    public void findWhenThrowTest() {
        when(javaRepository.find(any())).thenThrow(QuestionNotFound.class);
        when(mathRepository.find(any())).thenThrow(QuestionNotFound.class);
        assertThrows(QuestionNotFound.class, () -> outJ.find(QUESTION1));
        assertThrows(QuestionNotFound.class, () -> outM.find(QUESTION2));
    }
}

