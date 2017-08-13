package com.alacriti.imdb.model.vo.tvshows;

import java.util.ArrayList;


public class TopTvshows {
	private TopTvshows topTvShows;
	private ArrayList<ListTopTvshows> listTvShows;
	
	public TopTvshows(){
		
	}

	public TopTvshows getTopTvShows() {
		return topTvShows;
	}

	public void setTopTvShows(TopTvshows topTvShows) {
		this.topTvShows = topTvShows;
	}

	public ArrayList<ListTopTvshows> getListTvShows() {
		return listTvShows;
	}

	public void setListTvShows(ArrayList<ListTopTvshows> listTvShows) {
		this.listTvShows = listTvShows;
	}

	public TopTvshows(TopTvshows topTvShows,
			ArrayList<ListTopTvshows> listTvShows) {
		super();
		this.topTvShows = topTvShows;
		this.listTvShows = listTvShows;
	}
	
	
}
