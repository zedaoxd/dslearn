package com.example.dslearn.dto;

import com.example.dslearn.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    public UserDTO(User entity) {
        this(entity.getId(), entity.getName(), entity.getEmail());
    }
}
