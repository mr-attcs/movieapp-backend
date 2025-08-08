package com.movieapp.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDTO {

    private Long id;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
    private Long userId;
    private Long movieId;

}
