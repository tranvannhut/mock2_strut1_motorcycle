/**
 * LoggerFactoryBo.java
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
package model.business;

import org.apache.log4j.Logger;

public class LoggerFactoryBo {
   public static Logger getLogger(){
	   return Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClass());
   }
}
