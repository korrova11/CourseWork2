package pro.sky.java.course2.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.CourseWork2.model.Question;
import pro.sky.java.course2.CourseWork2.service.JavaQuestionService;
import pro.sky.java.course2.CourseWork2.service.QuestionService;

import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {
    QuestionService out = new JavaQuestionService();
    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of("Вопрос1","Ответ1"),
                Arguments.of("Вопрос2","Ответ2"),
                Arguments.of("Вопрос3","Ответ3")
                );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void addTest(String question,String answer){
        out.add(question,answer);
        assertTrue(out.getAll().contains(new Question(question,answer)));
    }
    @Test
    public void addTestWhenIsElement(){
        out.add("Вопрос4","Ответ4");
        assertThrows(IllegalArgumentException.class,
                ()->{out.add("Вопрос4","Ответ4");});
    }
}
