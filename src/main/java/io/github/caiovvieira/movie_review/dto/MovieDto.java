package io.github.caiovvieira.movie_review.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
    private String id;
    private String type;
    private String primaryTitle;
    private String originalTitle;
    private MovieImageDto primaryImage;
    private Integer startYear;
    private List<String> genres;
    private MovieRatingDto rating;
}
