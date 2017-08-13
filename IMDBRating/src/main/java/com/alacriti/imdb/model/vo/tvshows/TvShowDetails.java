package com.alacriti.imdb.model.vo.tvshows;

import java.util.ArrayList;

public class TvShowDetails {

	private String tvshowname;
	//private TvShowReturnFileds tvshowDetailFields;
	private ArrayList<TvShowReturnFileds> tvshowDetailListGett;
	
	public TvShowDetails(){
		
	}
	
	public TvShowDetails(String tvshowname,
			ArrayList<TvShowReturnFileds> tvshowDetailListGett) {
		super();
		this.tvshowname = tvshowname;
		this.tvshowDetailListGett = tvshowDetailListGett;
	}
	public String getTvshowname() {
		return tvshowname;
	}
	public void setTvshowname(String tvshowname) {
		this.tvshowname = tvshowname;
	}
	public ArrayList<TvShowReturnFileds> getTvshowDetailListGett() {
		return tvshowDetailListGett;
	}
	public void setTvshowDetailListGett(
			ArrayList<TvShowReturnFileds> tvshowDetailListGett) {
		this.tvshowDetailListGett = tvshowDetailListGett;
	}
	
	
}
