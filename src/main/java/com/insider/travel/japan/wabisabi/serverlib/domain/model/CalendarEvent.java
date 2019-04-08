package com.insider.travel.japan.wabisabi.serverlib.domain.model;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calendar_event database table.
 * 
 */
@Entity
@Table(name="calendar_event")

@NamedQueries({
	@NamedQuery(name="CalendarEvent.findAll", query="SELECT c FROM CalendarEvent c"),
	@NamedQuery(name="CalendarEvent.findEventById", query= "SELECT c FROM CalendarEvent c WHERE c.id = :id"),
	@NamedQuery(name="CalendarEvent.findEventsByAccountId", query= "SELECT c FROM CalendarEvent c WHERE c.accountId = :accountId")
})

public class CalendarEvent extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="account_id")
	private String accountId;

	private Timestamp enddate;

	private Timestamp endtime;

	@Column(name="event_location")
	private String eventLocation;

	@Column(name="event_note")
	private String eventNote;

	@Column(name="event_title")
	private String eventTitle;

	private Timestamp startdate;

	private Timestamp starttime;

	public CalendarEvent() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getEventLocation() {
		return this.eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventNote() {
		return this.eventNote;
	}

	public void setEventNote(String eventNote) {
		this.eventNote = eventNote;
	}

	public String getEventTitle() {
		return this.eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarEvent)) {
            return false;
        }
        CalendarEvent other = (CalendarEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.insider.travel.japan.wabisabi.serverlib.common.domain.model.CalendarEvent[ id=" + id + " ]";
    }

}