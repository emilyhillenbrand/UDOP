package com.bcmcgroup.dao;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

@Repository(value = "opsEventDAO")
public class OpsEventDAOImpl implements OpsEventDAO {

    private final static Logger logger = Logger.getLogger(OpsEventDAOImpl.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public GenericMessageObject saveOpsEvent(OpsEvent opsEvent) {
        GenericMessageObject genericMessageObject = new GenericMessageObject();
        try {
            entityManager.persist(opsEvent);
            logger.log(Level.INFO, "Saved Operations Event " + opsEvent.getTitle());
            genericMessageObject.setSuccess(true);
            genericMessageObject.setMessage("Details saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            genericMessageObject.setSuccess(false);
            genericMessageObject.setMessage("Exception in saving details");
        }

        return genericMessageObject;
    }
}
