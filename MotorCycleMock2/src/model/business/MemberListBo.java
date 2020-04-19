/**
 * MemberBo.java
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
package model.business;

import java.util.List;

import form.MemberForm;
import model.bean.MemberInfo;
import model.dao.MemberInfoDao;

public class MemberListBo { 
	 private MemberInfoDao memberInfoDao = new MemberInfoDao();
	//get List Member base condition search
	public List<MemberInfo> getListMember(MemberForm memberForm){
		return memberInfoDao.getListMember(memberForm);
	}
	
	
}
