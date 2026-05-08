package io.github.caiovvieira.movie_review.repository;

import io.github.caiovvieira.movie_review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
