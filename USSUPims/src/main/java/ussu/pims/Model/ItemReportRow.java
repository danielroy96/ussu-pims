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
public class ItemReportRow {
    
    private Item item;
    private Test test;

    public ItemReportRow(Item item, Test test) {
        this.item = item;
        this.test = test;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    
}
