package com.technosignia.Movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.technosignia.Movies.entity.Movie;
import com.technosignia.Movies.service.MovieService;

@RestController
public class MovieController {
	
	   @Autowired
	   MovieService movieService;
	   
	   @PostMapping("/movie")
	   public Movie createMovieDetails(@RequestBody Movie movie) {
		   return movieService.createMovieDetails(movie);
	   }
	   
	   @GetMapping("/movie")
	   public List<Movie> findAllMovieDetails() {
		   return movieService.findAllMovieDetails();
	   }
	   
       @GetMapping("/maxRate")
       public Double findMaxRate(){
    	   return movieService.findMaxRate(); 
       }
       
       @GetMapping("/minRate")
       public Double findMinRate(){
    	   return movieService.findMinRate(); 
       }
       
       @GetMapping("/movie/name/{name}")
       public ResponseEntity<?> findMovieDetailsByName(@PathVariable String name) {
     	  return movieService.findMovieDetailsByName(name);
       }
}