package com.movieapp.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Min(1880)
    @Max(2100)
    @Column(nullable = false)
    private int releaseYear;

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String genre;

    @NotNull
    @Column(nullable = false)
    private String director;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @ToString.Exclude
    @OneToMany(mappedBy = "movie")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();


}
