/**
 * MemberForm.java
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
package form;

import org.apache.struts.action.ActionForm;

public class MemberForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberName;
	private String birthPlace;
	private String gender;
	private int pm = 1;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPm() {
		return pm;
	}

	public void setPm(int pm) {
		this.pm = pm;
	}

	

}
