package com.alacriti.imdb.model.vo.tvshows;

import java.util.ArrayList;

public class TvShowComments {

	private String tvshowname;
	private ArrayList<ListedTvShowComments> listedTvShowComments;
	
	public TvShowComments(){
		
	}

	public String getTvshowname() {
		return tvshowname;
	}

	public void setTvshowname(String tvshowname) {
		this.tvshowname = tvshowname;
	}

	public ArrayList<ListedTvShowComments> getListedTvShowComments() {
		return listedTvShowComments;
	}

	public void setListedTvShowComments(
			ArrayList<ListedTvShowComments> listedTvShowComments) {
		this.listedTvShowComments = listedTvShowComments;
	}

	public TvShowComments(String tvshowname,
			ArrayList<ListedTvShowComments> listedTvShowComments) {
		super();
		this.tvshowname = tvshowname;
		this.listedTvShowComments = listedTvShowComments;
	}
	
}
