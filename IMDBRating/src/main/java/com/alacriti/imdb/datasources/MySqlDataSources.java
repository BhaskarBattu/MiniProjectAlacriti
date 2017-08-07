package com.alacriti.imdb.datasources;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class MySqlDataSources {
	private static MySqlDataSources ms_this = null;
	private static DataSource dbSource = null;
	
	private MySqlDataSources() {
		init();
	}

	protected void init() {
		initialize();
	}

	
	
	public static MySqlDataSources getInstance() {
		//log.debugPrintCurrentMethodName();
		synchronized (MySqlDataSources.class) {
			if (ms_this == null) {
				synchronized (MySqlDataSources.class) {
					ms_this = new MySqlDataSources();
				}
			}
		}

		return ms_this;
	}
	public Connection getConnection() {
		//log.debugPrintCurrentMethodName();
		try {
			
			Connection dbCon = dbSource.getConnection();
			dbCon.setAutoCommit(false);
		
			return dbCon;
		} catch (Exception e) {
			//log.logError("Exception in getConnection " + e.getMessage(), e);
			System.out.println("Exception in getConnection " + e.getMessage());
		}
		return null;
	}
	protected void initialize() {
		//log.debugPrintCurrentMethodName();
		try {
			if (dbSource == null) {
			//	log.logInfo("DataSource  looking up URL " + "java:jboss/datasources/newCheckoutMySqlDS");
				InitialContext aInitialContext = new InitialContext();
				dbSource = (DataSource) aInitialContext.lookup("java:jboss/datasources/TRAINEEE");

				//log.logDebug("DataSource dbSource was null and was successfully setup by looking up URL "
					//	+ "java:jboss/datasources/newCheckoutMySqlDS");
			}
		} catch (NamingException e) {
			//log.logError("NamingException in initialize " + e.getMessage(), e);
		} catch (Exception e) {
			//log.logError("Exception in initialize " + e.getMessage(), e);
		}
	}

	
}
