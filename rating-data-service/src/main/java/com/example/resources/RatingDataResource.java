 package com.example.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

	public RatingDataResource() {
		System.out.println("in c'tor of "+this.getClass().getName());
	}
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 7);
	}
}
