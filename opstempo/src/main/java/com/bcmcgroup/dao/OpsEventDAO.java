package com.bcmcgroup.dao;

import com.bcmcgroup.model.OpsEvent;
import com.bcmcgroup.model.GenericMessageObject;

import java.util.List;

/**
 * Created by emilyhillenbrand on 10/28/14.
 */
public interface OpsEventDAO {

    //public GenericMessageObject saveOpsEventTest(OpsEvent opsEvent);

    List<OpsEvent> getOpsEvents();

    void deleteOpsEvent(int id);

    OpsEvent saveOpsEvent(OpsEvent oEvent);
}
