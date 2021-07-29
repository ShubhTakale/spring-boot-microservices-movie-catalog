package com.example.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	public MovieResource() {
		System.out.println("In c'tor of "+this.getClass().getName());
	}
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test name");
	}
}
