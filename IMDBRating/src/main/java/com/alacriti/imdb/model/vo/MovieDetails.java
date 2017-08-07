package com.alacriti.imdb.model.vo;

import java.util.ArrayList;

public class MovieDetails {
	private String moviename;
	private MovieReturnFileds movieFields;
	
	
	
	private ArrayList<MovieReturnFileds> movieGett;
	
	public ArrayList<MovieReturnFileds> getMovieGett() {
		return movieGett;
	}
	public void setMovieGett(ArrayList<MovieReturnFileds> movieGett) {
		this.movieGett = movieGett;
	}
	public MovieDetails(){
		
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	/*public ArrayList<MovieReturnFileds> getMovieFields() {
		return movieFields;
	}*/
	/*public void setMovieFields(ArrayList<MovieReturnFileds> movieFields) {
		this.movieFields = movieFields;
	}*/
	/*public MovieDetails(String moviename,
			ArrayList<MovieReturnFileds> movieFields) {
		this.moviename = moviename;
		this.movieFields = movieFields;
		
	}*/
	public MovieReturnFileds getMovieFields() {
		return movieFields;
	}
	public MovieDetails(String moviename, MovieReturnFileds movieFields) {
		super();
		this.moviename = moviename;
		this.movieFields = movieFields;
	}
	public void setMovieFields(MovieReturnFileds movieFields) {
		this.movieFields = movieFields;
	}
}
