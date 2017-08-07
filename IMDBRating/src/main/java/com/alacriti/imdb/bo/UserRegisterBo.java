package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.UserDao;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
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
}
