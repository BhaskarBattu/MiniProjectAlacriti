package com.alacriti.imdb.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.imdb.bo.TvShowsBo;
import com.alacriti.imdb.model.vo.tvshows.TopTvshows;
import com.alacriti.imdb.model.vo.tvshows.TvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TvShowDetails;

public class TvShowsDelegate extends BaseDelegate{
	
	 private static final Logger log = Logger.getLogger(TvShowsDelegate.class);
	 
	public void tvShowsDetailsDelegate(TopTvshows topTvShows){
		log.debug("In Tvshow delegate ************** tvShowsDetailsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TvShowsBo tvShowtBo= new TvShowsBo(getConnection());
			tvShowtBo.tvShowDetaillsBO(topTvShows);
		} catch (Exception e) {
			log.error("Exception in getconnection******* tvShowsDetailsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void displaTvShowDetailsDelegate(TvShowDetails tvShowDetails){
		log.debug("In Tvshow delegate ************** displaTvShowDetailsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TvShowsBo tvShowtBo= new TvShowsBo(getConnection());
			tvShowtBo.tvShowClickedDetaillsBO(tvShowDetails);
		} catch (Exception e) {
			log.error("Exception in getconnection******* displaTvShowDetailsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	
	public void tShowCommentsDelegate(TvShowComments tvShowComments){
		log.debug("In Tvshow delegate ************** tShowCommentsDelegate");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TvShowsBo tvShowtBo= new TvShowsBo(getConnection());
			tvShowtBo.tvShowCommentsBO(tvShowComments);
		} catch (Exception e) {
			log.error("Exception in getconnection******* tShowCommentsDelegate");
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
}
