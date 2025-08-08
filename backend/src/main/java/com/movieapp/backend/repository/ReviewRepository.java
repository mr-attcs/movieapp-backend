package com.movieapp.backend.repository;

import com.movieapp.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUserId(Long userId);
    List<Review> findByMovieId(Long movieId);

}
