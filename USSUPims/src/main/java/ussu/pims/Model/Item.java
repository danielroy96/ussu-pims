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
public class Item {
    
    private int id;
    private int createdByUserId;
    private String createdByUserFullname;
    private String createdDatetime;
    private String lastChangedDateTime;
    private int lastChangedByUserId;
    private String lastChangedByUserFullname;
    private String barcode;
    private String description;
    private int itemTypeId;
    private String itemTypeName;
    private float value;
    private float weight;
    private boolean requiresPat;
    private int patIntervalMonths;
    private String lastPatTestDatetime;
    private boolean patInDate;

    public Item(int id, int createdByUserId, String createdByUserFullname, String createdDatetime, String lastChangedDateTime, int lastChangedByUserId, String lastChangedByUserFullname, String barcode, String description, int itemTypeId, String itemTypeName, float value, float weight, boolean requiresPat, int patIntervalMonths, String lastPatTestDatetime, boolean patInDate) {
        this.id = id;
        this.createdByUserId = createdByUserId;
        this.createdByUserFullname = createdByUserFullname;
        this.createdDatetime = createdDatetime;
        this.lastChangedDateTime = lastChangedDateTime;
        this.lastChangedByUserId = lastChangedByUserId;
        this.lastChangedByUserFullname = lastChangedByUserFullname;
        this.barcode = barcode;
        this.description = description;
        this.itemTypeId = itemTypeId;
        this.itemTypeName = itemTypeName;
        this.value = value;
        this.weight = weight;
        this.requiresPat = requiresPat;
        this.patIntervalMonths = patIntervalMonths;
        this.lastPatTestDatetime = lastPatTestDatetime;
        this.patInDate = patInDate;
    }

    public int getId() {
        return id;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    public int getLastChangedByUserId() {
        return lastChangedByUserId;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getDescription() {
        return description;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public float getValue() {
        return value;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isRequiresPat() {
        return requiresPat;
    }

    public int getPatIntervalMonths() {
        return patIntervalMonths;
    }

    public String getCreatedByUserFullname() {
        return createdByUserFullname;
    }

    public String getLastChangedByUserFullname() {
        return lastChangedByUserFullname;
    }

    public String getLastPatTestDatetime() {
        return lastPatTestDatetime;
    }

    public boolean isPatInDate() {
        return patInDate;
    }
}
