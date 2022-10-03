package com.example.dslearn.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAuthCustomError implements Serializable {

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;
}
