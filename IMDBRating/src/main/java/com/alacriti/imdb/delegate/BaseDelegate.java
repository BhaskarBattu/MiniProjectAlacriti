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
			//log.logError("SQLException in startDBTransaction " + e.getMessage(), e);
			System.out.println("Exception in getConnection " + e.getMessage());
		}
		return conn;

	}
	protected void endDBTransaction(Connection connection) {
		//log.debugPrintCurrentMethodName();
		try {
			connection.commit();

		} catch (SQLException e) {
			//log.logError("SQLException in endDBTransaction " + e.getMessage(), e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				//log.logError("SQLException in endDBTransaction" + e1.getMessage(), e1);
				System.out.println("Exception in getConnection " + e.getMessage());
			}
		} catch (Exception e) {
			//log.logError("Exception in endDBTransaction" + e.getMessage(), e);
			System.out.println("Exception in getConnection " + e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				//log.logError("SQLException in endDBTransaction" + e.getMessage(), e);
				System.out.println("Exception in getConnection " + e.getMessage());
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {
		//log.debugPrintCurrentMethodName();

		if (isRollback) {
			try {
				connection.rollback();
				//log.logInfo("Rolled Back on some exception....!!!");
			} catch (SQLException e) {
				//log.logError("SQLException in endDBTransaction " + e.getMessage(), e);
				System.out.println("Exception in getConnection " + e.getMessage());
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					//log.logError("SQLException in endDBTransaction " + e.getMessage(), e);
					System.out.println("Exception in getConnection " + e.getMessage());
				}
			}
		} else {
			endDBTransaction(connection);
		}

	}
}
