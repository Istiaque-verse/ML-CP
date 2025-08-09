package com.mlcp.mlcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/problems")
public class ProblemController {

    @Autowired
    private ProblemRepository problemRepository;

    // READ: Get all problems
    @GetMapping
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    // READ: Get a problem by ID
    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable Long id) {
        Optional<Problem> problem = problemRepository.findById(id);
        return problem.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE: Add a new problem
    @PostMapping
    public Problem createProblem(@RequestBody Problem problem) {
        return problemRepository.save(problem);
    }

    // UPDATE: Update a problem by ID
    @PutMapping("/{id}")
    public ResponseEntity<Problem> updateProblem(@PathVariable Long id, @RequestBody Problem problemDetails) {
        Optional<Problem> optionalProblem = problemRepository.findById(id);
        if (!optionalProblem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Problem problem = optionalProblem.get();
        problem.setTitle(problemDetails.getTitle());
        problem.setDescription(problemDetails.getDescription());
        problem.setLink(problemDetails.getLink());
        problem.setTopics(problemDetails.getTopics());

        Problem updatedProblem = problemRepository.save(problem);
        return ResponseEntity.ok(updatedProblem);
    }

    // DELETE: Delete a problem by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        Optional<Problem> optionalProblem = problemRepository.findById(id);
        if (!optionalProblem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        problemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
