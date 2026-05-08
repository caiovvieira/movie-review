package io.github.caiovvieira.movie_review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestReviewDto {
    @NotNull
    @Max(12)
    private String movieId;

    @NotNull
    @Max(5)
    @Min(0)
    private Double rating;

    private String reviewText;

}
