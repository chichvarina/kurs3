package pro.sky.java.course2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course2.model.Question;
import pro.sky.java.course2.service.ExamineService;

import java.util.Collection;

@RestController
public class ExamController {

    public ExamineService examineService;

    @Autowired
    public ExamController(ExamineService examineService) {
        this.examineService = examineService;
    }

    @GetMapping("/exam/get")
    public Collection<Question> getQuestions(int amount){
        return examineService.getQuestions(amount);
    }
}
