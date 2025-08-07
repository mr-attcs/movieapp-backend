package com.movieapp.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Setter
@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
@AllArgsConstructor
public class Review {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private Long id;

    @NotNull
    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int rating;

    @NotNull
    @Column(nullable = false)
    private String comment;

    @ToString.Exclude
    @NotNull
    @ManyToOne
    private User user;

    @ToString.Exclude
    @NotNull
    @ManyToOne
    private Movie movie;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
