package com.bcmcgroup.dao;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

@Repository(value = "opsEventDAO")
public class OpsEventDAOImpl implements OpsEventDAO {

    private final static Logger logger = Logger.getLogger(OpsEventDAOImpl.class.getName());

    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<OpsEvent> getOpsEvents() {
        List<OpsEvent> list = (List<OpsEvent>) hibernateTemplate.find("from Events");
        return list;
    }

    @Override
    public void deleteOpsEvent(int id) {
        Object record = hibernateTemplate.load(OpsEvent.class, id);
        hibernateTemplate.delete(record);
    }

    @Override
    public OpsEvent saveOpsEvent(OpsEvent oEvent) {
        hibernateTemplate.saveOrUpdate(oEvent);
        return oEvent;
    }


    /**
     * SessionFactory declared explicitly in configuration file (ie db-config.xml)
     * It is set on start-up (via DI)
     */
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /*
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
*/
}

