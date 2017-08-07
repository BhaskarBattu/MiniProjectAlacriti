package com.alacriti.imdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.imdb.model.vo.ListTopMovies;
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
			//System.out.println("movie coming");
			while(rs.next())
			{
				movieReturn.add(new  ListTopMovies(rs.getString(1),rs.getString(6),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)));		
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
			return connection.prepareStatement("select ca.castingname,cp.profession,ml.releasedate,ml.description,ml.image, ge.descrption "
					+ "from Al237_imdb_movie_casting_mapprint_table as cmt, Al237_imdb_movieslist as ml,Al237_imdb_genre as ge ,"
					+ " Al237_imdb_casting as ca,Al237_imdb_genere_movie_table as gmt, Al237_imdb_casting_profession as cp "
					+ " where ml.moviename like '%"+movie+"%' and cmt.casting_id=ca.casting_id and ml.movie_id=cmt.movie_id and"
							+ " ca.profession_id=cp.profession_id and ml.movie_id=gmt.movie_id and gmt.genre_id=ge.genre_id");
				
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
}
