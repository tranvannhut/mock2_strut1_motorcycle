/**
 * ListMotorCycleAction.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListForm;
import model.bean.Maker;
import model.bean.MotorCycle;
import model.business.LoggerFactoryBo;
import model.business.MakerBo;
import model.business.MotorCycleBo;

public class ListMotorCycleAction extends Action {
   private static final Logger logger = LoggerFactoryBo.getLogger();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// common
		// Get List to display for screen Filter
		ListForm listForm = (ListForm) form;
		MakerBo makerBo = new MakerBo();
		MotorCycleBo motorCycleBo = new MotorCycleBo();
		List<Maker> listMaker = makerBo.getListMaker();
		List<MotorCycle> listMotorCycleNameAndCylinder = motorCycleBo.getListMototCycleNameAndCylinder();
		List<String> listMotorCycleName = new ArrayList<String>();
		Set<String> listCylinder = new TreeSet<String>();
		List<MotorCycle> listMotorCycle = new ArrayList<MotorCycle>();
		String addSuccess = (String) request.getAttribute("confirm");
		logger.info(addSuccess);
		for (MotorCycle motor : listMotorCycleNameAndCylinder) {
			listMotorCycleName.add(motor.getMotorCycleName());
			listCylinder.add(motor.getCylinder());
		}
		listForm.setListMaker(listMaker);
		listForm.setListMotorCycleName(listMotorCycleName);
		listForm.setListCylinder(listCylinder);
		int pageNum = listForm.getPageNum();
		int pageSize = 5;
		int totalRecords = 0;
		String id = listForm.getId();
	    if(id == null){
	    	id = "";
		}
		String submit = listForm.getSubmit();
		if (submit == null) {
			submit = "";
		}
		String makerId =  listForm.getMakerId();;
		if(makerId == null){
			makerId = "" ;
		}
		String motorCycleName = listForm.getMotorCycleName();
		if(motorCycleName == null){
			motorCycleName = "";
		}
		String cylinder = listForm.getCylinder();
		if(cylinder == null){
			cylinder = "";
		}
		String released = listForm.getReleased();
		if(released == null){
			released = "";
		}
		// get List MotorCycle for Table when without submit form
		if (("".equals(submit) || submit.length() <= 0 )|| ("submit".equals(submit))) {
			totalRecords = motorCycleBo.getTotalRecords(makerId,motorCycleName, cylinder, released);
			int pageNeedToDisplay = motorCycleBo.checkNewRowInsert(id);
			if(pageNeedToDisplay != 0 && ("AddMotorSuccess".equals(addSuccess))){
				pageNum = (int) Math.ceil((double) pageNeedToDisplay / (double) pageSize);
				listForm.setPageNum(pageNum);
				/*listForm.setThongBao(id + " を追加しました。");*/
				listForm.setThongBao("1件の新ﾃﾞﾎﾟ変換情報を追加しました。");
				logger.info(pageNum + "add success");
			}else if(pageNeedToDisplay != 0 && ("UpdateMotorSuccess".equals(addSuccess))){
				pageNum = (int) Math.ceil((double) pageNeedToDisplay / (double) pageSize);
				listForm.setPageNum(pageNum);
			/*	listForm.setThongBao(id + " を更新しました。");*/
				listForm.setThongBao("1件の新ﾃﾞﾎﾟ変換情報を追加しました。	");
				logger.info("update success");
			}else{
				if(!("".equals(id))){
					if(pageNum > ((int) Math.ceil((double) totalRecords / (double) pageSize))){
						pageNum = ((int) Math.ceil((double) totalRecords / (double) pageSize));
						listForm.setPageNum(pageNum);
					}			
					listForm.setThongBao("[CTC000080I] " + id + " を削除しました。");
					logger.info("delete success");
				}
			}
			
			
			int totalPage = (int) Math.ceil((double) totalRecords / (double) pageSize);
			listForm.setTotalPage(totalPage);
			listMotorCycle = motorCycleBo.getListMotorCycle(pageSize, pageNum,makerId,motorCycleName, cylinder, released);
			listForm.setListMotorCycle(listMotorCycle);
		}
		
		//Case2 : when submit form
		if("filter".equals(String.valueOf(submit)) == true){						
			totalRecords = motorCycleBo.getTotalRecords(makerId,motorCycleName, cylinder, released);
			int totalPage = (int) Math.ceil((double) totalRecords / (double) pageSize);
			listForm.setTotalPage(totalPage);
			listMotorCycle = motorCycleBo.getListMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder,released);
			listForm.setListMotorCycle(listMotorCycle);			
		}
		return mapping.findForward("listMotorCycles");
	}
}
