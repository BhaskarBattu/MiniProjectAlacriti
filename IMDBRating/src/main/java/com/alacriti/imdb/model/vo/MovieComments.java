package com.alacriti.imdb.model.vo;

import java.util.ArrayList;

public class MovieComments {
	private String moviename;
	private ArrayList<ListedMovieComments> listedMovieComments;
	
	public MovieComments(){
		
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public ArrayList<ListedMovieComments> getListedMovieComments() {
		return listedMovieComments;
	}
	public void setListedMovieComments(
			ArrayList<ListedMovieComments> listedMovieComments) {
		this.listedMovieComments = listedMovieComments;
	}
	public MovieComments(String moviename,
			ArrayList<ListedMovieComments> listedMovieComments) {
		super();
		this.moviename = moviename;
		this.listedMovieComments = listedMovieComments;
	}
	
	

}
