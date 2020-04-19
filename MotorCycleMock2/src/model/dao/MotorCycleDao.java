/**
 * MotorCycleDao.java
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.bean.MotorCycle;
import model.business.LoggerFactoryBo;

/**
 * @author HP
 *
 */
public class MotorCycleDao {
	private static final Logger logger = LoggerFactoryBo.getLogger();

	/**
	 * HP_NhutTV TODO get List MotorCycle from Table MotorCycle in database
	 * Create procedure to reuse for 2 case search has parameter and
	 * no-parameter CREATE PROCEDURE dbo.pGetMotor
	 * 
	 * @PageSize int ,
	 * @PageNum int,
	 * @makerId nvarchar(100),
	 * @motorCycleName nvarchar(100),
	 * @cylinder nvarchar(20),
	 * @released nvarchar(8) AS SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER
	 *           BY M.makerName) AS rowNum , Mo.id , Mo.makerId , M.makerName,
	 *           Mo.motorCycleName , Mo.cylinder , Mo.release FROMMotorBike_Type
	 *           AS Mo JOIN Maker AS M ON M.id = Mo.makerId WHERE Mo.makerId
	 *           LIKE '%'+@makerId+'%' AND Mo.motorCycleName LIKE
	 *           '%'+@motorCycleName+'%' AND Mo.cylinder LIKE '%'+@cylinder+'%'
	 *           AND Mo.release LIKE '%'+@released+'%') AS tableMotor WHERE
	 *           rowNum Between (((@PageNum -1) * @PageSize) + 1) AND
	 *           (@PageNum @PageSize)
	 * @param pageSize
	 * @param pageNum
	 * @param makerId
	 * @param motorCycleName
	 * @param cylinder
	 * @param releasedInYear
	 * @return List<MotorCycle>
	 */
	public List<MotorCycle> getAllMotorCycle(int pageSize, int pageNum, String makerId, String motorCycleName,
			String cylinder, String releasedInYear) {
		List<MotorCycle> listMotor = new ArrayList<MotorCycle>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		MotorCycle motorCycle = null;
		ResultSet results = null;
		String id = null;
		String maker_id = null;
		String motorCycle_name = null;
		String cylinders = null;
		String releaseInYear = null;

		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "EXECUTE pGetMotor @PageSize = ?, @PageNum = ? , @makerId = ? , @motorCycleName = ?, @cylinder = ? , @released = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, pageSize);
			preparedStatement.setInt(2, pageNum);
			preparedStatement.setString(3, makerId);
			preparedStatement.setString(4, motorCycleName);
			preparedStatement.setString(5, cylinder);
			preparedStatement.setString(6, releasedInYear);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				id = results.getString("id");
				maker_id = results.getString("makerName");
				motorCycle_name = results.getString("motorCycleName");
				cylinders = results.getString("cylinder");
				releaseInYear = results.getString("release");
				motorCycle = new MotorCycle(id, maker_id, motorCycle_name, cylinders, releaseInYear);
				listMotor.add(motorCycle);
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					results.close();
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return listMotor;
	}

	/**
	 * HP_NhutTV TODO Get List<Motorcycle> from database contain data of
	 * property MotorCycleName and cylinder to display on screen Filter
	 * 
	 * @return List<MotorCycle>
	 */
	public List<MotorCycle> getListMotorNameAndCylinder() {
		Connection con = null;
		Statement statement = null;
		ResultSet results = null;
		MotorCycle motorCycle = null;
		List<MotorCycle> listMotor = new ArrayList<MotorCycle>();
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "SELECT distinct Mo.motorCycleName, Mo.cylinder  FROM MotorBike_Type AS Mo JOIN Maker AS M ON Mo.makerId = M.id;";
			statement = con.createStatement();
			results = statement.executeQuery(sql);
			while (results.next()) {
				String motorCycleName = results.getString(1);
				String cylinder = results.getString(2);
				motorCycle = new MotorCycle(null, null, motorCycleName, cylinder, null);
				listMotor.add(motorCycle);
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
		return listMotor;
	}

	/**
	 * HP_NhutTV TODO Count Records from Database when Join 2 table MotorCycle
	 * and Maker to aim separate number page Use Procedure CREATE PROCEDURE
	 * dbo.pGetToTalPage
	 * 
	 * @makerId nvarchar(100),
	 * @motorCycleName nvarchar(100),
	 * @cylinder nvarchar(20),
	 * @released nvarchar(8) AS SELECT COUNT(*) FROM MotorBike_Type AS Mo JOIN
	 *           Maker AS M ON Mo.makerId = M.id WHERE Mo.makerId LIKE
	 *           '%'+@makerId+'%' AND Mo.motorCycleName LIKE
	 *           '%'+@motorCycleName+'%' AND Mo.cylinder LIKE '%'+@cylinder+'%'
	 *           AND Mo.release LIKE '%'+@released+'%' method has parameters
	 * @param makerId
	 * @param motorCycleName
	 * @param cylinder
	 * @param releasedInYear
	 * @return a number (mean total record)
	 */
	public int getCountRecord(String makerId, String motorCycleName, String cylinder, String releasedInYear) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int totalRecords = 0;
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "EXECUTE pGetToTalPage  @makerId = ? , @motorCycleName = ?, @cylinder = ? , @released = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, makerId);
			preparedStatement.setString(2, motorCycleName);
			preparedStatement.setString(3, cylinder);
			preparedStatement.setString(4, releasedInYear);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				totalRecords = result.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					result.close();
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return totalRecords;
	}

