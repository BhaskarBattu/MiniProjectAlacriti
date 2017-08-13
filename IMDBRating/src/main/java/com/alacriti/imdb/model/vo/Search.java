package com.alacriti.imdb.model.vo;

import java.util.ArrayList;

public class Search {
	
ArrayList<SearchAllThings> searchAllItems;

public Search(){
	
}
public Search(ArrayList<SearchAllThings> searchAllItems) {
	super();
	this.searchAllItems = searchAllItems;
	System.out.println(this.searchAllItems);
}
public ArrayList<SearchAllThings> getSearchAllItems() {
	return searchAllItems;
}

public void setSearchAllItems(ArrayList<SearchAllThings> searchAllItems) {
	this.searchAllItems = searchAllItems;
}

}
