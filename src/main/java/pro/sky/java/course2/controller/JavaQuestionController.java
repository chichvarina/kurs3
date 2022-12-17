package pro.sky.java.course2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.model.Question;
import pro.sky.java.course2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    public QuestionService questionService;

    @Autowired
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
    @GetMapping("/add")
    public Question addQuestion(String question, String answer){
        return questionService.add(question, answer);
    }

    //Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
    @GetMapping("/remove")
    public Question removeQuestion(String question, String answer){
        Question q = new Question(question, answer);
        return questionService.remove(q);
    }

    //Получить все вопросы: “/exam/java”
    @GetMapping("")
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }

}

