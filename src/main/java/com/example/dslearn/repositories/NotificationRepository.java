package com.example.dslearn.repositories;

import com.example.dslearn.entities.Notification;
import com.example.dslearn.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT noti FROM Notification noti WHERE " +
            "(noti.user = :user) AND " +
            "(:unreadOnly = FALSE OR noti.read = FALSE) " +
            "ORDER BY noti.moment DESC")
    Page<Notification> findNotifications(User user, boolean unreadOnly, Pageable pageable);
}
