 package com.example.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Rating;
import com.example.models.UserRating;

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
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		UserRating ur = new UserRating();
		ur.setUserRatings( Arrays.asList(
				new Rating("1234", 4),
				new Rating("5698", 5)
		));
		return ur;
	}
}
