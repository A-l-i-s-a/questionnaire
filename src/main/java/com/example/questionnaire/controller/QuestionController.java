package com.example.questionnaire.controller;

import com.example.questionnaire.model.Question;
import com.example.questionnaire.repository.QuestionRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/question", produces = "application/json")
@CrossOrigin(origins = "*")
public class QuestionController {
    
    private QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAll() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getById(@PathVariable("id") Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion.map(question ->  new ResponseEntity<>(question, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Question postQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/{id}")
    public Question putQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteQuestion(@RequestBody Question question) {
        try {
            questionRepository.delete(question);
        } catch (EmptyResultDataAccessException e) {}
    }
}
