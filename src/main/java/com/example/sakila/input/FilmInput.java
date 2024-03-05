package com.example.sakila.input;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class FilmInput {

    @NotNull
    @Size(min = 1, max = 128)
    private String title;

    @NotNull
    private Byte languageId;

    @NotNull
    private Integer rentalDuration;

    @NotNull
    private BigDecimal rentalRate;

    @NotNull
    private Date lastUpdate;
}
