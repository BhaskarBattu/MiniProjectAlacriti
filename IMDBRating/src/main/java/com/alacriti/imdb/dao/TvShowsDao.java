package com.alacriti.imdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.imdb.model.vo.tvshows.ListTopTvshows;
import com.alacriti.imdb.model.vo.tvshows.ListedTvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TopTvshows;
import com.alacriti.imdb.model.vo.tvshows.TvShowComments;
import com.alacriti.imdb.model.vo.tvshows.TvShowDetails;
import com.alacriti.imdb.model.vo.tvshows.TvShowReturnFileds;

public class TvShowsDao extends BaseDAO{
	public TvShowsDao(Connection conn) {
		super(conn);
	}
	public TvShowsDao(){
		
	}
	public void tvShowsDetailListDao(TopTvshows topTvshows) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		ArrayList<ListTopTvshows> tvShowReturn=new ArrayList<ListTopTvshows>();
		
	//	MovieReturnFileds movieretunFileds;
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementMovieDetails(getConnection(), sqlCmd, topTvshows);
			//stmt.setString(1, movieDetails.getMoviename());
			rs= stmt.executeQuery();
		//	System.out.println("movie coming");
			while(rs.next())
			{
				tvShowReturn.add(new ListTopTvshows(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));		
			}
			topTvshows.setListTvShows(tvShowReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
		}
	}
	public PreparedStatement getPreparedStatementMovieDetails(Connection connection, String sqlCmd, TopTvshows topTvshows) throws SQLException{

		try {
			return connection.prepareStatement("select tr.tvshow_rating_id,tl.tvshowname,tl.image,Avg(tr.rating),count(tr.userid)"
					+ " from Al237_imdb_tvshow_Rating as tr, Al237_imdb_tvshowslist as tl "
					+ "where tr.tvshows_id=tl.tvshows_id group by tr.tvshows_id order by tr.rating desc");
				
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}

	//Diaplay clicked Tvshow Deatils
	
	
	
	public void tvShowClickedDetailListDao(TvShowDetails tvShowDetails) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		ArrayList<TvShowReturnFileds> tvShowReturn=new ArrayList<TvShowReturnFileds>();
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementMovieDetails(getConnection(), sqlCmd, tvShowDetails);
			rs= stmt.executeQuery();
			while(rs.next())
			{
				
				tvShowReturn.add(new  TvShowReturnFileds(rs.getString(1),rs.getString(6),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)));
						
			}
			tvShowDetails.setTvshowDetailListGett(tvShowReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	public PreparedStatement getPreparedStatementMovieDetails(Connection connection, String sqlCmd, TvShowDetails tvShowDetails) throws SQLException{
		try {
			String movie=tvShowDetails.getTvshowname();
			return connection.prepareStatement("select ca.castingname,cp.profession,tl.releasedate,tl.description,tl.image, ge.genre"
					+ " from Al237_imdb_tvshows_casting_mapprint_table as tcmt, Al237_imdb_tvshowslist as tl, Al237_imdb_tvshow_genre as ge ,"
					+ " Al237_imdb_tvshows_casting as ca,Al237_imdb_genere_tvshow_table as gtt, Al237_imdb_tvshows_casting_profession as cp "
					+ "where tl.tvshowname like '%"+movie+"%' and tcmt.casting_id=ca.casting_id and tl.tvshows_id=tcmt.tvshows_id and	"
					+ "ca.profession_id=cp.profession_id and tl.tvshows_id=gtt.tvshows_id and gtt.tvgenre_id=ge.tvgenre_id");
				
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public void tvShowCommentsDao(TvShowComments tvShowComments) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		ArrayList<ListedTvShowComments> tvShowCommentReturn=new ArrayList<ListedTvShowComments>();
		
	//	MovieReturnFileds movieretunFileds;
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementTvShowComments(getConnection(), sqlCmd, tvShowComments);
			//stmt.setString(1, movieDetails.getMoviename());
			rs= stmt.executeQuery();
			//System.out.println("movie coming");
			while(rs.next())
			{
				System.out.println("get string"+rs.getString(1));
				tvShowCommentReturn.add(new ListedTvShowComments(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDate(5)));		
			}
			tvShowComments.setListedTvShowComments(tvShowCommentReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
		}
	}
	public PreparedStatement getPreparedStatementTvShowComments(Connection connection, String sqlCmd, TvShowComments tvShowComments) throws SQLException{
		try {
			String tvShowname= tvShowComments.getTvshowname();
		//	System.out.println(movie);
			return connection.prepareStatement("select ud.firstname,ud.lastname,ra.rating,ra.comments,ra.rating_date "
					+ "from Al237_imdb_tvshow_Rating as ra, Al237_imdb_tvshowslist as tl, Al237_imdb_user_details as ud "
					+ "where ra.tvshows_id=tl.tvshows_id and ra.userid=ud.userid and tl.tvshowname='"+tvShowname+"' order by ra.rating desc");
				
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}

	
}
