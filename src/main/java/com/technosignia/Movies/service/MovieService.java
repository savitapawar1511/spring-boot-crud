package com.technosignia.Movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.technosignia.Movies.entity.Movie;
import com.technosignia.Movies.exception.MovieNotFoundException;
import com.technosignia.Movies.repository.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	public Movie createMovieDetails(Movie movie) {
		
		return movieRepository.save(movie) ;
	}
	@Cacheable(value="movies")
	
	public List<Movie>findAllMovieDetails() {
		
		return movieRepository.findAll();
	}

	public Double findMaxRate() {
		
		return movieRepository.maxValue(); 
	}

	public Double findMinRate() {
		
		return movieRepository.minValue();

	}
	
	@Cacheable(value="movies")
	public ResponseEntity<?> findMovieDetailsByName(String name) {
     Optional<Movie>opmovie=movieRepository.findMovieDetailsByName(name);
		
		if(opmovie.isPresent()) {
		 
	       return new ResponseEntity<Movie>(opmovie.get(),HttpStatus.OK);	 		
	}else {
		throw new MovieNotFoundException("Movie details not found for given name:"+name);

	}

	}	
	
   }
