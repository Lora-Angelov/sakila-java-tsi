package com.example.sakila.input;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Year;
import java.util.List;

@Data
public class FilmInput {

    @NotNull
    @Size(min = 1, max = 128)
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Year releaseYear;

    @NotNull
    private Byte languageId;

    @NotNull
    private Integer rentalDuration;

    @NotNull
    private BigDecimal rentalRate;

    @NotNull
    private Integer length;

    @NotNull
    private BigDecimal replacementCost;

    @NotNull
    private Date lastUpdate;

    private List<Short> actorId;
}
