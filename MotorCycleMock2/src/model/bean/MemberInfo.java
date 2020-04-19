/**
 * MemberInfo.java
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
package model.bean;

import java.time.LocalDate;

/**
 * Bean name : MemberInfo Object to contain data
 * 
 * @author NhutTV
 *
 */
public class MemberInfo {

	private int memberId;
	private String memberName;
	private LocalDate birthDay;
	private String birthPlace;
	private String gender;
	private String role;
	private String commentTxt;
	private int salary;
	private LocalDate insTm;
	private LocalDate updTm;
	private StringBuffer subjects  = new StringBuffer("");

	public MemberInfo() {
		super();
	}

	public MemberInfo(int memberId, String memberName, LocalDate birthDay, String birthPlace, String gender,
			String role, String commentTxt, int salary, LocalDate insTm, LocalDate updTm) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.birthDay = birthDay;
		this.birthPlace = birthPlace;
		this.gender = gender;
		this.role = role;
		this.commentTxt = commentTxt;
		this.salary = salary;
		this.insTm = insTm;
		this.updTm = updTm;
	}

	/**
	 * Getter and setter method
	 */
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCommentTxt() {
		return commentTxt;
	}

	public void setCommentTxt(String commentTxt) {
		this.commentTxt = commentTxt;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getInsTm() {
		return insTm;
	}

	public void setInsTm(LocalDate insTm) {
		this.insTm = insTm;
	}

	public LocalDate getUpdTm() {
		return updTm;
	}

	public void setUpdTm(LocalDate updTm) {
		this.updTm = updTm;
	}

	public StringBuffer getSubjects() {
		return subjects;
	}

	public void setSubjects(StringBuffer subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "MemberInfo [memberId=" + memberId + ", memberName=" + memberName + ", birthDay=" + birthDay
				+ ", birthPlace=" + birthPlace + ", gender=" + gender + ", role=" + role + ", commentTxt=" + commentTxt
				+ ", salary=" + salary + ", insTm=" + insTm + ", updTm=" + updTm + ", subjects=" + subjects + "]";
	}

}
