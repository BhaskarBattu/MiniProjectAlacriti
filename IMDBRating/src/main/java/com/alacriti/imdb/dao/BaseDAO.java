package com.alacriti.imdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDAO {
	private Connection connection;

	public BaseDAO(){
		
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public BaseDAO(Connection connection) {
		
		this.connection = connection;
	}
	public void close(ResultSet rs) {
		//log.debugPrintCurrentMethodName();
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				//log.logError("Exception in close " + e.getMessage(), e);
				System.out.println("Exception in close " + e.getMessage());
			}
		}
	}

	public void close(Statement stmt) {
		//log.debugPrintCurrentMethodName();
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				//log.logError("Exception in close " + e.getMessage(), e);
				System.out.println("Exception in close " + e.getMessage());
			}
		}
	}

	public void close(PreparedStatement stmt, ResultSet rs) {
		//log.debugPrintCurrentMethodName();
		close(stmt);
		close(rs);

	}
}
