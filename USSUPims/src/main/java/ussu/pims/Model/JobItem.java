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
public class JobItem {
    
    private int jobItemId;
    private int itemId;
    private int jobId;
    private String status;
    private String addedDatetime;
    private String returnedDatetime;
    private String removedDatetime;
    private Item item;

    public JobItem(int jobItemId, int itemId, int jobId, String status, String addedDatetime, String returnedDatetime, String removedDatetime, Item item) {
        this.jobItemId = jobItemId;
        this.itemId = itemId;
        this.jobId = jobId;
        this.status = status;
        this.addedDatetime = addedDatetime;
        this.returnedDatetime = returnedDatetime;
        this.removedDatetime = removedDatetime;
        this.item = item;
    }

    public int getJobItemId() {
        return jobItemId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getJobId() {
        return jobId;
    }

    public String getStatus() {
        return status;
    }

    public String getAddedDatetime() {
        return addedDatetime;
    }

    public String getReturnedDatetime() {
        return returnedDatetime;
    }

    public String getRemovedDatetime() {
        return removedDatetime;
    }

    public Item getItem() {
        return item;
    }
    
    
}
