package com.example.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_course")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imgUri;

    private String imgGrayUri;

    @OneToMany(mappedBy = "course")
    @Setter(AccessLevel.NONE)
    private List<Offer> offers = new ArrayList<>();
}
