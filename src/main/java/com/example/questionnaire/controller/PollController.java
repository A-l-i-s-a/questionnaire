package com.example.questionnaire.controller;

import com.example.questionnaire.model.Poll;
import com.example.questionnaire.repository.PollRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/poll", produces = "application/json")
@CrossOrigin(origins = "*")
public class PollController {
    
    private PollRepository pollRepository;

    public PollController(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Poll>> getAll() {
        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getById(@PathVariable("id") Long id) {
        Optional<Poll> optionalPoll = pollRepository.findById(id);
        return optionalPoll.map(poll ->  new ResponseEntity<>(poll, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Poll postPoll(@RequestBody Poll poll) {
        return pollRepository.save(poll);
    }

    @PutMapping("/{id}")
    public Poll putPoll(@RequestBody Poll poll) {
        return pollRepository.save(poll);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePoll(@RequestBody Poll poll) {
        try {
            pollRepository.delete(poll);
        } catch (EmptyResultDataAccessException e) {}
    }
}