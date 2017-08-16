package com.alacriti.imdb.delegate;

import java.sql.Connection;

import com.alacriti.imdb.bo.UserRegisterBo;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.Search;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserCommnets;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserDelegate extends BaseDelegate{
	
	public void createUserAccount(UserRegistration usrReg){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.createUserRegister(usrReg);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void checkUserLogin(UserRegistration usrReg){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.checkUserLoginBO(usrReg);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void checkLoginConnection(TopRatedMovieTvshows topRatedMovieTV){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.checkConnectioninBO(topRatedMovieTV);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void displaMovieDetailsDelegate(MovieDetails movieDetails){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.displayMovieDetaillsBO(movieDetails);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void displaSearchDetailsDelegate(String searchTerm, Search searcTerm){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.displaySerchDetaillsBO(searchTerm, searcTerm);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void getSearchDetailsDelegate(MovieDetails movieDetails){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.getSearchDetaillsBO(movieDetails);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void getSearchItemCommentsDelegate(MovieComments movieComments){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.getSearchItemCommentsBO(movieComments);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public void insertUserCommentsDelegate(UserCommnets userCommnets){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.insertUserCommentsBO(userCommnets);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
}
