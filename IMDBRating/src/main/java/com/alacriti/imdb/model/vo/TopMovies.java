package com.alacriti.imdb.model.vo;

import java.util.ArrayList;

public class TopMovies {
	
	private TopMovies topMovies;
	private ArrayList<ListTopMovies> listTopMovies;
	
	public TopMovies(){
		
	}
	public TopMovies getTopMovies() {
		return topMovies;
	}
	public void setTopMovies(TopMovies topMovies) {
		this.topMovies = topMovies;
	}
	public ArrayList<ListTopMovies> getListTopMovies() {
		return listTopMovies;
	}
	public void setListTopMovies(ArrayList<ListTopMovies> listTopMovies) {
		this.listTopMovies = listTopMovies;
	}
	public TopMovies(TopMovies topMovies, ArrayList<ListTopMovies> listTopMovies) {
		super();
		this.topMovies = topMovies;
		this.listTopMovies = listTopMovies;
	}
	
}
