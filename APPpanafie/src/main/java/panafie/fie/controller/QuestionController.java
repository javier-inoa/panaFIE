package panafie.fie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.model.question.Question;
import panafie.fie.repository.QuestionRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    // Obtener todas las preguntas
    @PostMapping("/getAll")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> result = questionRepository.findAll();
        return ResponseEntity.ok(result);
    }

    // Obtener una pregunta por ID
    @PostMapping("/getById")
    public ResponseEntity<Question> getQuestionById(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Optional<Question> question = questionRepository.findById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva pregunta
    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionRepository.save(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    // Actualizar una pregunta existente
    @PostMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question questionDetails) {
        Optional<Question> questionOptional = questionRepository.findById(questionDetails.getId());
        if (!questionOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Question question = questionOptional.get();
        question.setUserId(questionDetails.getUserId());
        question.setQuestion(questionDetails.getQuestion());
        question.setAnswer(questionDetails.getAnswer());
        question.setDate(questionDetails.getDate());

        Question updatedQuestion = questionRepository.save(question);
        return ResponseEntity.ok(updatedQuestion);
    }

    // Eliminar una pregunta
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteQuestion(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Optional<Question> question = questionRepository.findById(id);
        if (!question.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        questionRepository.delete(question.get());
        return ResponseEntity.noContent().build();
    }
}
