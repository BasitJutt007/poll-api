package com.example.poll_api.dto;

import com.example.poll_api.model.Poll;
import java.util.List;

public class PollRequest {
    private List<Poll> answers;

    public List<Poll> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Poll> answers) {
        this.answers = answers;
    }
}
