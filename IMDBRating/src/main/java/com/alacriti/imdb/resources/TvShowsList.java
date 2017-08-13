package com.alacriti.imdb.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.imdb.delegate.TvShowsDelegate;
import com.alacriti.imdb.model.vo.tvshows.ListTopTvshows;
import com.alacriti.imdb.model.vo.tvshows.ListedTvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TopTvshows;
import com.alacriti.imdb.model.vo.tvshows.TvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TvShowDetails;
import com.alacriti.imdb.model.vo.tvshows.TvShowReturnFileds;

@Path("/tvshows")
public class TvShowsList {
	@GET
	@Path("/onDashboardDispaly")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ListTopTvshows> Topmovies()
	{
		TopTvshows topTvShows=new TopTvshows();
		TvShowsDelegate movDelegate=new TvShowsDelegate();
		movDelegate.tvShowsDetailsDelegate(topTvShows);
		return topTvShows.getListTvShows();
	}
	
	@POST
	@Path("/tvshowDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<TvShowReturnFileds> displayMovieDetails(TvShowDetails tvShowDetails){
		TvShowsDelegate tvshowDelegate=new TvShowsDelegate();
		tvshowDelegate.displaTvShowDetailsDelegate(tvShowDetails);
		//return movieDetails.getMovieFields();
		return tvShowDetails.getTvshowDetailListGett();
	}
	
	@POST
	@Path("/tvShowComments")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ListedTvShowComments> displayMovieComments(TvShowComments tvShowComments){
		TvShowsDelegate tvShowDelegate=new TvShowsDelegate();
		tvShowDelegate.tShowCommentsDelegate(tvShowComments);
		return tvShowComments.getListedTvShowComments();
	}
}
