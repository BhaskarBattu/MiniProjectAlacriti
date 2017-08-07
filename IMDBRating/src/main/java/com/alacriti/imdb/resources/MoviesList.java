package com.alacriti.imdb.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.imdb.delegate.MovieDelegate;
import com.alacriti.imdb.delegate.UserDelegate;
import com.alacriti.imdb.model.vo.ListTopMovies;
import com.alacriti.imdb.model.vo.TopMovies;

@Path("/movies")
public class MoviesList {

	@GET
	@Path("/onDashboardDispaly")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ListTopMovies> Topmovies(TopMovies topMovies)
	{
		MovieDelegate movDelegate=new MovieDelegate();
		movDelegate.movieDetailsDelegate(topMovies);
		
		return topMovies.getListTopMovies();
	}
	
}
