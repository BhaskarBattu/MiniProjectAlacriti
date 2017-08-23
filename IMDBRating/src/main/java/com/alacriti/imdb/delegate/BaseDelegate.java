package com.alacriti.imdb.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.imdb.datasources.MySqlDataSources;



public class BaseDelegate {
	private static final Logger log = Logger.getLogger(BaseDelegate.class);
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	protected Connection startDBTransaction() {
		log.debug("in Base delegate *********** startDBTransaction");
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSources.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			log.error("Exception in getConnection ************* startDBTransaction");
			System.out.println("Exception in getConnection " + e.getMessage());
		}
		return conn;

	}
	protected void endDBTransaction(Connection connection) {
		log.debug("in Base delegate *********** endDBTransaction");
		try {
			connection.commit();

		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				log.error("Exception in getConnection ************* endDBTransaction");
				System.out.println("Exception in getConnection " + e.getMessage());
			}
		} catch (Exception e) {
			
			System.out.println("Exception in getConnection " + e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				
				System.out.println("Exception in getConnection " + e.getMessage());
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {
		

		if (isRollback) {
			try {
				connection.rollback();
				
			} catch (SQLException e) {
				
				System.out.println("Exception in getConnection " + e.getMessage());
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					
					System.out.println("Exception in getConnection " + e.getMessage());
				}
			}
		} else {
			endDBTransaction(connection);
		}

	}
}
