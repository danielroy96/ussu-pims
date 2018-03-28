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
public class TestEvent extends Event {
    
    private float earthResistanceOhms;
    private float insulationResistanceMOhms;

    public TestEvent(int id, String mnem, String displayText, String eventDatetime, String eventUserFullname, float earthResistanceOhms, float insulationResistanceMOhms) {
        super(id, mnem, displayText, eventDatetime, eventUserFullname);
        this.earthResistanceOhms = earthResistanceOhms;
        this.insulationResistanceMOhms = insulationResistanceMOhms;
    }

    public float getEarthResistanceOhms() {
        return earthResistanceOhms;
    }

    public float getInsulationResistanceMOhms() {
        return insulationResistanceMOhms;
    }
    
    
    
}
