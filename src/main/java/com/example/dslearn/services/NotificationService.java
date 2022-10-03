package com.example.dslearn.services;

import com.example.dslearn.dto.NotificationDTO;
import com.example.dslearn.entities.Notification;
import com.example.dslearn.entities.User;
import com.example.dslearn.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> pages = repository.findByUser(user, pageable);
        return pages.map(NotificationDTO::new);
    }
}
