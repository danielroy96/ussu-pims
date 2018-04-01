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
public class ChartDataPoint {
    
    private String label;
    private int value;
    private int myValue;

    public ChartDataPoint(String label, int value, int myValue) {
        this.label = label;
        this.value = value;
        this.myValue = myValue;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }
    
    public int getMyValue() {
        return myValue;
    }
    
}
