package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.MovieListDao;
import com.alacriti.imdb.model.vo.TopMovies;


public class MovieListBo extends BaseBo{
	public MovieListBo(Connection connection){
		super(connection);
	}
	public void movieListDetaillsBO(TopMovies topMovies){// throws DAOException, BOException{
		try {
			MovieListDao movieListDAO = new MovieListDao(getConnection());
			movieListDAO.movieDetailListDao(topMovies);
			
		} catch (Exception e) {
			//log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			//throw  BOException();
		}
	}
}
