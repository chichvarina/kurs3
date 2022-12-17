package pro.sky.java.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.model.Question;
import pro.sky.java.course2.service.JavaQuestionService;

public class JavaQuestionServiceTest {

    private JavaQuestionService questionService;

    @BeforeEach
    public void init(){
        questionService = new JavaQuestionService();
        questionService.add("Вопрос_0","Ответ_0");
        questionService.add("Вопрос_1","Ответ_1");
        questionService.add("Вопрос_2","Ответ_2");
        questionService.add("Вопрос_3","Ответ_3");
        questionService.add("Вопрос_4","Ответ_4");
    }


    @Test
    public void getAllTest(){
        Question[] expectedArray = {
                new Question("Вопрос_0","Ответ_0"),
                new Question("Вопрос_1","Ответ_1"),
                new Question("Вопрос_2","Ответ_2"),
                new Question("Вопрос_3","Ответ_3"),
                new Question("Вопрос_4","Ответ_4"),
        };
        Assertions.assertArrayEquals(expectedArray, questionService.getAll().toArray());
    }

    @Test
    public void addTest1(){
        questionService.add("Вопрос_5","Ответ_5");
        Question[] expectedArray = {
            new Question("Вопрос_0","Ответ_0"),
            new Question("Вопрос_1","Ответ_1"),
            new Question("Вопрос_2","Ответ_2"),
            new Question("Вопрос_3","Ответ_3"),
            new Question("Вопрос_4","Ответ_4"),
            new Question("Вопрос_5","Ответ_5")
        };
        Assertions.assertArrayEquals(expectedArray, questionService.getAll().toArray());
    }

    @Test
    public void addTest2(){
        questionService.add(new Question("Вопрос_5","Ответ_5"));
        Question[] expectedArray = {
                new Question("Вопрос_0","Ответ_0"),
                new Question("Вопрос_1","Ответ_1"),
                new Question("Вопрос_2","Ответ_2"),
                new Question("Вопрос_3","Ответ_3"),
                new Question("Вопрос_4","Ответ_4"),
                new Question("Вопрос_5","Ответ_5")
        };
        Assertions.assertArrayEquals(expectedArray, questionService.getAll().toArray());
    }

    @Test
    public void removeTest(){
        questionService.remove(new Question("Вопрос_3","Ответ_3"));
        Question[] expectedArray = {
                new Question("Вопрос_0","Ответ_0"),
                new Question("Вопрос_1","Ответ_1"),
                new Question("Вопрос_2","Ответ_2"),
                new Question("Вопрос_4","Ответ_4"),

        };
        Assertions.assertArrayEquals(expectedArray, questionService.getAll().toArray());
    }


}

