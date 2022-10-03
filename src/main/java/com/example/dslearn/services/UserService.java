package com.example.dslearn.services;

import com.example.dslearn.dto.UserDTO;
import com.example.dslearn.entities.User;
import com.example.dslearn.repositories.UserRepository;
import com.example.dslearn.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found with id: " + id));
        return new UserDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);
            throw  new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);
        return user;
    }
}
