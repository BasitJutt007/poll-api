package com.example.poll_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.poll_api.model.Poll;
import com.example.poll_api.service.PollService;

@RestController
@RequestMapping("/api/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    // Endpoints to Submit PollData
    @PostMapping("/submit")
    public ResponseEntity<String> submitPoll(@RequestBody Poll poll) {
        pollService.savePoll(poll);
        return ResponseEntity.ok("Poll Submitted Successfully");
    }

    // Endpoint to get all Polls
    @GetMapping("/all")
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    // Endpoint to delete a poll by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePollById(@PathVariable Long id) {
        pollService.deletePollById(id);
        return ResponseEntity.ok("Poll deleted successfully!");
    }

    // Endpoint to delete all polls
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllPolls() {
        pollService.deleteAllPolls();
        return ResponseEntity.ok("All polls deleted successfully!");
    }

}
