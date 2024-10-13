package com.example.poll_api.service;

import com.example.poll_api.model.Poll;
import com.example.poll_api.repository.PollRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // Save a new poll
    public void savePoll(Poll poll) {
        pollRepository.save(poll);
    }

    // Fetch all polls
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    // Delete a poll by its ID
    public void deletePollById(Long id) {
        pollRepository.deleteById(id);
    }

    // Delete all polls
    @Transactional
    public void deleteAllPolls() {
        pollRepository.deleteAll();
        entityManager.createNativeQuery("ALTER TABLE polls AUTO_INCREMENT = 1").executeUpdate(); // Reset AUTO_INCREMENT
    }

}
