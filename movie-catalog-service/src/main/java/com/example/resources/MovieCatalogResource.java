package com.example.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.models.CatalogItem;
import com.example.models.Movie;
import com.example.models.Rating;
import com.example.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
    private	RestTemplate rt ;
	
	public MovieCatalogResource() {
		System.out.println("Inside ctor of "+this.getClass().getName());
	}
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings = rt.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);
		
		return ratings.getUserRatings().stream().map(rating ->{
		Movie movie = rt.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class); 
		return new CatalogItem(movie.getName(), "Test description", rating.getRating());
		}).collect(Collectors.toList());
	}
}
