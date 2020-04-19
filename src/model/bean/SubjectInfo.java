/**
 * SubjectInfo.java
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

public class SubjectInfo {
	private String subjectId;
	private String subjectName;
	private LocalDate insTm;
	private LocalDate updTm;

	public SubjectInfo(String subjectId, String subjectName, LocalDate insTm, LocalDate updTm) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.insTm = insTm;
		this.updTm = updTm;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
     
}
