package com.example.dslearn.entities;

import com.example.dslearn.entities.enums.ResourceType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_resource")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceType type;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
