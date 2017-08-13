package com.alacriti.imdb.model.vo;

import java.util.Date;

public class ListedMovieComments {

	private String firstName;
	private String lastName;
	private double rating;
	private String comments;
	private Date date;
	
	public ListedMovieComments(){
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ListedMovieComments(String firstName, String lastName,
			double rating, String comments,Date date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.comments = comments;
		this.date=date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
