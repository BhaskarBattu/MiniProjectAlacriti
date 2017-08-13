package com.alacriti.imdb.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.imdb.delegate.MovieDelegate;
import com.alacriti.imdb.model.vo.ListTopMovies;
import com.alacriti.imdb.model.vo.ListedMovieComments;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.TopMovies;

@Path("/movies")
public class MoviesList {

	@GET
	@Path("/onDashboardDispaly")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ListTopMovies> Topmovies()
	{
		TopMovies topMovies=new TopMovies();
		MovieDelegate movDelegate=new MovieDelegate();
		movDelegate.movieDetailsDelegate(topMovies);
		return topMovies.getListTopMovies();
	}

	@POST
	@Path("/movieComments")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ListedMovieComments> displayMovieComments(MovieComments movieComments){
		MovieDelegate movieDelegate=new MovieDelegate();
		movieDelegate.movieCommentsDelegate(movieComments);
		//movDelegate.movieDetailsDelegate(topMovies);
		//return movieDetails.getMovieFields();
		return movieComments.getListedMovieComments();
	}
	
}
