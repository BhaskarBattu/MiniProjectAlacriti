package com.alacriti.imdb.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.imdb.bo.UserRegisterBo;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.Search;
import com.alacriti.imdb.model.vo.UserCommnets;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserDelegate extends BaseDelegate{
	 private static final Logger log = Logger.getLogger(UserDelegate.class);
	public void createUserAccount(UserRegistration usrReg){
		log.debug("In User delegate*******create UserRole");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.createUserRegister(usrReg);
		} catch (Exception e) {
			log.error("Exception in getConnection user delegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void checkUserLogin(UserRegistration usrReg){
		log.debug("In user delegate********* checking user delegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.checkUserLoginBO(usrReg);
		} catch (Exception e) {
			log.info("In user delegate exception at ******** checking user login ");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	
	public void displaMovieDetailsDelegate(MovieDetails movieDetails){
		log.debug("In user delegate ****************** Diaplay movie details delegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.displayMovieDetaillsBO(movieDetails);
		} catch (Exception e) {
			log.error("exception at *************** dipaly movie details connection");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void displaSearchDetailsDelegate(String searchTerm, Search searcTerm){
		log.debug("In user delegate ****************** displaSearchDetailsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.displaySerchDetaillsBO(searchTerm, searcTerm);
		} catch (Exception e) {
			log.error("exception at *************** displaSearchDetailsDelegate connection");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void getSearchDetailsDelegate(MovieDetails movieDetails){
		log.debug("In user delegate ****************** getSearchDetailsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.getSearchDetaillsBO(movieDetails);
		} catch (Exception e) {
			log.error("Exception in getconmnetion ********** getSearchDetailsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void getSearchItemCommentsDelegate(MovieComments movieComments){
		log.debug("In user delegate ****************** getSearchItemCommentsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.getSearchItemCommentsBO(movieComments);
		} catch (Exception e) {
			log.error("Exception in get connection getSearchItemCommentsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void insertUserCommentsDelegate(UserCommnets userCommnets){
		log.debug("In user delegate ****************** insertUserCommentsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.insertUserCommentsBO(userCommnets);
		} catch (Exception e) {
			log.error("Exception in get connection insertUserCommentsDelegate ");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
}
