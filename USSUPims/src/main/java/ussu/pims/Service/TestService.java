/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.TestDAO;
import ussu.pims.Model.Test;


/**
 *
 * @author danielroy
 */
@Service
public class TestService {
    
    @Autowired
    private TestDAO testDAO;
    
    @Autowired
    private ItemEventService itemEventService;
    
    public int testItem(int itemID, Float earthResistanceOhms, Float insulationResistanceMOhms, int testOperatorUserID) {
        int testID = testDAO.testItem(itemID, earthResistanceOhms, insulationResistanceMOhms, testOperatorUserID).intValue();
        itemEventService.logEvent("TEST", "Item PAT tested", itemID, testOperatorUserID, testID, null);
        return testID;
    }
    
    public Test getLatestTest(int itemID) {
        return testDAO.getLatestTest(itemID);
    }

    public void undoTest(int testId) {
        testDAO.undoTest(testId);
    }
    
    /*public void testItem(int itemID, int testOperatorUserID) {
        testDAO.testItem(itemID, testOperatorUserID);
    }*/
    
}
