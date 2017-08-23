package com.alacriti.imdb.bo;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.imdb.dao.DAOException;
import com.alacriti.imdb.dao.TvShowsDao;
import com.alacriti.imdb.model.vo.tvshows.TopTvshows;
import com.alacriti.imdb.model.vo.tvshows.TvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TvShowDetails;

public class TvShowsBo extends BaseBo {
	 private static final Logger log = Logger.getLogger(TvShowsBo.class);
	public TvShowsBo(Connection connection){
		super(connection);
	}

	public void tvShowDetaillsBO(TopTvshows topTvShows) throws DAOException, BOException{
		log.debug("In TVShowBo ***********tvShowDetaillsBO");
		try {
			TvShowsDao tvShowsDAO = new TvShowsDao(getConnection());
			tvShowsDAO.tvShowsDetailListDao(topTvShows);
			
		} catch (Exception e) {
			log.error("Exception in retrieveMessage *********tvShowDetaillsBO");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in TvShow details list");

		}
	}
	public void tvShowClickedDetaillsBO(TvShowDetails tvShowDetails) throws DAOException, BOException{
		log.debug("In TVShowBo ***********tvShowClickedDetaillsBO");
		try {
			TvShowsDao tvShowDAO = new TvShowsDao(getConnection());
			tvShowDAO.tvShowClickedDetailListDao(tvShowDetails);
			
		} catch (Exception e) {
			log.error("Exception in retrieveMessage *********tvShowClickedDetaillsBO");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in Tv Show usr clicked item details list");

		}
	}
	
	public void tvShowCommentsBO(TvShowComments tvShowComments) throws DAOException, BOException{
		log.debug("In TVShowBo ***********tvShowCommentsBO");
		try {
			TvShowsDao tvShowDAO = new TvShowsDao(getConnection());
			tvShowDAO.tvShowCommentsDao(tvShowComments);
			
		} catch (Exception e) {
			log.error("Exception in retrieveMessage *********tvShowCommentsBO");
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in tv show comments details list");

		}
	}
}
