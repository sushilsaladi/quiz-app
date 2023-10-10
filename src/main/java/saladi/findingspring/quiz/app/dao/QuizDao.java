package saladi.findingspring.quiz.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import saladi.findingspring.quiz.app.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
