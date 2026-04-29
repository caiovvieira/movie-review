package io.github.caiovvieira.movie_review.controller;

import io.github.caiovvieira.movie_review.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public void getAllMovies() {

    }

    @GetMapping("/{id}")
    public void getMovieById(@PathVariable Long id) {

    }

}
