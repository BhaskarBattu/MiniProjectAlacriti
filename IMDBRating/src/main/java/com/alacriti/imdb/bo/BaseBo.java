package com.alacriti.imdb.bo;

import java.sql.Connection;

public class BaseBo {
	private Connection connection = null;

	public BaseBo() {
	}

	public BaseBo(Connection connection) {
		//System.out.println(debugPrintCurrentMethodName());
		this.connection = connection;
	}

	public Connection getConnection() {

		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
