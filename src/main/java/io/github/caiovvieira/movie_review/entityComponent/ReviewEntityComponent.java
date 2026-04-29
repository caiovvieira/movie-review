package io.github.caiovvieira.movie_review.entityComponent;

import io.github.caiovvieira.movie_review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityComponent {

    public boolean isValidReview(Review review) {
        return review != null && review.getReviewText() != null && !review.getReviewText().trim().isEmpty() && review.getRating() >= 1 && review.getRating() <= 5;
    }

    public String getReviewSummary(Review review) {
        return "Rating: " + review.getRating() + "/5 - " + review.getReviewText().substring(0, Math.min(50, review.getReviewText().length())) + "...";
    }
}
