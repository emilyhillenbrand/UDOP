package com.bcmcgroup.controller;

import javax.servlet.http.HttpServletRequest;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import com.bcmcgroup.service.OpsEventService;
import com.bcmcgroup.utils.OpsTempoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

@Controller
@RequestMapping(value = "/opsevent")
public class OpsEventController {

    @Autowired
    OpsEventService opsEventService;

    @RequestMapping(value = "/createopsevent", method = RequestMethod.POST)
    public
    @ResponseBody
    String saveOpsEventDetails(HttpServletRequest httpServletRequest) {

        String jsonStr = httpServletRequest.getParameter("opsEventDetails");
        System.out.println(jsonStr);
        OpsEvent opsEvent = OpsTempoUtils.JsonToJava(jsonStr, OpsEvent.class);
        GenericMessageObject genericMessageObject = opsEventService.saveOpsEventDetails(opsEvent);
        String jsonResonseStr = OpsTempoUtils.JavaToJson(genericMessageObject);
        return jsonResonseStr;
    }

}
