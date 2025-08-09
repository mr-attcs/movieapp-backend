package com.movieapp.backend.mapper;

import com.movieapp.backend.dto.movie.MovieDTO;
import com.movieapp.backend.model.Movie;

public class MovieMapper {

    public static MovieDTO convertToDTO (Movie movie) {
        if (movie == null) return null;
        return MovieDTO.builder()
                .id(movie.getId())
                .genre(movie.getGenre())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .releaseYear(movie.getReleaseYear())
                .build();
    }

}
