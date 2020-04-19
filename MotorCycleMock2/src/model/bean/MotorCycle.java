/**
 * MotorCycle.java
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
package model.bean;

public class MotorCycle {
	private String id;
	private String makerId;
	private String motorCycleName;
	private String cylinder;
	private String releasedInYear;

	public MotorCycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotorCycle(String id, String makerId, String motorCycleName, String cylinder, String releasedInYear) {
		super();
		this.id = id;
		this.makerId = makerId;
		this.motorCycleName = motorCycleName;
		this.cylinder = cylinder;
		this.releasedInYear = releasedInYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	public String getMotorCycleName() {
		return motorCycleName;
	}

	public void setMotorCycleName(String motorCycleName) {
		this.motorCycleName = motorCycleName;
	}

	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public String getReleasedInYear() {
		return releasedInYear;
	}

	public void setReleasedInYear(String releasedInYear) {
		this.releasedInYear = releasedInYear;
	}

	@Override
	public String toString() {
		return "MotorCycle [id=" + id + ", makerId=" + makerId + ", motorCycleName=" + motorCycleName + ", cylinder="
				+ cylinder + ", releasedInYear=" + releasedInYear + "]";
	}

}
