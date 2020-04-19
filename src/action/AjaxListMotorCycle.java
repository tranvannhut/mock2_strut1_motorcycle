/**
 * AjaxListMotorCycle.java
 * 
 * Version 1.0
 *
 * Date:Feb 17, 2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                AUTHOR                   DESCRIPTION
 * -----------------------------------------------------------------------
 * Feb 17, 2020             NhutTV1                  Create
 */
package action;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import form.MotorCycleForm;
import model.business.MotorCycleBo;

public class AjaxListMotorCycle extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MotorCycleForm motor = (MotorCycleForm)  form;
		MotorCycleBo motorCycleBo = new MotorCycleBo();
		JSONObject jsonObject = new JSONObject(request.getParameter("json"));
		JSONArray json = new JSONArray(jsonObject);
		BufferedReader br = request.getReader();		
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		response.setContentType("text/text;charset=utf-8");
	//	response.setHeader("cache-control", "no-cache");
		PrintWriter out = null;
		String option = "";
		String id = motor.getId();
		String markerId = motor.getMakerOfId();
		boolean checkId = motorCycleBo.checkId(id);
		if (checkId) {
			option += id + "  is exist in database" + "and MotorCycleName " + markerId;	
			option += "<h1>Now im fell tired</h1>";
		}
		
		//option = "The first Time , I use demo Ajax";
		out = response.getWriter();
		
		out.println(option);
		out.flush();

		return null;
		
	}

}
