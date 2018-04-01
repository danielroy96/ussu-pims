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
public class ItemType {
    
    private int id;
    private String name;
    private Float value;
    private Float weight;
    private String requiresPat;
    private Integer patIntervalMonths;
    private String createdByUserFullname;
    private String lastChangedByUserFullname;

    public ItemType(int id, String name, Float value, Float weight, String requiresPat, Integer patIntervalMonths, String createdByUserFullname, String lastChangedByUserFullname) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.requiresPat = requiresPat;
        this.patIntervalMonths = patIntervalMonths;
        this.createdByUserFullname = createdByUserFullname;
        this.lastChangedByUserFullname = lastChangedByUserFullname;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getValue() {
        return value;
    }

    public Float getWeight() {
        return weight;
    }

    public String getRequiresPat() {
        return requiresPat;
    }

    public Integer getPatIntervalMonths() {
        return patIntervalMonths;
    }

    public String getCreatedByUserFullname() {
        return createdByUserFullname;
    }

    public String getLastChangedByUserFullname() {
        return lastChangedByUserFullname;
    }
    
    
    
    
}
