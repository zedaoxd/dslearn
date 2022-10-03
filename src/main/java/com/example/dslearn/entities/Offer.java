package com.example.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_offer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String edition;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offer")
    @Setter(AccessLevel.NONE)
    private List<Resource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "offer")
    @Setter(AccessLevel.NONE)
    private List<Topic> topics = new ArrayList<>();
}
