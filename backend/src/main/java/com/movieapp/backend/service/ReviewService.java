package com.movieapp.backend.service;

import com.movieapp.backend.dto.review.ReviewRequestDTO;
import com.movieapp.backend.dto.review.ReviewResponseDTO;
import com.movieapp.backend.mapper.ReviewMapper;
import com.movieapp.backend.model.Movie;
import com.movieapp.backend.model.Review;
import com.movieapp.backend.model.User;
import com.movieapp.backend.repository.MovieRepository;
import com.movieapp.backend.repository.ReviewRepository;
import com.movieapp.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public ReviewResponseDTO createReview(ReviewRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Review review = ReviewMapper.convertToReview(dto, user, movie);
        Review saved = reviewRepository.save(review);
        return ReviewMapper.convertToDTO(saved);
    }

    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<ReviewResponseDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(ReviewMapper::convertToDTO)
                .toList();
    }

    public ReviewResponseDTO findByUserId(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewMapper::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
    }

    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO dto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        return ReviewMapper.convertToDTO(reviewRepository.save(review));
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new EntityNotFoundException("Review not found");
        }
        reviewRepository.deleteById(id);
    }
}
