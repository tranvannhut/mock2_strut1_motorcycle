/**
 * MakerBo.java
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

import model.bean.Maker;
import model.dao.MakerDao;

public class MakerBo {
    /**
     *HP_NhutTV
     *TODO handle business
     * @return List maker for ListMotorCycleAction
     */
    public List<Maker> getListMaker(){
    	return new MakerDao().getListMarker();
    }
}
