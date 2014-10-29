package com.bcmcgroup.service;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;

import java.util.List;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */
public interface OpsEventService {

    public List<OpsEvent> create(Object data);

    public List<OpsEvent> update(Object data);

    public boolean delete(Object data);

}
