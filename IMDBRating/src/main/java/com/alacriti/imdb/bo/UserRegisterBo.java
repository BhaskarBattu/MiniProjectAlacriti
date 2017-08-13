package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.UserDao;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.Search;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserCommnets;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserRegisterBo extends BaseBo{
	
	public UserRegisterBo(Connection connection){
		super(connection);
	}
	
	public void createUserRegister(UserRegistration userReg){// throws DAOException, BOException{
		//log.debugPrintCurrentMethodName();
		//System.out.println("createUserRegister method");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			//System.out.println("Database working nbhaskar");
			userDAO.createUserRole(userReg);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	
	public void checkUserLoginBO(UserRegistration userReg){// throws DAOException, BOException{
		//log.debugPrintCurrentMethodName();
		//System.out.println("createUserRegister method");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			//System.out.println("Database working nbhaskar");
			userDAO.checkUserLoginDAO(userReg);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}

	public void checkConnectioninBO(TopRatedMovieTvshows topRatedMovieTV){// throws DAOException, BOException{
		//log.debugPrintCurrentMethodName();
		//System.out.println("createUserRegister method");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			//System.out.println("Database working nbhaskar");
			userDAO.checkConectionLoginDAO(topRatedMovieTV);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void displayMovieDetaillsBO(MovieDetails movieDetails){// throws DAOException, BOException{
		//log.debugPrintCurrentMethodName();
		//System.out.println("createUserRegister method");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			//System.out.println("Database working nbhaskar");
			userDAO.displayMovieDetailsDAO(movieDetails);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void displaySerchDetaillsBO(String searchTerm, Search searcTerm){// throws DAOException, BOException{
		//log.debugPrintCurrentMethodName();
		//System.out.println("createUserRegister method");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			//System.out.println("Database working nbhaskar");
			userDAO.displaySearchDetailsDAO(searchTerm,searcTerm);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void getSearchDetaillsBO(MovieDetails movieDetails){// throws DAOException, BOException{
		//log.debugPrintCurrentMethodName();
		//System.out.println("createUserRegister method");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			//System.out.println("Database working nbhaskar");
			userDAO.getSearchDetailsDAO(movieDetails);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void getSearchItemCommentsBO(MovieComments movieComments){// throws DAOException, BOException{
		try {
			UserDao userDAO = new UserDao(getConnection());
			userDAO.getSearchItemCommentsDao(movieComments);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void insertUserCommentsBO(UserCommnets userCommnets){// throws DAOException, BOException{
		try {
			UserDao userDAO = new UserDao(getConnection());
			userDAO.insertUserCommentsDao(userCommnets);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
}
