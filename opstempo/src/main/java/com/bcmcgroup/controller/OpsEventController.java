package com.bcmcgroup.controller;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import com.bcmcgroup.service.OpsEventService;
import com.bcmcgroup.utils.OpsTempoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

@Controller
@RequestMapping(value = "/opsevent")
public class OpsEventController {

    private final static Logger logger = Logger.getLogger(OpsEventController.class.getName());

    private OpsEventService opsEventService;


    @RequestMapping(value = "/createopsevent", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> createOpsEvent(@RequestParam Object data) throws Exception {

        try {
            List<OpsEvent> opsEvents = opsEventService.create(data);

            return getMap(opsEvents);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error trying to create Ops Event");

            return getModelMapError("Error trying to create Ops Event");
        }
    }

    @RequestMapping(value = "/deleteopsevent", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> deleteOpsEvent(@RequestParam Object data) throws Exception {

        try {
            opsEventService.delete(data);

            Map<String, Object> modelMap = new HashMap<String, Object>(3);
            modelMap.put("success", true);

            return modelMap;

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error trying to delete Ops Event");

            return getModelMapError("Error trying to delete Ops Event");
        }
    }

    @RequestMapping(value = "/updateopsevent", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> updateOpsEvent(@RequestParam Object data) throws Exception {

        try {
            List<OpsEvent> opsEvents = opsEventService.update(data);

            return getMap(opsEvents);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error trying to update Ops Event");

            return getModelMapError("Error trying to update Ops Event");
        }
    }

    /**
     *
     */
    private Map<String, Object> getMap(List<OpsEvent> OEList) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", OEList.size());
        modelMap.put("data", OEList);
        modelMap.put("success", true);

        return modelMap;
    }

    /**
     *
     */
    private Map<String, Object> getModelMapError(String msg) {

        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);

        return modelMap;
    }

    @Autowired
    public void setOpsEventService(OpsEventService opsEventService) {
        this.opsEventService = opsEventService;
    }
}
