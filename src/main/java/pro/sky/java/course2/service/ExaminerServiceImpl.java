package pro.sky.java.course2.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course2.model.Question;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExamineService{

    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount>questionService.getAll().size()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Превышено количество запрашиваемых вопросов");
        }

        HashSet<Question> randomQuestions = new HashSet<>();
        do {
            Question randonQuestion = questionService.getRandomQuestion();
            randomQuestions.add(randonQuestion);
        }while (randomQuestions.size()<amount);

        return randomQuestions;
    }
}

