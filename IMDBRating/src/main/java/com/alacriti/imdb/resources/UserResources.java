package com.alacriti.imdb.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.imdb.delegate.UserDelegate;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.MovieReturnFileds;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserRegistration;


@Path("/user")
public class UserResources {
	@POST
	@Path("/addUserRegistration")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean adduserRegistration(UserRegistration usrReg){
		//System.out.println("userRegistrationVO.RoleName********"+usrReg.getEmail());
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.createUserAccount(usrReg);
		return usrReg.isRegCreated();
	}
	
	@POST
	@Path("/checkUserLogin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean userLoginChecking(UserRegistration usrLoginCheck){
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.checkUserLogin(usrLoginCheck);
		return usrLoginCheck.isRegCreated();
	}
	
	@GET
	@Path("/onDashboardDispaly")
	@Produces(MediaType.APPLICATION_JSON)
	 public TopRatedMovieTvshows displayTopRatedMovieTvShows(TopRatedMovieTvshows topRatedMovieTV)
	{
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.checkLoginConnection(topRatedMovieTV);
		return topRatedMovieTV;
	}
	
	@POST
	@Path("/movieDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<MovieReturnFileds> displayMovieDetails(MovieDetails movieDetails){
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.displaMovieDetailsDelegate(movieDetails);
		//return movieDetails.getMovieFields();
		return movieDetails.getMovieGett();
	}
	
	
	
	
}
