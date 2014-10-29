package com.bcmcgroup.utils;

import com.bcmcgroup.model.GenericMessageObject;
import com.bcmcgroup.model.OpsEvent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */


/**
 * @Component annotation required so Spring detects OpsTempoUtils during scan
 * Allows @Autowired annotation to be used in other classes
 */
@Component
public class OpsTempoUtils {

    private final static Logger logger = Logger.getLogger(OpsTempoUtils.class.getName());

    //Make objectMapper singleton - one per instance of OpsTempoUtils
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /*
     public static OpsEvent JsonToJava(String msg, Class<OpsEvent> oe) {

         return null;
     }

     public static String JavaToJson(GenericMessageObject gmo) {

         return null;
     }
    */

    public List<OpsEvent> getOpsEventsFromRequest(Object data) {

        List<OpsEvent> list;

        if (data.toString().indexOf('[') > -1) {
            list = convertJSONToOpsEventList((String) data);
        } else {
            OpsEvent opsev = convertJSONToOpsEvent((String) data);
            list = new ArrayList<OpsEvent>();
            list.add(opsev);
        }

        return list;
    }



    /*********** Private methods ***********/

    private List<OpsEvent> convertJSONToOpsEventList(String data) {
        List<OpsEvent> list = null;

        // Convert JSON String to List of OpsEvent Objects
        try {
            list = objectMapper.readValue(data, new TypeReference<List<OpsEvent>>() {
            });
            logger.log(Level.INFO, "OpsEvent List: \n" + list);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception while mapping JSON to OpsEvent List");
        }

        return list;
    }


    private OpsEvent convertJSONToOpsEvent(String data) {
        OpsEvent OE = null;

        // Convert JSON String to OpsEvent Object
        try {
            OE = objectMapper.readValue(data, OpsEvent.class);
            logger.log(Level.INFO, "OpsEvent: \n" + OE);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception while mapping JSON to OpsEvent");
        }

        return OE;
    }

    private String convertOpsEventToJSON(OpsEvent OE) {

        //Configure objectMapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringOpsEvent = new StringWriter();
        try {
            objectMapper.writeValue(stringOpsEvent, OE);
            logger.log(Level.INFO, "OpsEventJSON: \n" + stringOpsEvent);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Exception while mapping OpsEvent to JSON");
        }

        return stringOpsEvent.toString();

    }
}
