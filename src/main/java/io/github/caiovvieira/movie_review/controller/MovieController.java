package io.github.caiovvieira.movie_review.controller;

import io.github.caiovvieira.movie_review.dto.MovieDto;
import io.github.caiovvieira.movie_review.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> getAllMovies() {
        List<MovieDto> all = movieService.findAll();
        return all;
    }

    @GetMapping("/search")
    public List<MovieDto> getMovieByTitle(@RequestParam(value = "title", required = true) String title) {
        List<MovieDto> all = movieService.findByTitle(title);
        return all;
    }

}

