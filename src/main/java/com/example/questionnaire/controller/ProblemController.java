package com.example.questionnaire.controller;

import com.example.questionnaire.model.Problem;
import com.example.questionnaire.repository.ProblemRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/problem", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProblemController {
    
    private ProblemRepository problemRepository;

    public ProblemController(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Problem>> getAll() {
        return new ResponseEntity<>(problemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> getById(@PathVariable("id") Long id) {
        Optional<Problem> optionalProblem = problemRepository.findById(id);
        return optionalProblem.map(problem ->  new ResponseEntity<>(problem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Problem postProblem(@RequestBody Problem problem) {
        return problemRepository.save(problem);
    }

    @PutMapping("/{id}")
    public Problem putProblem(@RequestBody Problem problem) {
        return problemRepository.save(problem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProblem(@RequestBody Problem problem) {
        try {
            problemRepository.delete(problem);
        } catch (EmptyResultDataAccessException e) {}
    }
}
