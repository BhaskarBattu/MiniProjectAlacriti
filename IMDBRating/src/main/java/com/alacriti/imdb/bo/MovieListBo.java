package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.DAOException;
import com.alacriti.imdb.dao.MovieListDao;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.TopMovies;


public class MovieListBo extends BaseBo{
	public MovieListBo(Connection connection){
		super(connection);
	}
	public void movieListDetaillsBO(TopMovies topMovies)  throws DAOException, BOException{
		try {
			MovieListDao movieListDAO = new MovieListDao(getConnection());
			movieListDAO.movieDetailListDao(topMovies);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in movie details list");
		}
	}
	public void movieCommentsBO(MovieComments movieComments) throws DAOException, BOException{
		try {
			MovieListDao movieListDAO = new MovieListDao(getConnection());
			movieListDAO.movieCommentsDao(movieComments);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in movie comments");

		}
	}
}
