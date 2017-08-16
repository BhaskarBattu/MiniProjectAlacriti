package com.alacriti.imdb.delegate;

import java.sql.Connection;

import com.alacriti.imdb.bo.TvShowsBo;
import com.alacriti.imdb.model.vo.tvshows.TopTvshows;
import com.alacriti.imdb.model.vo.tvshows.TvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TvShowDetails;

public class TvShowsDelegate extends BaseDelegate{
	
	public void tvShowsDetailsDelegate(TopTvshows topTvShows){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TvShowsBo tvShowtBo= new TvShowsBo(getConnection());
			tvShowtBo.tvShowDetaillsBO(topTvShows);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	public void displaTvShowDetailsDelegate(TvShowDetails tvShowDetails){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TvShowsBo tvShowtBo= new TvShowsBo(getConnection());
			tvShowtBo.tvShowClickedDetaillsBO(tvShowDetails);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	
	
	public void tShowCommentsDelegate(TvShowComments tvShowComments){
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			TvShowsBo tvShowtBo= new TvShowsBo(getConnection());
			tvShowtBo.tvShowCommentsBO(tvShowComments);
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
}
