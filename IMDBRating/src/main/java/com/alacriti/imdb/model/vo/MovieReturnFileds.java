package com.alacriti.imdb.model.vo;


public class MovieReturnFileds {
	
	private String actors;
	private String genreType;
	private String actorProfession;
	private String description;
	private String date;
	private String imagePath;
	
	//private ArrayList<MovieReturnFileds> moviessGett;
	
	/*public ArrayList<MovieReturnFileds> getMoviessGett() {
		return moviessGett;
	}
	public void setMoviessGett(ArrayList<MovieReturnFileds> moviessGett) {
		this.moviessGett = moviessGett;
	}*/
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public MovieReturnFileds(){
		
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getGenreType() {
		return genreType;
	}
	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	public String getActorProfession() {
		return actorProfession;
	}
	public void setActorProfession(String actorProfession) {
		this.actorProfession = actorProfession;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public MovieReturnFileds(String actors, String genreType, String actorProfession,
			String description, String date,String imagePath) {
		this.actors = actors;
		this.genreType = genreType;
		this.actorProfession = actorProfession;
		this.description = description;
		this.date = date;
		this.imagePath = imagePath;
	}
	
}
