/**
 * MotorCycleForm.java
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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import model.bean.Maker;
import model.business.MakerBo;

@SuppressWarnings("serial")
public class MotorCycleForm extends ActionForm {
	private String id;
	private String makerOfId;
	private String motorCycleOfName;
	private String cylinderCapacity;
	private String releasedInYear;
	private String pageNum;
	private List<Maker> listMaker;
	private String submit;
	private String thongBao;
   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMakerOfId() {
		return makerOfId;
	}

	public void setMakerOfId(String makerOfId) {
		this.makerOfId = makerOfId;
	}

	public String getMotorCycleOfName() {
		return motorCycleOfName;
	}

	public void setMotorCycleOfName(String motorCycleOfName) {
		this.motorCycleOfName = motorCycleOfName;
	}

	public String getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(String cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public String getReleasedInYear() {
		return releasedInYear;
	}

	public void setReleasedInYear(String releasedInYear) {
		this.releasedInYear = releasedInYear;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public List<Maker> getListMaker() {
		return listMaker;
	}

	public void setListMaker(List<Maker> listMaker) {
		this.listMaker = listMaker;
	}
    
	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "MotorCycleForm [id=" + id + ", makerOfId=" + makerOfId + ", motorCycleOfName=" + motorCycleOfName
				+ ", cylinderCapacity=" + cylinderCapacity + ", releasedInYear=" + releasedInYear + ", pageNum="
				+ pageNum + ", listMaker=" + listMaker + ", submit=" + submit + ", thongBao=" + thongBao + "]";
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		if("submit".equals(this.submit)){
			MakerBo makerBo = new MakerBo();
			List<Maker> listMaker = makerBo.getListMaker(); 
			this.setListMaker(listMaker);
			ActionErrors actionError = new ActionErrors();
			//check ID is not empty and same format Number
			if(StringProcess.checkValidString(id) == false){
				actionError.add("idError",new ActionMessage("error.id.empty"));
			} else{
			if(StringProcess.checkNumber(id) == false){
				actionError.add("idIsValidNumber",new ActionMessage("error.id.number"));
			}
			};
			
			//check markerID is not empty
			if(StringProcess.checkValidString(makerOfId) == false){
				actionError.add("makerIdError",new ActionMessage("error.makerId.empty"));
			}
			
		    //check  motorCycleName is not Empty and same format
			if(StringProcess.checkValidString(motorCycleOfName)== false){
				actionError.add("motorCycleNameEmpty",new ActionMessage("error.motorCycleName.empty"));
			}else{
				if(StringProcess.checkSpecialCharacter(motorCycleOfName) == false){
					actionError.add("motorCycleNameFormat",new ActionMessage("error.motorCycleName.format"));
				}
			}
			
			//check cylinder of Motor is not format number
			if(StringProcess.checkNumberNotRequired(cylinderCapacity)==false){
				actionError.add("cylinderFormat",new ActionMessage("error.cylinderMotor.format"));
			}
			
			
			//check released in Year of Motor
			if(StringProcess.checkYearFormat(releasedInYear) == false){
				actionError.add("releaseInYearError",new ActionMessage("error.releasedInYear.format"));
			}
			return actionError;		
		}
		return null;
	}

	

	
}
