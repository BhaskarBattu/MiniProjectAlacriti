package com.alacriti.imdb.bo;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.imdb.dao.DAOException;
import com.alacriti.imdb.dao.UserDao;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.Search;
import com.alacriti.imdb.model.vo.UserCommnets;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserRegisterBo extends BaseBo{
	 private static final Logger log = Logger.getLogger(UserRegisterBo.class);
	
	public UserRegisterBo(Connection connection){
		super(connection);
	}
	
	public void createUserRegister(UserRegistration userReg) throws DAOException, BOException{
		log.debug("In Create User Register********* createUserRegister");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.createUserRole(userReg);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* createUserRegister");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	
	public void checkUserLoginBO(UserRegistration userReg){// throws DAOException, BOException{
		
		log.debug("In  User Register BO ********* checkUserLoginBO");
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.checkUserLoginDAO(userReg);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* checkUserLoginBO BO ");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}

	public void displayMovieDetaillsBO(MovieDetails movieDetails){// throws DAOException, BOException{
		log.debug("In  User Register BO ********* displayMovieDetaillsBO");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.displayMovieDetailsDAO(movieDetails);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* displayMovieDetaills BO ");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void displaySerchDetaillsBO(String searchTerm, Search searcTerm){// throws DAOException, BOException{
		log.debug("In  User Register BO ********* displaySerchDetaillsBO");
		
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.displaySearchDetailsDAO(searchTerm,searcTerm);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* displaySerchDetaills BO ");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void getSearchDetaillsBO(MovieDetails movieDetails){// throws DAOException, BOException{
		
		log.debug("In  User Register BO ********* getSearchDetaillsBO");
		try {
			UserDao userDAO = new UserDao(getConnection());
			
			userDAO.getSearchDetailsDAO(movieDetails);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* getSearchDetaills BO ");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void getSearchItemCommentsBO(MovieComments movieComments){// throws DAOException, BOException{
		log.debug("In  User Register BO ********* getSearchItemCommentsBO");
		try {
			UserDao userDAO = new UserDao(getConnection());
			userDAO.getSearchItemCommentsDao(movieComments);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* getSearchItemComments BO ");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
	public void insertUserCommentsBO(UserCommnets userCommnets){// throws DAOException, BOException{
		log.debug("In  User Register BO ********* insertUserCommentsBO");
		try {
			UserDao userDAO = new UserDao(getConnection());
			userDAO.insertUserCommentsDao(userCommnets);
			
		} catch (Exception e) {
			log.error("Exception in retrie message ********* insertUserComments BO ");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
}
