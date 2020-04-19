/**
 * Role.java
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
package enums;

public enum Role {
	Role1("1", "PM"),
    Role2("2", "BA"),
    Role3("3", "LD"),
	Role4("3", "BL");	
	private String code;
	private String display;

	private Role(String code, String display) {
		this.code = code;
		this.display = display;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getCode() {
		return code;
	}

	public String getDisplay() {
		return display;
	}

}
