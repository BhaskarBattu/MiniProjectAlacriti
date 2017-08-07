package com.alacriti.imdb.model.vo;

public class TopRatedMovieTvshows {
	private String moviename;
	private String description;
	
	
	public TopRatedMovieTvshows() {
		
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TopRatedMovieTvshows(String moviename, String description) {
		this.moviename = moviename;
		this.description = description;
	}
	//public ArrarList<TopRatedMovieTvshows> 
	
}
