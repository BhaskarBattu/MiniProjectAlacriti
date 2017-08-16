package com.alacriti.imdb.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.imdb.datasources.MySqlDataSources;



public class BaseDelegate {
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	protected Connection startDBTransaction() {
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSources.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			
			System.out.println("Exception in getConnection " + e.getMessage());
		}
		return conn;

	}
	protected void endDBTransaction(Connection connection) {
		
		try {
			connection.commit();

		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
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
