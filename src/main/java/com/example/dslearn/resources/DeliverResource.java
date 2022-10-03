package com.example.dslearn.resources;

import com.example.dslearn.dto.DeliverRevisionDTO;
import com.example.dslearn.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable("id") Long id, @RequestBody DeliverRevisionDTO dto) {
        service.saveRevision(id, dto);
        return ResponseEntity.noContent().build();
    }
}
