package com.alacriti.imdb.model.vo;

public class UserCommnets {
	private String textareacomment;
	private double rating;
	private String username;
	private String movieortvshow;
	private boolean isValidComment=false;
	
	
	public boolean isValidComment() {
		return isValidComment;
	}
	public void setValidComment(boolean isValidComment) {
		this.isValidComment = isValidComment;
	}
	public UserCommnets(){
		
	}
	public String getTextareacomment() {
		return textareacomment;
	}
	public void setTextareacomment(String textareacomment) {
		this.textareacomment = textareacomment;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMovieortvshow() {
		return movieortvshow;
	}
	public void setMovieortvshow(String movieortvshow) {
		this.movieortvshow = movieortvshow;
	}
	public UserCommnets(String textareacomment, double rating, String username,
			String movieortvshow) {
		super();
		this.textareacomment = textareacomment;
		this.rating = rating;
		this.username = username;
		this.movieortvshow = movieortvshow;
	}
	
}
