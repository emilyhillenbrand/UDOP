package com.bcmcgroup.model;

import java.io.Serializable;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */

public class GenericMessageObject implements Serializable {

    private Boolean success;
    private String message;

    /**
     * @return the success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
