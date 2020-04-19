/**
 * CreateMotorCycleAction.java
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

/**
 * @author HP
 *
 */
public class CreateMotorCycleAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MotorCycleForm motorCycleForm = (MotorCycleForm) form;
		MotorCycleBo motorCycleBo = new MotorCycleBo();
		MakerBo makerBo = new MakerBo();
		List<Maker> listMaker = makerBo.getListMaker(); 
		motorCycleForm.setListMaker(listMaker);
		String submit = motorCycleForm.getSubmit();
		if("submit".equals(String.valueOf(submit))){
			String id = motorCycleForm.getId();
			boolean checkId = motorCycleBo.checkId(id);
			if (checkId) {
				motorCycleForm.setThongBao("[CTC000290E]：該当するデータは既に存在しています。");
				return mapping.findForward("errorID");
			}
			String makerId = motorCycleForm.getMakerOfId();
			String motorCycleName = motorCycleForm.getMotorCycleOfName();
			String cylinder = motorCycleForm.getCylinderCapacity();
			String releasedInYear = motorCycleForm.getReleasedInYear();
			MotorCycle motorCycle = new MotorCycle(id, makerId, motorCycleName, cylinder, releasedInYear);
			boolean isAdd = motorCycleBo.insertMotorCycle(motorCycle);
			if(isAdd){
				request.setAttribute("confirm","AddMotorSuccess");
				return mapping.findForward("success");
			}
		}
		

		return mapping.findForward("createMotor");
	}

}
