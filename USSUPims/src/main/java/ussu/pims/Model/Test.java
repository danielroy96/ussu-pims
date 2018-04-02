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
public class Test {
    
    private int id;
    private int itemID;
    private String testDatetime;
    private String testUserFullname;

    public Test(int id, int itemID, String testDatetime, String testUserFullname) {
        this.id = id;
        this.itemID = itemID;
        this.testDatetime = testDatetime;
        this.testUserFullname = testUserFullname;
    }

    public int getId() {
        return id;
    }

    public int getItemID() {
        return itemID;
    }

    public String getTestDatetime() {
        return testDatetime;
    }

    public String getTestUserFullname() {
        return testUserFullname;
    }
    
}
