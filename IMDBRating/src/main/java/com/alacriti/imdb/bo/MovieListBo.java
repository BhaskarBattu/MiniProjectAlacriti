package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.DAOException;
import com.alacriti.imdb.dao.MovieListDao;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.TopMovies;
import org.apache.log4j.Logger;




public class MovieListBo extends BaseBo{
	private static final Logger log = Logger.getLogger(MovieListBo.class);
	// private static Logger log = Logger.getLogger(MovieListBo.class);
	public MovieListBo(Connection connection){
		super(connection);
	}
	public void movieListDetaillsBO(TopMovies topMovies)  throws DAOException, BOException{
		log.debug("In Movielist BO ******** movieListDetaillsBO");
		try {
		
			MovieListDao movieListDAO = new MovieListDao(getConnection());
			movieListDAO.movieDetailListDao(topMovies);
			
		} catch (Exception e) {
			log.error("Exception in retrive message*********movieListDetaillsBO");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in movie details list");
		}
	}
	public void movieCommentsBO(MovieComments movieComments) throws DAOException, BOException{
		log.debug("In movieList BO************movieCommentsBO");
		try {
			MovieListDao movieListDAO = new MovieListDao(getConnection());
			movieListDAO.movieCommentsDao(movieComments);
			
		} catch (Exception e) {
			log.error("Exception in retrive message*********movieCommentsBO");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in movie comments");

		}
	}
}
