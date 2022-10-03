package com.example.dslearn.dto;

import com.example.dslearn.entities.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO implements Serializable {

    private Long id;

    private String text;

    private Instant moment;

    private boolean read;

    private String route;

    private Long userId;

    public NotificationDTO(Notification entity) {
        this(entity.getId(), entity.getText(), entity.getMoment(), entity.isRead(), entity.getRoute(), entity.getUser().getId());
    }
}
