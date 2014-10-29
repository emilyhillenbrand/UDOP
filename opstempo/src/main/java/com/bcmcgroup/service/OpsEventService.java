package com.bcmcgroup.service;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */
public interface OpsEventService {

    public GenericMessageObject saveOpsEventDetails(OpsEvent opsEvent);

}
