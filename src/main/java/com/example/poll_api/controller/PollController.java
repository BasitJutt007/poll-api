package com.example.poll_api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// import com.example.poll_api.dto.PollRequest;
import com.example.poll_api.model.Poll;
import com.example.poll_api.service.PollService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/poll")

public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping("/submit")
    public ResponseEntity<Map<String, String>> submitPolls(@RequestBody List<Poll> polls) {
        pollService.saveAllPolls(polls);
        // Create a response object as JSON for TOASTER UI
        Map<String, String> response = new HashMap<>();
        response.put("message", "Polls submitted successfully");
        return ResponseEntity.ok(response);
    }

    // Endpoint to get all Polls
    @GetMapping("/all")
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    // Endpoint to delete a poll by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePollById(@PathVariable Long id) {
        pollService.deletePollById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Specific Poll deleted successfully");
        return ResponseEntity.ok(response);
    }

    // Endpoint to delete all polls
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Map<String, String>> deleteAllPolls() {
        pollService.deleteAllPolls();
        Map<String, String> response = new HashMap<>();
        response.put("message", "All Polls Deleted Successfully");
        return ResponseEntity.ok(response);
    }

}
