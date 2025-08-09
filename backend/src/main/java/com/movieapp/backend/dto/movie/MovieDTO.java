package com.movieapp.backend.dto.movie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDTO {

    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private String director;

}