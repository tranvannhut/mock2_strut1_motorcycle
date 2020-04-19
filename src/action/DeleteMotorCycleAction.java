/**
 * DeleteMotorCycleAction.java
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.MotorCycleForm;
import model.business.MotorCycleBo;

public class DeleteMotorCycleAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MotorCycleForm motorCycleForm = (MotorCycleForm) form;
		String id = motorCycleForm.getId();
		String pageNum = motorCycleForm.getPageNum();
		System.out.println(id);
		System.out.println(pageNum);
		MotorCycleBo motorCycleBo = new MotorCycleBo();
		boolean isDelete = motorCycleBo.isDeleteMotorCycle(id);
		if (isDelete) {
			return mapping.findForward("success");
		}
		return mapping.findForward("deleteMotor");
	}

}
