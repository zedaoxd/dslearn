package com.example.dslearn.resources;

import com.example.dslearn.dto.UserDTO;
import com.example.dslearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService services;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        UserDTO dto = services.findById(id);
        return ResponseEntity.ok(dto);
    }
}
