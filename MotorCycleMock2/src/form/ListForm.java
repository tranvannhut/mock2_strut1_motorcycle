/**
 * ListForm.java
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
package form;

import java.util.List;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import model.bean.Maker;
import model.bean.MotorCycle;

@SuppressWarnings("serial")
public class ListForm extends ActionForm {
	private String id;
	private String makerId;
	private String motorCycleName;
	private String cylinder;
	private String released;
	private List<MotorCycle> listMotorCycle;
	private List<Maker> listMaker;
	private List<String> listMotorCycleName;
	private List<Integer> listTotalPage;
	private Set<String> listCylinder;
	private int pageNum = 1;
	private int totalPage ;
    private String submit;
    private String thongBao;
    
    
	
    
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

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public List<MotorCycle> getListMotorCycle() {
		return listMotorCycle;
	}

	public void setListMotorCycle(List<MotorCycle> listMotorCycle) {
		this.listMotorCycle = listMotorCycle;
	}

	public List<Maker> getListMaker() {
		return listMaker;
	}

	public void setListMaker(List<Maker> listMaker) {
		this.listMaker = listMaker;
	}

	public List<String> getListMotorCycleName() {
		return listMotorCycleName;
	}

	public void setListMotorCycleName(List<String> listMotorCycleName) {
		this.listMotorCycleName = listMotorCycleName;
	}

	public Set<String> getListCylinder() {
		return listCylinder;
	}

	public void setListCylinder(Set<String> listCylinder) {
		this.listCylinder = listCylinder;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<Integer> getListTotalPage() {
		return listTotalPage;
	}

	public void setListTotalPage(List<Integer> listTotalPage) {
		this.listTotalPage = listTotalPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	
   
}
