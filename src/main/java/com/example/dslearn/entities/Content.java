package com.example.dslearn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_content")
public class Content extends Lesson{

    private String textContent;

    private String videoUri;

    public Content(Long id, String title, Integer position, Section section, Set<Enrollment> enrollmentsDone, String textContent, String videoUri) {
        super(id, title, position, section, enrollmentsDone);
        this.textContent = textContent;
        this.videoUri = videoUri;
    }
}
