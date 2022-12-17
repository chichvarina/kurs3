package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.model.Question;

import java.util.Collection;
@Service
public interface ExamineService {
    Collection<Question> getQuestions(int amount);
}
