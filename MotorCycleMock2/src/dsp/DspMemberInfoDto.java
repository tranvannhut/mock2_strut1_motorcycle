/**
 * DspMemberInfoDto.java
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
package dsp;

import java.util.List;

import model.bean.MemberInfo;

public class DspMemberInfoDto {
	public List<MemberInfo> listMemberinfo;

	public List<MemberInfo> getListMemberinfo() {
		return listMemberinfo;
	}

	public void setListMemberinfo(List<MemberInfo> listMemberinfo) {
		this.listMemberinfo = listMemberinfo;
	}
	
}
