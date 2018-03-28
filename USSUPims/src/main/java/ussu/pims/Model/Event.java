/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Model;

/**
 *
 * @author danielroy
 */
public class Event {
    
    private int id;
    private String mnem;
    private String displayText;
    private String eventDatetime;
    private String eventUserFullname;

    public Event(int id, String mnem, String displayText, String eventDatetime, String eventUserFullname) {
        this.id = id;
        this.mnem = mnem;
        this.displayText = displayText;
        this.eventDatetime = eventDatetime;
        this.eventUserFullname = eventUserFullname;
    }
    
    public int getId() {
        return id;
    }

    public String getMnem() {
        return mnem;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getEventDatetime() {
        return eventDatetime;
    }

    public String getEventUserFullname() {
        return eventUserFullname;
    }
    
    
    
}
