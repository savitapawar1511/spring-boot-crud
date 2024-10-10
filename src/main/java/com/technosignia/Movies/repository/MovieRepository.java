package com.technosignia.Movies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.technosignia.Movies.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
    @Query(value = "SELECT MAX(rate) FROM Movie")    
	public double maxValue();
    
    @Query(value = "SELECT MIN(rate) FROM Movie")
    public Double minValue();

	public Optional<Movie> findMovieDetailsByName(@Param (value="name")String name);
	
}
