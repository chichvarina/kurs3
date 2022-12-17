package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.model.Question;

import java.util.Collection;

@Service
public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