	/**
	 * HP_NhutTV TODO check ID is Exist
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean checkId(String id) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean isCheck = false;
		String sql = null;
		try {
			con = ConnectionUtils.getMyConnection();
			sql = "SELECT * FROM MotorBike_Type AS M WHERE M.id = ?;";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				isCheck = true;
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return isCheck;
	}

	/**
	 * HP_NhutTV TODO insert Object MotorCycle into database
	 * 
	 * @param motorCycle
	 * @return boolean
	 */
	public boolean insertMotorCycle(MotorCycle motorCycle) {
		boolean isAdd = false;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "INSERT INTO MotorBike_Type VALUES (?,?,?,?,?);";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, motorCycle.getId());
			preparedStatement.setString(2, motorCycle.getMakerId());
			preparedStatement.setString(3, motorCycle.getMotorCycleName());
			preparedStatement.setString(4, motorCycle.getCylinder());
			preparedStatement.setString(5, motorCycle.getReleasedInYear());
			int isRowInsert = preparedStatement.executeUpdate();
			if (isRowInsert == 1) {
				isAdd = true;
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause" + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return isAdd;
	}

	public int checkNewRowInsert(String id) {
		Connection con = null;
		int rowNow = 0;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY Mo.motorCycleName) AS rowNum, Mo.id FROM MotorBike_Type AS Mo INNER JOIN Maker m ON  Mo.makerId = m.id ) AS table2 WHERE table2.id = ?;";
			pre = con.prepareStatement(sql);
			pre.setString(1, id);
			resultSet = pre.executeQuery();
			if (resultSet.next()) {
				rowNow = resultSet.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					resultSet.close();
					pre.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return rowNow;
	}

	public boolean updateMotor(MotorCycle motorCycle) {
		boolean isUpdate = false;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "UPDATE MotorBike_Type SET makerId = ? , motorCycleName = ? , cylinder = ? WHERE id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, motorCycle.getMakerId());
			preparedStatement.setString(2, motorCycle.getMotorCycleName());
			preparedStatement.setString(3, motorCycle.getCylinder());
			preparedStatement.setString(4, motorCycle.getId());
			int isRecordUpdate = preparedStatement.executeUpdate();
			if (isRecordUpdate == 1) {
				isUpdate = true;
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return isUpdate;
	}

	public MotorCycle findId(String id) {
		MotorCycle motorCycle = null;
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		try {
			
			con = ConnectionUtils.getMyConnection();
			String sql = "SELECT Mo.id, Mo.makerId , Mo.motorCycleName, Mo.cylinder , Mo.release , M.makerName FROM MotorBike_Type AS Mo JOIN Maker AS M  ON M.id = Mo.makerId WHERE Mo.id =  ?; ";
			pre = con.prepareStatement(sql);
			pre.setString(1, id);
			result = pre.executeQuery();
			String motorCycleName = null;
			String cylinder = null;
			String makerId = null;
			String releasedInYear = null;
			while (result.next()) {
				motorCycle = new MotorCycle();
				makerId = result.getString("makerId");
				motorCycleName = result.getString("motorCycleName");
				cylinder = result.getString("cylinder");
				releasedInYear = result.getString("release");
				motorCycle.setId(id);
				motorCycle.setMotorCycleName(motorCycleName);
				motorCycle.setMakerId(makerId);
				motorCycle.setReleasedInYear(releasedInYear);
				motorCycle.setCylinder(cylinder);
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					result.close();
					pre.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return motorCycle;
	}
    
	public boolean deleteMotor(String id){
		Connection con = null;
		boolean isDelete = false;
		PreparedStatement pre = null;
		int deleteRow = 0;
		try {
			con = ConnectionUtils.getMyConnection();
			String sql = "DELETE FROM MotorBike_Type WHERE id = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, id);
			deleteRow = pre.executeUpdate();
			if(deleteRow == 1){
				isDelete = true;
			}
		} catch (ClassNotFoundException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
		}finally{
			if(con != null){
				try {
					pre.close();
					con.close();
				} catch (SQLException e) {
					logger.error("Cause  " + e.getCause() + " with message " + e.getMessage());
				}
			}
		}
		return isDelete;
	}
	public static void main(String[] args) {
		MotorCycle motorCycle = new MotorCycle("1l", "HD001", "SH ABS 125cc", "125", "2010");
		boolean isAdd = new MotorCycleDao().insertMotorCycle(motorCycle);
		logger.info(isAdd);
		logger.info(new MotorCycleDao().checkId("1"));
		logger.info(new MotorCycleDao().checkNewRowInsert("2"));
		logger.info(new MotorCycleDao().updateMotor(new MotorCycle("1", "HD001", "Future 115", "115", "2010")));
		 logger.info(new MotorCycleDao().findId("2").toString());
	   logger.info(new MotorCycleDao().deleteMotor(""));			
	     
	}
}
