/**
 * MakerDao.java
 * 
 * Version 1.0
 *
 * Date:Feb 10, 2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                AUTHOR                   DESCRIPTION
 * -----------------------------------------------------------------------
 * Feb 10, 2020        NhutTV1                  Create
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import model.bean.Maker;
import model.business.LoggerFactoryBo;

public class MakerDao {
	private static final Logger logger = LoggerFactoryBo.getLogger();

	/**
	 * HP_NhutTV 
	 * TODO Select all record when join 2 Table Maker and MotorCycle
	 * @return List of Maker
	 */
	public List<Maker> getListMarker() {
		Connection con = null;
		Statement statement = null;
		ResultSet results = null;
		Maker maker = null;
		List<Maker> listMaker = new ArrayList<Maker>();
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "SELECT distinct M.id , M.makerName  FROM MotorBike_Type AS Mo JOIN Maker AS M ON Mo.makerId = M.id;";
			statement = con.createStatement();
			results = statement.executeQuery(sql);
			while (results.next()) {
				String id = results.getString(1);
				String makerName = results.getString(2);
				maker = new Maker(id, makerName);
				listMaker.add(maker);
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					results.close();
					statement.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return listMaker;
	}
}
