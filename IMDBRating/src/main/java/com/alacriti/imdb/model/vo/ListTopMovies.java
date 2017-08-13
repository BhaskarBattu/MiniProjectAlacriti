package com.alacriti.imdb.model.vo;

public class ListTopMovies {
	private int movieId;
	private String movieName;
	private String imagePath;
	private double avgRating;
	private int count;
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ListTopMovies(){
		
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
	public ListTopMovies(int movieId, String movieName, String imagePath, 
			double avgRating, int count) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.imagePath = imagePath;
		this.avgRating = avgRating;
		this.count = count;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
