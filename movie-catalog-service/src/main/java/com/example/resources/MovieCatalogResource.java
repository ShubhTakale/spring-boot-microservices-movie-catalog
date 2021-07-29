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
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("5698", 5)
		);
		
		return ratings.stream().map(rating ->{
		Movie movie = rt.getForObject("http://localhost:8003/movies/"+rating.getMovieId(), Movie.class); 
		return new CatalogItem(movie.getName(), "Test description", rating.getRating());
		}).collect(Collectors.toList());
	}
}
