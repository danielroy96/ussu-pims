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
public class MaintenanceEvent extends Event{
    
    private String description;
    
    public MaintenanceEvent(int id, String mnem, String displayText, String eventDatetime, String eventUserFullname, String description) {
        super(id, mnem, displayText, eventDatetime, eventUserFullname);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}
