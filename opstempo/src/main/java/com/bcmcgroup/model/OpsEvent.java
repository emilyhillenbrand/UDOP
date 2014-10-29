package com.bcmcgroup.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by emilyhillenbrand on 10/29/14.
 */
@Entity
@Table(name = "EVENTS")
public class OpsEvent implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EVENT_ID")
    private int eventId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
