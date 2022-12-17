package pro.sky.java.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course2.service.ExaminerServiceImpl;
import pro.sky.java.course2.service.JavaQuestionService;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    JavaQuestionService questionService;
    ExaminerServiceImpl examinerService;


    @BeforeEach
    public void init(){
        questionService = new JavaQuestionService();
        questionService.add("Вопрос_0","Ответ_0");
        questionService.add("Вопрос_1","Ответ_1");
        questionService.add("Вопрос_2","Ответ_2");
        questionService.add("Вопрос_3","Ответ_3");
        questionService.add("Вопрос_4","Ответ_4");

        examinerService = new ExaminerServiceImpl(questionService);

    }

    @Test
    public void exceptionTest(){
        Assertions.assertThrows(
                ResponseStatusException.class,
                ()-> examinerService.getQuestions(6)
        );
    }

    @Test
    public void sizeTest(){
        Assertions.assertEquals(3, examinerService.getQuestions(3).size());
    }

}
