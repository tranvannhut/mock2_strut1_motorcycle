/**
 * MemeberInfoDao.java
 * 
 * Version 1.0
 *
 * Date:Mar 15, 2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                AUTHOR                   DESCRIPTION
 * -----------------------------------------------------------------------
 * Mar 15, 2020             NhutTV1                  Create
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import form.MemberForm;
import model.bean.MemberInfo;
import model.business.LoggerFactoryBo;

/**
 * MemberInfoDao Retrieve data from database
 * 
 * @author NhutTV
 *
 */
public class MemberInfoDao {
	// ===========================================
	// Constants
	// ============
	private static final Logger logger = LoggerFactoryBo.getLogger();

	// ===========================================
	// Dao method
	// ============

	/**
	 * Method name : getListMember
	 * <p>
	 * Get List MemberInfo Use procedure to select data
	 * </p>
	 * @return List<MemberInfo>
	 */
	public List<MemberInfo> getListMember(MemberForm memberForm) {

		Connection con = null;
		String sql = " Execute getMember @PageNum = ?  , @PageSize = ?, @memberName = ? , @birthPlace = ?, @gender = ?;";
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		MemberInfo memberInfo = null;
		List<MemberInfo> list = null;
		Map<Integer, MemberInfo> listMap = null;
		StringBuffer sub = null;
		String sub2  = null;

		try {
			con = ConnectionUtils.getMyConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, memberForm.getPm());
			pre.setInt(2, 5);
			pre.setString(3, memberForm.getMemberName());
			pre.setString(4, memberForm.getBirthPlace());
			pre.setString(5, memberForm.getGender());
			resultSet = pre.executeQuery();

			list = new ArrayList<MemberInfo>();
			listMap = new HashMap<>();
			while (resultSet.next()) {
				memberInfo = new MemberInfo();
				memberInfo.setMemberId(resultSet.getInt("member_id"));
				memberInfo.setMemberName(resultSet.getString("member_name"));
				memberInfo.setBirthDay(resultSet.getDate("birthday").toLocalDate());
				memberInfo.setBirthPlace(resultSet.getString("birthPlace"));
				memberInfo.setGender(resultSet.getString("gender"));
				memberInfo.setRole(resultSet.getString("role"));
				memberInfo.setCommentTxt(resultSet.getString("comment_txt"));
				memberInfo.setSubjects(memberInfo.getSubjects().append(resultSet.getString("subject_name") + ","));
				if (listMap.get(memberInfo.getMemberId()) != null) {
					sub = listMap.get(memberInfo.getMemberId()).getSubjects().append(memberInfo.getSubjects());
					memberInfo.setSubjects(sub);
					listMap.put(memberInfo.getMemberId(), memberInfo);
				} else {
					listMap.put(memberInfo.getMemberId(), memberInfo);
				}
			}
			for (MemberInfo url : listMap.values()) {
				sub2 = url.getSubjects().substring(0, url.getSubjects().length() - 1);
				url.setSubjects(new StringBuffer(sub2));
				list.add(url);
			}

		} catch (

		ClassNotFoundException e) {
			logger.error(" Cause : " + e.getCause() + "with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error(" Cause : " + e.getCause() + "with message " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					resultSet.close();
					pre.close();
					con.close();
				} catch (SQLException e) {
					logger.error(" Cause : " + e.getCause() + "with message " + e.getMessage());
				}
			}
		}
		return list;

	}
	
	
	
	/**
	 * Method name : getTotalRecord
	 * <p>
	 * get Total record of List Member base condition search
	 * </p>
	 * @return List<MemberInfo>
	 */
	public int getTotalRecord(MemberForm memberForm){
		Connection con = null;
		String sql = "EXECUTE totalRecordMember @memberName = ?, @birthPlace = ? , @gender = ?;";
		PreparedStatement pre = null;
		ResultSet result = null;
		int total = 0;
		try {
			con = ConnectionUtils.getMyConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, memberForm.getMemberName());
			pre.setString(2,memberForm.getBirthPlace());
			pre.setString(3, memberForm.getGender());
			result = pre.executeQuery();
			if(result.next()){
				total = result.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			logger.error(" Cause : " + e.getCause() + "with message " + e.getMessage());
		} catch (SQLException e) {
			logger.error(" Cause : " + e.getCause() + "with message " + e.getMessage());
		}finally{
			if(con != null){
				try {
					result.close();
					pre.close();
					con.close();			
				} catch (SQLException e) {
					logger.error(" Cause : " + e.getCause() + "with message " + e.getMessage());
				}
			}
		}
		return total;
	}
   public static void main(String[] args) {
	   MemberForm member = new MemberForm();
	   member.setBirthPlace("3e");
	System.out.println(new MemberInfoDao().getTotalRecord(member));
}
}
