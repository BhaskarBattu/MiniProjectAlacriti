package com.alacriti.imdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.MovieReturnFileds;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserDao extends BaseDAO{
	public UserDao(Connection conn) {
		super(conn);
	}
	public UserDao(){
		
	}
	public void createUserRole(UserRegistration userRoleVO) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementCreateUserRole(getConnection(), sqlCmd,userRoleVO);
			//System.out.println("Coming");
			stmt.setString(1, userRoleVO.getEmail());
			rs= stmt.executeQuery();
		//	System.out.println("executed...");
			/*if(rs!=null){
				System.out.println("Exception in getPreparedStatementCreateUser bhaskar:flag");
			}
			else{
				System.out.println("Exception in getPreparedStatementCreateUser:flag");
			}*/
			if(!rs.next())
			{
				//System.out.println("Exception aman in getPreparedStatementCreate bhaskar:flag");
				stmt1 = getPreparedStatementCreateUserReg(getConnection(), sqlCmd,userRoleVO);
				stmt1.setString(1, userRoleVO.getFirstName());
				stmt1.setString(2, userRoleVO.getLastName());
				stmt1.setString(3, userRoleVO.getPassword());
				stmt1.setString(4, userRoleVO.getAddress());
				stmt1.setString(5, userRoleVO.getMobileno());
				stmt1.setString(6, userRoleVO.getEmail());
				int count= stmt1.executeUpdate();
				
				//System.out.println("count is "+count);
				if(count>0){
					userRoleVO.setRegCreated(true);
					getConnection().commit();
				}
			    //System.out.println(rs.getString(1));
			}
			/*else{
				System.out.println("close connetion");
				close(stmt, rs);
			}*/
			/*int i =getPreparedStatementCreateUserRole(getConnection(), sqlCmd,userRoleVO);
			System.out.println("value sof i bhaskar"+i);
			if(i!=0)
			{
				System.out.println("value sof i bhaskar"+1);
				stmt=getPreparedStatementCreateUserReg(getConnection(), sqlCmd,userRoleVO);
			}
			//stmt.setInt(1,userRoleVO.getEmail());
			stmt.setString(1, userRoleVO.getFirstName());
			stmt.setString(2, userRoleVO.getPassword());
			//log.logDebug("reached here********");
			int count= stmt.executeUpdate();
			if(count>0){
				//userRoleVO.setRoleCreate(true);
				System.out.println("Exception in getPreparedStatementCreateUser tharu");
			}*/
		} catch (SQLException e) {
			/*log.logError(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw new DAOException("SQLException in createUserRole():", e);*/
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	
	
	public PreparedStatement getPreparedStatementCreateUserRole(Connection connection, String sqlCmd, UserRegistration usrReg) throws SQLException{
		try {
			/*
			Statement st=connection.createStatement();
			String nae=usrReg.getFirstName();
			System.out.println("My name"+nae);
			ResultSet rs = st.executeQuery("select * from dummy_login where name='"+nae+"'");
			//System.out.println("rs printint"+rs.getString(1));
			if(rs==null){
				System.out.println("Exception in getPreparedStatementCreateUser bhaskar:flag");
				return 0;
			}else
			{
				return 1;
			}*/
			return connection.prepareStatement("select email from Al237_imdb_user_details where email=?");
			
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	public PreparedStatement getPreparedStatementCreateUserReg(Connection connection, String sqlCmd, UserRegistration usrReg) throws SQLException{

		try {			
			//System.out.println("prepared tea here");
				return connection.prepareStatement("insert into Al237_imdb_user_details(firstname,lastname,password,address,mobilenumber,email) values(?,?,?,?,?,?)");
			
			
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser " + e.getMessage());
			throw e;
			
		}
	}
	
	public void checkUserLoginDAO(UserRegistration userRoleVO) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementCheckUserLogin(getConnection(), sqlCmd,userRoleVO);
			//System.out.println("Coming");
			stmt.setString(1, userRoleVO.getEmail());
			stmt.setString(2, userRoleVO.getPassword());
			rs= stmt.executeQuery();
			System.out.println("coming");
			if(rs.next())
			{
				userRoleVO.setRegCreated(true);
				getConnection().commit();
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	public PreparedStatement getPreparedStatementCheckUserLogin(Connection connection, String sqlCmd, UserRegistration usrReg) throws SQLException{
		try {
			return connection.prepareStatement("select email,password from Al237_imdb_user_details where email=? and password=?");
			
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public ArrayList<TopRatedMovieTvshows> checkConectionLoginDAO(TopRatedMovieTvshows topRatedMovieTV) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		ArrayList<TopRatedMovieTvshows> topmoviesTvs=new ArrayList<TopRatedMovieTvshows>();
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementTopRatedMovieTvShows(getConnection(), sqlCmd, topRatedMovieTV);
			rs= stmt.executeQuery();
			System.out.println("coming tv");
			while(rs.next())
			{
				topRatedMovieTV.setMoviename(rs.getString(1));
				topRatedMovieTV.setMoviename(rs.getString(2));
				topmoviesTvs.add(topRatedMovieTV);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
		return topmoviesTvs;
	}
	public PreparedStatement getPreparedStatementTopRatedMovieTvShows(Connection connection, String sqlCmd, TopRatedMovieTvshows topRatedMovieTV) throws SQLException{
		try {
			return connection.prepareStatement("select moviename,description from Al237_imdb_movieslist");
			
		} catch (SQLException e) {
			//log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public void displayMovieDetailsDAO(MovieDetails movieDetails) {//throws DAOException{
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		ArrayList<MovieReturnFileds> movieReturn=new ArrayList<MovieReturnFileds>();
		
	//	MovieReturnFileds movieretunFileds;
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementMovieDetails(getConnection(), sqlCmd, movieDetails);
			//stmt.setString(1, movieDetails.getMoviename());
			rs= stmt.executeQuery();
			//System.out.println("movie coming");
			while(rs.next())
			{
						
					/*	//System.out.println(rs.getString(1));
						movieretunFileds.setActors(rs.getString(1));
//						System.out.println(rs.getString(1));
						movieretunFileds.setActorProfession(rs.getString(2));
						movieretunFileds.setDate(rs.getString(3));
						movieretunFileds.setDescription(rs.getString(4));
						movieretunFileds.setImagePath(rs.getString(5));
						movieretunFileds.setGenreType(rs.getString(6));*/
						
						movieReturn.add(new  MovieReturnFileds(rs.getString(1),rs.getString(6),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)));
						
						/*movieDetails.setMovieGett(movieReturn);
						movieReturn.add(movieretunFileds);
						System.out.println("moviereturn  "+movieretunFileds);
						*/
				/*
					movieDetails.getMovieFields().setActors(rs.getString(1));
					System.out.println(rs.getString(1));
					movieDetails.getMovieFields().setActorProfession(rs.getString(2));
					movieDetails.getMovieFields().setDate(rs.getString(3));
					movieDetails.getMovieFields().setDescription(rs.getString(4));
					movieDetails.getMovieFields().setDescription(rs.getString(4));
					movieDetails.getMovieFields().setGenreType(rs.getString(6));
					movieReturn.add(movieDetails);
				
						System.out.println("moviereturn  d "+movieReturn.toString());
						for(MovieReturnFileds s: movieReturn){
							System.out.println("ssss"+s.getActors());
							System.out.println("ssss"+s.getActorProfession());
							
							
						}
						System.out.println("moviereturn  d "+movieReturn);*/
			}
			movieDetails.setMovieGett(movieReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	public PreparedStatement getPreparedStatementMovieDetails(Connection connection, String sqlCmd, MovieDetails movieDetails) throws SQLException{
		try {
			String movie=movieDetails.getMoviename();
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
