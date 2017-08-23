package com.alacriti.imdb.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.imdb.bo.MovieListBo;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.TopMovies;

public class MovieDelegate extends BaseDelegate{
	private static final Logger log = Logger.getLogger(MovieDelegate.class);

	public void movieDetailsDelegate(TopMovies topMovies){
		log.debug("In Movie Details delegate *********** movieDetailsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			MovieListBo movieListBo= new MovieListBo(getConnection());
			movieListBo.movieListDetaillsBO(topMovies);
		} catch (Exception e) {
			log.error("Exception in getConnection *************** movieDetailsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void movieCommentsDelegate(MovieComments movieComments){
		log.debug("In Movie Details delegate *********** movieCommentsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			MovieListBo movieListBo= new MovieListBo(getConnection());
			movieListBo.movieCommentsBO(movieComments);
		} catch (Exception e) {
			log.error("Exception in getConnection *************** movieCommentsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	
	
	
}
