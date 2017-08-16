package com.alacriti.imdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.imdb.model.vo.ListedMovieComments;
import com.alacriti.imdb.model.vo.MovieComments;
import com.alacriti.imdb.model.vo.MovieDetails;
import com.alacriti.imdb.model.vo.MovieReturnFileds;
import com.alacriti.imdb.model.vo.Search;
import com.alacriti.imdb.model.vo.SearchAllThings;
import com.alacriti.imdb.model.vo.TopRatedMovieTvshows;
import com.alacriti.imdb.model.vo.UserCommnets;
import com.alacriti.imdb.model.vo.UserRegistration;

public class UserDao extends BaseDAO{
	public UserDao(Connection conn) {
		super(conn);
	}
	public UserDao(){
		
	}
	public void createUserRole(UserRegistration userRoleVO) throws DAOException{
		
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementCreateUserRole(getConnection(), sqlCmd,userRoleVO);
			
			stmt.setString(1, userRoleVO.getEmail());
			rs= stmt.executeQuery();
			
			if(!rs.next())
			{
				
				stmt1 = getPreparedStatementCreateUserReg(getConnection(), sqlCmd,userRoleVO);
				stmt1.setString(1, userRoleVO.getFirstName());
				stmt1.setString(2, userRoleVO.getLastName());
				stmt1.setString(3, userRoleVO.getPassword());
				stmt1.setString(4, userRoleVO.getAddress());
				stmt1.setString(5, userRoleVO.getMobileno());
				stmt1.setString(6, userRoleVO.getEmail());
				int count= stmt1.executeUpdate();
				
				if(count>0){
					userRoleVO.setRegCreated(true);
					getConnection().commit();
				}
			   
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in create user registration");
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	
	
	public PreparedStatement getPreparedStatementCreateUserRole(Connection connection, String sqlCmd, UserRegistration usrReg) throws SQLException{
		try {
			
			return connection.prepareStatement("select email from Al237_imdb_user_details where email=?");
			
		} catch (SQLException e) {
			System.out.println("Exception in getPrepared    Statement Create User  " + e.getMessage());
			throw e;
			
		}
	}
	public PreparedStatement getPreparedStatementCreateUserReg(Connection connection, String sqlCmd, UserRegistration usrReg) throws SQLException{

		try {			
			
				return connection.prepareStatement("insert into Al237_imdb_user_details(firstname,lastname,password,address,mobilenumber,email) values(?,?,?,?,?,?)");
			
			
		} catch (SQLException e) {
			
			System.out.println("Exception in getPreparedStatementCreateUser " + e.getMessage());
			throw e;
			
		}
	}
	
	public void checkUserLoginDAO(UserRegistration userRoleVO) throws DAOException{
		
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementCheckUserLogin(getConnection(), sqlCmd,userRoleVO);
			
			stmt.setString(1, userRoleVO.getEmail());
			stmt.setString(2, userRoleVO.getPassword());
			rs= stmt.executeQuery();
			
			if(rs.next())
			{
				userRoleVO.setRegCreated(true);
				getConnection().commit();
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in checking user login");
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	public PreparedStatement getPreparedStatementCheckUserLogin(Connection connection, String sqlCmd, UserRegistration usrReg) throws SQLException{
		try {
			return connection.prepareStatement("select email,password from Al237_imdb_user_details where email=? and password=?");
			
		} catch (SQLException e) {
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public ArrayList<TopRatedMovieTvshows> checkConectionLoginDAO(TopRatedMovieTvshows topRatedMovieTV) throws DAOException{
		
		ArrayList<TopRatedMovieTvshows> topmoviesTvs=new ArrayList<TopRatedMovieTvshows>();
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementTopRatedMovieTvShows(getConnection(), sqlCmd, topRatedMovieTV);
			rs= stmt.executeQuery();
			
			while(rs.next())
			{
				topRatedMovieTV.setMoviename(rs.getString(1));
				topRatedMovieTV.setMoviename(rs.getString(2));
				topmoviesTvs.add(topRatedMovieTV);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException");
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
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public void displayMovieDetailsDAO(MovieDetails movieDetails) throws DAOException{
		
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		ArrayList<MovieReturnFileds> movieReturn=new ArrayList<MovieReturnFileds>();
		
	
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementMovieDetails(getConnection(), sqlCmd, movieDetails);
			
			rs= stmt.executeQuery();
			
			while(rs.next())
			{
						movieReturn.add(new  MovieReturnFileds(rs.getString(1),rs.getString(6),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)));
			}
			movieDetails.setMovieGett(movieReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in movie details on Dashboard");
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
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public void displaySearchDetailsDAO(String searchTerm,Search searcTerm) throws DAOException{
		
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		ArrayList<SearchAllThings> searchitms=new ArrayList<SearchAllThings>();
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementSearchDetails(getConnection(), sqlCmd, searchTerm);
			rs= stmt.executeQuery();
			while(rs.next())
			{
						
				searchitms.add(new SearchAllThings(rs.getString(1)));
				
					
			}
			searcTerm.setSearchAllItems(searchitms);
			
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in search operation details list");
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	public PreparedStatement getPreparedStatementSearchDetails(Connection connection, String sqlCmd, String searchTerm) throws SQLException{
		try {
			return connection.prepareStatement("select tvshowname from Al237_imdb_tvshowslist where tvshowname like '%"+searchTerm+"%' union select moviename from Al237_imdb_movieslist where moviename like '%"+searchTerm+"%'");
				
		} catch (SQLException e) {
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public void getSearchDetailsDAO(MovieDetails movieDetails) throws DAOException{
		
		PreparedStatement stmt = null,stmt1=null;
		
		ResultSet rs = null;
		ArrayList<MovieReturnFileds> movieReturn=new ArrayList<MovieReturnFileds>();
		
	
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementgetSearchDetails(getConnection(), sqlCmd, movieDetails);
			
			rs= stmt.executeQuery();
			
			while(rs.next())
			{
						movieReturn.add(new  MovieReturnFileds(rs.getString(1),rs.getString(6),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)));
			}
			movieDetails.setMovieGett(movieReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in Getting search details");
		} finally {
			close(stmt, rs);
			close(stmt1,rs);
		}
	}
	public PreparedStatement getPreparedStatementgetSearchDetails(Connection connection, String sqlCmd, MovieDetails movieDetails) throws SQLException{
		try {
			String movie=movieDetails.getMoviename();
			return connection.prepareStatement("select ca.castingname,cp.profession,ml.releasedate,ml.description,ml.image, ge.descrption "
					+ "from Al237_imdb_movie_casting_mapprint_table as cmt, Al237_imdb_movieslist as ml,Al237_imdb_genre as ge ,"
					+ " Al237_imdb_casting as ca,Al237_imdb_genere_movie_table as gmt, Al237_imdb_casting_profession as cp "
					+ " where ml.moviename like '%"+movie+"%' and cmt.casting_id=ca.casting_id and ml.movie_id=cmt.movie_id and"
							+ " ca.profession_id=cp.profession_id and ml.movie_id=gmt.movie_id and gmt.genre_id=ge.genre_id "
							+ "union" + " select ca.castingname,cp.profession,tl.releasedate,tl.description,tl.image, ge.genre "
									+ "from Al237_imdb_tvshows_casting_mapprint_table as tcmt, Al237_imdb_tvshowslist as tl, "
									+ "Al237_imdb_tvshow_genre as ge , Al237_imdb_tvshows_casting as ca,Al237_imdb_genere_tvshow_table as gtt, "
									+ "Al237_imdb_tvshows_casting_profession as cp where tl.tvshowname like '%"+movie+"%' and tcmt.casting_id=ca.casting_id"
									+ " and  tl.tvshows_id=tcmt.tvshows_id and ca.profession_id=cp.profession_id and tl.tvshows_id=gtt.tvshows_id and"
									+ " gtt.tvgenre_id=ge.tvgenre_id ");
				
		} catch (SQLException e) {
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	public void getSearchItemDetailComments(MovieComments movieComments){
		
	}

	public void getSearchItemCommentsDao(MovieComments movieComments) throws DAOException{
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		ArrayList<ListedMovieComments> movieCommentReturn=new ArrayList<ListedMovieComments>();
		
	
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementSearchItemComments(getConnection(), sqlCmd, movieComments);
			
			rs= stmt.executeQuery();
			while(rs.next())
			{
				
				movieCommentReturn.add(new ListedMovieComments(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDate(5)));		
			}
			movieComments.setListedMovieComments(movieCommentReturn);
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in getting search item comments");
		} finally {
			close(stmt, rs);
		}
	}
	public PreparedStatement getPreparedStatementSearchItemComments(Connection connection, String sqlCmd, MovieComments movieComments) throws SQLException{
		try {
			String movie= movieComments.getMoviename();
		
			return connection.prepareStatement("select ud.firstname,ud.lastname,ra.rating,ra.comments,ra.rating_date "
					+ "from Al237_imdb_Rating as ra, Al237_imdb_movieslist as ml, Al237_imdb_user_details as ud "
					+ "where ra.movie_id=ml.movie_id and ra.userid=ud.userid and ml.moviename='"+movie+"'"
					+ " union select ud.firstname,ud.lastname,ra.rating,ra.comments,ra.rating_date "
					+ "from Al237_imdb_tvshow_Rating as ra, Al237_imdb_tvshowslist as tl, Al237_imdb_user_details as ud"
					+ " where ra.tvshows_id=tl.tvshows_id and ra.userid=ud.userid and tl.tvshowname='"+movie+"'");
				
		} catch (SQLException e) {
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	
	public void insertUserCommentsDao(UserCommnets userCommnets) throws DAOException{
		
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null,stmt11=null;
		PreparedStatement stmt2 = null,stmt22=null;
		
		ResultSet rs = null,rs1=null,rs2=null;
		int userid=0;
		int tvshowid=0;
		
		try {
			String sqlCmd = "sql command";
			stmt= getPreparedStatementUserId(getConnection(), userCommnets);
			
			stmt1= getPreparedStatementMovieId(getConnection(), userCommnets); //movielist
			
			stmt2= getPreparedStatementTvShowId(getConnection(), userCommnets);// tvshowlist
			
			rs= stmt.executeQuery();
			rs1= stmt1.executeQuery();
			rs2= stmt2.executeQuery();
			
			if(rs.next())
			{
				 userid=rs.getInt(1);
			}
			
			if(rs1.next())
			{
				int movieid=rs1.getInt(1);
				if(userid!=0)
				{
					stmt11=getPreparedStatementUserCommentsInMovieRating(getConnection(), userCommnets, userid, movieid);
					int count=stmt11.executeUpdate();
					if(count>0)
					{
						userCommnets.setValidComment(true);
						
					}
				}
				
			}
			else if(rs2.next())
			{
				 tvshowid=rs2.getInt(1);
				 if(tvshowid!=0)
					{
						stmt22=getPreparedStatementUserCommentsTvShowsrating(getConnection(), userCommnets, userid, tvshowid);
						int count=stmt22.executeUpdate();
						if(count>0)
						{
							userCommnets.setValidComment(true);
							
						}
					}
			}
			
			getConnection().commit();
			
		} catch (SQLException e) {
			System.out.println("SQLException in createUserRole()"+e);
			throw new DAOException("SQLException in Inserting movie or tvshow comments");
		} finally {
			close(stmt, rs);
		}
	}
	public PreparedStatement getPreparedStatementUserId(Connection connection,UserCommnets userCommnets) throws SQLException{
		try {
			String movie= userCommnets.getUsername();
			return connection.prepareStatement("select userid from Al237_imdb_user_details where email='"+movie+"'");
				
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	public PreparedStatement getPreparedStatementMovieId(Connection connection,UserCommnets userCommnets) throws SQLException{
		try {
			String movie= userCommnets.getMovieortvshow();
			return connection.prepareStatement("select movie_id from Al237_imdb_movieslist where moviename='"+movie+"'");
				
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
	public PreparedStatement getPreparedStatementTvShowId(Connection connection,UserCommnets userCommnets) throws SQLException{
		try {
			String movie= userCommnets.getMovieortvshow();
			return connection.prepareStatement("select tvshows_id from Al237_imdb_tvshowslist where tvshowname='"+movie+"'");
				
		} catch (SQLException e) {
			
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}

	public PreparedStatement getPreparedStatementUserCommentsInMovieRating(Connection connection,UserCommnets userCommnets,int userid , int movieid) throws SQLException{
		try {
			double rating= userCommnets.getRating();
			String comments=userCommnets.getTextareacomment();
			return connection.prepareStatement("insert into Al237_imdb_Rating(userid,movie_id,rating,rating_date,comments) values("+userid+","+movieid+","+rating+",CURRENT_TIMESTAMP(),'"+comments+"')");
				
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementCreateUser" + e.getMessage());
			throw e;
			
		}
	}
	public PreparedStatement getPreparedStatementUserCommentsTvShowsrating(Connection connection,UserCommnets userCommnets,int userid , int tvshowid) throws SQLException{
		try {
			double rating= userCommnets.getRating();
			String comments=userCommnets.getTextareacomment();
			return connection.prepareStatement("insert into Al237_imdb_tvshow_Rating(userid,tvshows_id,rating_date,rating,comments) values("+userid+","+tvshowid+",CURRENT_TIMESTAMP(),"+rating+",'"+comments+"')");
				
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementCreateUser  " + e.getMessage());
			throw e;
			
		}
	}
}
