package com.bcmcgroup.service;

import com.bcmcgroup.dao.OpsEventDAO;
import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

@Service(value = "opsEventService")
public class OpsEventServiceImpl implements OpsEventService {

    @Autowired
    OpsEventDAO opsEventDAO;

    @Override
    public GenericMessageObject saveOpsEventDetails(OpsEvent opsEvent) {
        return opsEventDAO.saveOpsEvent(opsEvent);
    }


}
