package com.alacriti.imdb.model.vo;

public class ListTopMovies {
	private String movieName;
	private String imagePath;
	
	public ListTopMovies(){
		
	}
	public ListTopMovies(String movieName, String imagePath) {
		super();
		this.movieName = movieName;
		this.imagePath = imagePath;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
