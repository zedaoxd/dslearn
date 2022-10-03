package com.example.dslearn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_task")
public class Task extends Lesson{

    private String description;

    private Integer questionCount;

    private Integer approvalCount;

    private Double weight;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;

    public Task(Long id, String title, Integer position, Section section, Set<Enrollment> enrollmentsDone, List<Deliver> delivers,
                List<Topic> topics, String description, Integer questionCount, Integer approvalCount, Double weight, Instant dueDate) {
        super(id, title, position, section, enrollmentsDone, delivers, topics);
        this.description = description;
        this.questionCount = questionCount;
        this.approvalCount = approvalCount;
        this.weight = weight;
        this.dueDate = dueDate;
    }
}
