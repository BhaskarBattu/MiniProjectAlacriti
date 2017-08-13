package com.alacriti.imdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.imdb.model.vo.ListTopMovies;
import com.alacriti.imdb.model.vo.ListedMovieComments;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.TopMovies;

public class MovieListDao extends BaseDAO{
	public MovieListDao(Connection conn) {
		super(conn);
	}
	public MovieListDao(){
		
	}
	public void movieDetailListDao(TopMovies topMovies) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		ArrayList<ListTopMovies> movieReturn=new ArrayList<ListTopMovies>();
		
	//	MovieReturnFileds movieretunFileds;
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementMovieDetails(getConnection(), sqlCmd, topMovies);
			//stmt.setString(1, movieDetails.getMoviename());
			rs= stmt.executeQuery();
		//	System.out.println("movie coming");
			while(rs.next())
			{
				movieReturn.add(new ListTopMovies(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));		
			}
			topMovies.setListTopMovies(movieReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
		}
	}
	public PreparedStatement getPreparedStatementMovieDetails(Connection connection, String sqlCmd, TopMovies tlopMovies) throws SQLException{

		try {
			return connection.prepareStatement("select ra.movie_id,ml.moviename,ml.image,Avg(ra.rating),count(ra.userid)"
					+ " from Al237_imdb_Rating as ra, Al237_imdb_movieslist as ml "
					+ "where ra.movie_id=ml.movie_id group by movie_id order by ra.rating desc");
				
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	public void movieCommentsDao(MovieComments movieComments) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		ArrayList<ListedMovieComments> movieCommentReturn=new ArrayList<ListedMovieComments>();
		
	//	MovieReturnFileds movieretunFileds;
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementMovieComments(getConnection(), sqlCmd, movieComments);
			//stmt.setString(1, movieDetails.getMoviename());
			rs= stmt.executeQuery();
			//System.out.println("movie coming");
			while(rs.next())
			{
				System.out.println("get string"+rs.getString(1));
				movieCommentReturn.add(new ListedMovieComments(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDate(5)));		
			}
			movieComments.setListedMovieComments(movieCommentReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
		}
	}
	public PreparedStatement getPreparedStatementMovieComments(Connection connection, String sqlCmd, MovieComments movieComments) throws SQLException{
		try {
			String movie= movieComments.getMoviename();
		//	System.out.println(movie);
			return connection.prepareStatement("select ud.firstname,ud.lastname,ra.rating,ra.comments,ra.rating_date "
					+ "from Al237_imdb_Rating as ra, Al237_imdb_movieslist as ml, Al237_imdb_user_details as ud"
					+ " where ra.movie_id=ml.movie_id and ra.userid=ud.userid and ml.moviename='"+movie+"'"
					+ "order by ra.rating desc");
				
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
}
