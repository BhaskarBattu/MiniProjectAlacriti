package com.alacriti.imdb.model.vo.tvshows;

public class ListTopTvshows {
	private int tvShowId;
	private String tvShowName;
	private String tvshowImagePath;
	private double avgRating;
	private int memberscount;
	
	public ListTopTvshows(){
		
	}
	public ListTopTvshows(int tvShowId, String tvShowName,
			String tvshowImagePath, double avgRating, int memberscount) {
		super();
		this.tvShowId = tvShowId;
		this.tvShowName = tvShowName;
		this.tvshowImagePath = tvshowImagePath;
		this.avgRating = avgRating;
		this.memberscount = memberscount;
	}
	public int getTvShowsID() {
		return tvShowId;
	}
	public void setTvShowsID(int tvShowId) {
		this.tvShowId = tvShowId;
	}
	public String getTvShowName() {
		return tvShowName;
	}
	public void setTvShowName(String tvShowName) {
		this.tvShowName = tvShowName;
	}
	public String getTvshowImagePath() {
		return tvshowImagePath;
	}
	public void setTvshowImagePath(String tvshowImagePath) {
		this.tvshowImagePath = tvshowImagePath;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getMemberscount() {
		return memberscount;
	}
	public void setMemberscount(int memberscount) {
		this.memberscount = memberscount;
	}
	
}
