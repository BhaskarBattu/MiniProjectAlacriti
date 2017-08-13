package com.alacriti.imdb.resources;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.SessionUtility;
import com.alacriti.imdb.delegate.UserDelegate;
import com.alacriti.imdb.model.vo.ListedMovieComments;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.MovieReturnFileds;
import com.alacriti.imdb.model.vo.Search;
import com.alacriti.imdb.model.vo.SearchAllThings;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserCommnets;
import com.alacriti.imdb.model.vo.UserRegistration;


@Path("/user")
public class UserResources {
	
	@GET
	@Path("/invalidateSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean inValidateSessoin(@Context HttpServletRequest request)
	{
		SessionUtility sessionUtility=new SessionUtility();
		HttpSession session = request.getSession(false);
			if(session!=null)
					session.invalidate();
		System.out.println("session in checkSession :"+session);
		return sessionUtility.checkForSession(session);
	}
	
	@GET
	@Path("/checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSessoin(@Context HttpServletRequest request)
	{
		SessionUtility sessionUtility=new SessionUtility();
		HttpSession session= request.getSession(false);
		System.out.println("session in checkSession :"+session);
		return sessionUtility.checkForSession(session);
	}
	
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
	public boolean userLoginChecking(UserRegistration usrLoginCheck, @Context HttpServletRequest request){
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.checkUserLogin(usrLoginCheck);
		if(usrLoginCheck.isRegCreated())
		{
			HttpSession session= request.getSession();
			System.out.println("=====>>>>"+ session.getId());
		}
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
	
	@GET
	@Path("/searchTerm")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SearchAllThings> displaySearchDetails(@QueryParam("name") String searchTerm){
		Search searcTerm=new Search();
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.displaSearchDetailsDelegate(searchTerm,searcTerm);
		//return movieDetails.getMovieFields();
		return searcTerm.getSearchAllItems();
	}
	@POST
	@Path("/searchDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<MovieReturnFileds> getSearchDetails(MovieDetails movieDetails){
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.getSearchDetailsDelegate(movieDetails);
		//return movieDetails.getMovieFields();
		return movieDetails.getMovieGett();
	}
	
	@POST
	@Path("/searchItemComments")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ListedMovieComments> getSearchItemComments(MovieComments movieComments){
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.getSearchItemCommentsDelegate(movieComments);
		//movDelegate.movieDetailsDelegate(topMovies);
		//return movieDetails.getMovieFields();
		return movieComments.getListedMovieComments();
	}
	
	@POST
	@Path("/insertUserComments")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean insertUserComments(UserCommnets userCommnets){
		UserDelegate usrDelegate=new UserDelegate();
		usrDelegate.insertUserCommentsDelegate(userCommnets);
		//movDelegate.movieDetailsDelegate(topMovies);
		//return movieDetails.getMovieFields();
		return userCommnets.isValidComment();
	}
	
	
}
