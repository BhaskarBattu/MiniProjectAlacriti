package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.DAOException;
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
	
	public void createUserRegister(UserRegistration userReg) throws DAOException, BOException{
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.createUserRole(userReg);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	
	public void checkUserLoginBO(UserRegistration userReg){// throws DAOException, BOException{
		
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.checkUserLoginDAO(userReg);
			
		} catch (Exception e) {
	
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}

	public void checkConnectioninBO(TopRatedMovieTvshows topRatedMovieTV){// throws DAOException, BOException{
		
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.checkConectionLoginDAO(topRatedMovieTV);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void displayMovieDetaillsBO(MovieDetails movieDetails){// throws DAOException, BOException{
		
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.displayMovieDetailsDAO(movieDetails);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void displaySerchDetaillsBO(String searchTerm, Search searcTerm){// throws DAOException, BOException{
		
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.displaySearchDetailsDAO(searchTerm,searcTerm);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void getSearchDetaillsBO(MovieDetails movieDetails){// throws DAOException, BOException{
		
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.getSearchDetailsDAO(movieDetails);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void getSearchItemCommentsBO(MovieComments movieComments){// throws DAOException, BOException{
		try {
			UserDao userDAO = new UserDao(getConnection());
			userDAO.getSearchItemCommentsDao(movieComments);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void insertUserCommentsBO(UserCommnets userCommnets){// throws DAOException, BOException{
		try {
			UserDao userDAO = new UserDao(getConnection());
			userDAO.insertUserCommentsDao(userCommnets);
			
		} catch (Exception e) {
			
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
}
