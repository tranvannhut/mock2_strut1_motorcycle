/**
 * StringProcess.java
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
package common;

/**
 * @author NhutTV1
 *
 */
public class StringProcess {

	/**
	 * @param str
	 * @return string valid
	 */
	public static String getValidString(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	/**
	 * @param str
	 * @return boolean when check String is valid.
	 */
	public static boolean checkValidString(String str) {
	/*	String strimVale = str.trim();*/
		if (str == null || str.length() <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * @param str
	 * @return boolean when check this sequence is a number
	 */
	public static boolean checkNumber(String str) {
		String strimValue = str.trim();
		System.out.println(strimValue);
		if (checkValidString(strimValue)) {
			String regex = "[0-9]+";
			if (strimValue.matches(regex)) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * @param str
	 * @return boolean when user enter character special 
	 */
	public static boolean checkSpecialCharacter(String str) {
		if (checkValidString(str)) {
			String regex = "^[a-zA-Z0-9_ ]+";
			if (str.matches(regex)) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * @param str
	 * @return boolean when user enter not format number
	 */
	public static boolean checkNumberNotRequired(String str) {
		if (str == null || str.length() <= 0) {
			return true;
		} else {
			String trimValue = str.trim();
			String regex = "^[0-9]+";
			if (trimValue.matches(regex)) {
				return true;
			}
		}
		return false;
	}
	public static boolean  checkYearFormat(String str){
		if(str == null || str.length() <= 0){
			return true;
		}else{
			String regex = "^\\d{4}$";
			if(str.matches(regex)){
				return true;
			}
			return false;
		}
	}
}
