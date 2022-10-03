package com.example.dslearn.dto;

import com.example.dslearn.entities.enums.DeliverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliverRevisionDTO implements Serializable {

    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;
}
