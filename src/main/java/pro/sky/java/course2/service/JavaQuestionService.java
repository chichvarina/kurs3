package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    //выбираю коллекцию HashSet чтобы нельзя было добавить одинаковые пары Ворос-Ответ
    private final HashSet<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        questions = new HashSet<>();
        random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        Iterator<Question> iterator = questions.iterator();
        int index = 0;
        Question result = null;
        while (iterator.hasNext()) {
            result = iterator.next();
            if(index == randomIndex){
                break;
            }
            index++;
        }
        return result;
    }
}
