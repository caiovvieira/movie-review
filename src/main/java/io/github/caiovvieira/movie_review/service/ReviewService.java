package io.github.caiovvieira.movie_review.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.caiovvieira.movie_review.dto.MovieResponseDto;
import io.github.caiovvieira.movie_review.dto.RequestReviewDto;
import io.github.caiovvieira.movie_review.entity.Review;
import io.github.caiovvieira.movie_review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review save(RequestReviewDto reviewRequest) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "search/titles/" + reviewRequest.getMovieId()))
                .timeout(Duration.ofMinutes(2))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        MovieResponseDto responseDto = objectMapper.readValue(response.body(), MovieResponseDto.class);

        BigDecimal rating = new BigDecimal(reviewRequest.getRating())
                .multiply(BigDecimal.valueOf(2))
                .setScale(0, RoundingMode.DOWN)
                .divide(BigDecimal.valueOf(2));

        Review review = new Review();
        review.setMovieId(reviewRequest.getMovieId());
        review.setRating(rating);
        review.setReviewText(reviewRequest.getReviewText());
        return reviewRepository.save(review);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
