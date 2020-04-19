/**
 * MotorCycleBo.java
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

import java.util.List;

import model.bean.MotorCycle;
import model.dao.MotorCycleDao;

public class MotorCycleBo {
	MotorCycleDao motorCycleDao = new MotorCycleDao();
    //get  List MotorCycle From Database with condition search and no_search
	public List<MotorCycle> getListMotorCycle(int pageSize, int pageNum, String makerId, String motorCycleName,
			String cylinder, String releasedInYear) {
		return motorCycleDao.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear);
	}
	//get  List contain value of two property motorCycleName and Cylinder
	public List<MotorCycle> getListMototCycleNameAndCylinder(){
		return motorCycleDao.getListMotorNameAndCylinder();
	}
	//get Total Record to pagination
	public int getTotalRecords(String makerId,String motorCycleName,String cylinder,String releasedInYear){
		return motorCycleDao.getCountRecord(makerId, motorCycleName, cylinder, releasedInYear);
	}
	//check id is exist in database
	public boolean checkId(String id){
		return motorCycleDao.checkId(id);
	}
	//check insert Object MotorCycle insert into Table MotorCycle in database
	public boolean insertMotorCycle(MotorCycle motorCycle){
		return motorCycleDao.insertMotorCycle(motorCycle);
	}
	// return position of new Object MotorCycle insert in database
	public int checkNewRowInsert(String id){
		return motorCycleDao.checkNewRowInsert(id);
	}
	public boolean isUpdate(MotorCycle motorCycle){
		return motorCycleDao.updateMotor(motorCycle);
	}
	//find MotorCycle depending id
	public MotorCycle findId(String id){
		return motorCycleDao.findId(id);
	}
	//delete a MotorCycle 
	public boolean isDeleteMotorCycle(String id){
		return motorCycleDao.deleteMotor(id);
	}
}
