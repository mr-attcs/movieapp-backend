package com.movieapp.backend.mapper;

import com.movieapp.backend.dto.review.ReviewRequestDTO;
import com.movieapp.backend.dto.review.ReviewResponseDTO;
import com.movieapp.backend.model.Movie;
import com.movieapp.backend.model.Review;
import com.movieapp.backend.model.User;

public class ReviewMapper {

    public static ReviewResponseDTO convertToDTO(Review review) {
        if (review == null) return null;
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(review.getCreatedAt())
                .userId(review.getId() != null ? review.getUser().getId() : null)
                .movieId(review.getMovie() != null ? review.getMovie().getId() : null)
                .build();
    }

    public static Review convertToReview(ReviewRequestDTO dto, User user, Movie movie) {
        return Review.builder()
                .rating(dto.getRating())
                .comment(dto.getComment())
                .user(user)
                .movie(movie)
                .build();
    }

}
