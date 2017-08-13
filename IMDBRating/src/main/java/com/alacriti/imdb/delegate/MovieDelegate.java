package com.alacriti.imdb.delegate;

import java.sql.Connection;

import com.alacriti.imdb.bo.MovieListBo;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.TopMovies;

public class MovieDelegate extends BaseDelegate{

	public void movieDetailsDelegate(TopMovies topMovies){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			//System.out.println("Database connected movie bhaskar");
			MovieListBo movieListBo= new MovieListBo(getConnection());
			movieListBo.movieListDetaillsBO(topMovies);
		} catch (Exception e) {
			//log.logError("Exception in getMessage " + e.getMessage(), e);
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void movieCommentsDelegate(MovieComments movieComments){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			//System.out.println("Database connected movie bhaskar");
			MovieListBo movieListBo= new MovieListBo(getConnection());
			movieListBo.movieCommentsBO(movieComments);
		} catch (Exception e) {
			//log.logError("Exception in getMessage " + e.getMessage(), e);
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	
	
	
}
