package com.bcmcgroup.dao;

import com.bcmcgroup.model.OpsEvent;
import com.bcmcgroup.model.GenericMessageObject;

/**
 * Created by emilyhillenbrand on 10/28/14.
 */
public interface OpsEventDAO {

    public GenericMessageObject saveOpsEvent(OpsEvent opsEvent);
}
