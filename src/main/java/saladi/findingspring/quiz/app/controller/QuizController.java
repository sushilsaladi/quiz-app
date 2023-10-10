package saladi.findingspring.quiz.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saladi.findingspring.quiz.app.model.QuestionWrapper;
import saladi.findingspring.quiz.app.model.Response;
import saladi.findingspring.quiz.app.service.QuizService;

@RestController
@RequestMapping("quiz")
// POST => quiz/create?category=Olympics&numQ=3&title=OlympicsQuiz
// GET => quiz/get/1
// POST => quiz/submit/1
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title ){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
