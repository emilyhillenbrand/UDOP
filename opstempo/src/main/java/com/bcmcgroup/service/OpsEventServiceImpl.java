package com.bcmcgroup.service;

import com.bcmcgroup.dao.OpsEventDAO;
import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import com.bcmcgroup.utils.OpsTempoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

@Service(value = "opsEventService")
public class OpsEventServiceImpl implements OpsEventService {


    @Autowired
    OpsEventDAO opsEventDAO;

    @Autowired
    OpsTempoUtils opsTempoUtils;

    @Transactional
    public List<OpsEvent> create(Object data) {

        List<OpsEvent> newOpsEvents = new ArrayList<OpsEvent>();

        List<OpsEvent> list = opsTempoUtils.getOpsEventsFromRequest(data);

        for (OpsEvent oEvent : list) {
            newOpsEvents.add(opsEventDAO.saveOpsEvent(oEvent));
        }

        return newOpsEvents;
    }

    @Transactional
    public List<OpsEvent> update(Object data) {

        return null;
    }

    @Transactional
    public boolean delete(Object data) {

        return false;
    }


    @Autowired
    public void setOpsEventDAO(OpsEventDAO opsEventDAO) {
        this.opsEventDAO = opsEventDAO;
    }

    @Autowired
    public void setOpsTempoUtils(OpsTempoUtils opsTempoUtils) {
        this.opsTempoUtils = opsTempoUtils;
    }

}
