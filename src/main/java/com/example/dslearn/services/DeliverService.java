package com.example.dslearn.services;

import com.example.dslearn.dto.DeliverRevisionDTO;
import com.example.dslearn.entities.Deliver;
import com.example.dslearn.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository repository;

    @Transactional
    public void saveRevision(Long deliverId, DeliverRevisionDTO dto) {
        Deliver entity = repository.getReferenceById(deliverId);
        entity.setStatus(dto.getStatus());
        entity.setFeedback(dto.getFeedback());
        entity.setCorrectCount(dto.getCorrectCount());
        repository.save(entity);
    }
}
