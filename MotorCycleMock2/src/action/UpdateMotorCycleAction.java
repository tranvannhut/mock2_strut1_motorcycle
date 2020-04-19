/**
 * UpdateMotorCycleAction.java
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
package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.MotorCycleForm;
import model.bean.Maker;
import model.bean.MotorCycle;
import model.business.MakerBo;
import model.business.MotorCycleBo;

public class UpdateMotorCycleAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MotorCycleForm  motorCycleForm = (MotorCycleForm) form;
	    String id = motorCycleForm.getId();
	    String motorCycleName = null;
	    String makerId = null;
	    String cylinder = null;
	    String releasedInYear = null;
		MotorCycleBo motorCycleBo = new MotorCycleBo();
		MakerBo makerBo = new MakerBo();
		List<Maker> listMaker = makerBo.getListMaker();
		MotorCycle motorCycle = motorCycleBo.findId(id);
		
	    String submit  = motorCycleForm.getSubmit();

	    if("submit".equals(submit)){
	    	System.out.println(motorCycleForm.toString());
	    	 motorCycleName = motorCycleForm.getMotorCycleOfName();
	    	 makerId = motorCycleForm.getMakerOfId();
	    	 cylinder = motorCycleForm.getCylinderCapacity();
	    	 releasedInYear = motorCycle.getReleasedInYear();
	    	 motorCycle = new MotorCycle(id, makerId, motorCycleName, cylinder, releasedInYear);
	    	 boolean isUpdate = motorCycleBo.isUpdate(motorCycle);
	    	 if(isUpdate){
	         request.setAttribute("confirm", "UpdateMotorSuccess");
	    	 return mapping.findForward("success");
	    	 }
	    }else{
	    	motorCycleForm.setId(id);
	    	motorCycleForm.setMakerOfId(motorCycle.getMakerId());
			motorCycleForm.setMotorCycleOfName(motorCycle.getMotorCycleName());
			motorCycleForm.setCylinderCapacity(motorCycle.getCylinder());		
			motorCycleForm.setListMaker(listMaker);
	    }
		return mapping.findForward("updateMotor");
	}

}
