package com.alacriti.imdb.bo;

import java.sql.Connection;

import com.alacriti.imdb.dao.DAOException;
import com.alacriti.imdb.dao.TvShowsDao;
import com.alacriti.imdb.model.vo.tvshows.TopTvshows;
import com.alacriti.imdb.model.vo.tvshows.TvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TvShowDetails;

public class TvShowsBo extends BaseBo {
	public TvShowsBo(Connection connection){
		super(connection);
	}

	public void tvShowDetaillsBO(TopTvshows topTvShows) throws DAOException, BOException{
		try {
			TvShowsDao tvShowsDAO = new TvShowsDao(getConnection());
			tvShowsDAO.tvShowsDetailListDao(topTvShows);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in TvShow details list");

		}
	}
	public void tvShowClickedDetaillsBO(TvShowDetails tvShowDetails) throws DAOException, BOException{
		try {
			TvShowsDao tvShowDAO = new TvShowsDao(getConnection());
			tvShowDAO.tvShowClickedDetailListDao(tvShowDetails);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in Tv Show usr clicked item details list");

		}
	}
	
	public void tvShowCommentsBO(TvShowComments tvShowComments) throws DAOException, BOException{
		try {
			TvShowsDao tvShowDAO = new TvShowsDao(getConnection());
			tvShowDAO.tvShowCommentsDao(tvShowComments);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException("Exception in tv show comments details list");

		}
	}
}
