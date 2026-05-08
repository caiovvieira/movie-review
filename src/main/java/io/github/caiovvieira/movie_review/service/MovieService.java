package io.github.caiovvieira.movie_review.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.caiovvieira.movie_review.dto.MovieDto;
import io.github.caiovvieira.movie_review.dto.MovieResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Value("${api-key}")
    private String url;

    public List<MovieDto> findAll() {
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + "titles?types=MOVIE"))
                    .timeout(Duration.ofMinutes(2))
                    .build();

            ObjectMapper objectMapper = new ObjectMapper();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            MovieResponseDto responseDto = objectMapper.readValue(response.body(), MovieResponseDto.class);
            List<MovieDto> movies = responseDto.getTitles();

            return movies;
        }
        catch (Exception e) {
            return null;
        }
    }

    public List<MovieDto> findByTitle(String title) {
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + "search/titles?query=" + title))
                    .timeout(Duration.ofMinutes(2))
                    .build();

            ObjectMapper objectMapper = new ObjectMapper();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            MovieResponseDto responseDto = objectMapper.readValue(response.body(), MovieResponseDto.class);
            List<MovieDto> result = responseDto.getTitles();
            List<MovieDto> movies = result.stream().filter(movie -> movie.getType().equals("movie")).toList();
            return movies;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
