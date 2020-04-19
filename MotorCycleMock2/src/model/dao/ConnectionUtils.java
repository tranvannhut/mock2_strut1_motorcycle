/*
* (C)Copyright 2019 Fresher Academy . All right reverse
* Author HP_NhutTV1
* Date  Jan 5, 2020
* Version 1.0
*/
package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import model.business.LoggerFactoryBo;

public class ConnectionUtils {
	 public static final Logger logger = LoggerFactoryBo.getLogger();
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
	}

	//
	// Test Connection ...
	//
	public static void main(String[] args) {

		// logger.info("Get connection ... ");
		logger.info("Get connection ... ");
		// Get a Connection object
		Connection conn;
		try {
			conn = ConnectionUtils.getMyConnection();
			 logger.info("Get connection " + conn);
			 logger.info("Done!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 logger.error(e.getStackTrace());
		}

	}
}
