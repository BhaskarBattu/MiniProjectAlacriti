package com.alacriti.imdb.delegate;

import java.sql.Connection;

import com.alacriti.imdb.bo.UserRegisterBo;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserDelegate extends BaseDelegate{
	
	public void createUserAccount(UserRegistration usrReg){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			//System.out.println("Database connected bhaskar");
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.createUserRegister(usrReg);
		} catch (Exception e) {
			//log.logError("Exception in getMessage " + e.getMessage(), e);
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
			//System.out.println("Database connected bhaskar");
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.checkUserLoginBO(usrReg);
		} catch (Exception e) {
			//log.logError("Exception in getMessage " + e.getMessage(), e);
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
			//System.out.println("Database connected bhaskar");
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.checkConnectioninBO(topRatedMovieTV);
		} catch (Exception e) {
			//log.logError("Exception in getMessage " + e.getMessage(), e);
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
			//System.out.println("Database connected movie bhaskar");
			UserRegisterBo userRegistBo= new UserRegisterBo(getConnection());
			userRegistBo.displayMovieDetaillsBO(movieDetails);
		} catch (Exception e) {
			//log.logError("Exception in getMessage " + e.getMessage(), e);
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
}
