package com.technosignia.Movies.exception;

public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(String error) {
		super(error);
	}

}
