package com.alacriti.imdb.model.vo;

public class SearchAllThings {
	
	private String searchitem;


	
	public SearchAllThings(){
		
	}
	public SearchAllThings(String searchitem) {
		super();
		this.searchitem = searchitem;
		
	}

	public String getSearchitem() {
		return searchitem;
	}

	public void setSearchitem(String searchitem) {
		this.searchitem = searchitem;
	}
	
}
