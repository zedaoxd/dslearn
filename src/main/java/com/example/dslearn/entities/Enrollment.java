package com.example.dslearn.entities;

import com.example.dslearn.entities.pk.EnrollmentPK;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {

    @EmbeddedId
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrolMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment = null;

    private boolean available = true;

    private boolean onlyUpdate;

    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> lessonsDone = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> delivers = new ArrayList<>();

    public Enrollment(User user, Offer offer, Instant enrolMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        this.id.setUser(user);
        this.id.setOffer(offer);
        this.enrolMoment = enrolMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent() {
        return this.id.getUser();
    }

    public void setStudent(User user) {
        this.id.setUser(user);
    }

    public Offer getOffer() {
        return this.id.getOffer();
    }

    public void setOffer(Offer offer) {
        this.id.setOffer(offer);
    }
}
