/**
 * Maker.java
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

public class Maker {
	private String id;
	private String makerName;
	public String getId() {
		return id;
	}
	
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}
	public Maker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Maker(String id, String makerName) {
		super();
		this.id = id;
		this.makerName = makerName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMakerName() {
		return makerName;
	}

	@Override
	public String toString() {
		return "Maker [id=" + id + ", makerName=" + makerName + "]";
	}
	
    
}
