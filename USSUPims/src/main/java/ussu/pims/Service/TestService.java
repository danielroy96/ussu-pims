/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.TestDAO;


/**
 *
 * @author danielroy
 */
@Service
public class TestService {
    
    @Autowired
    private TestDAO testDAO;
    
    public void testItemIncludeMeasurements(int itemID, float earthResistanceOhms, float insulationResistanceMOhms, int testOperatorUserID) {
        testDAO.testItemIncludeMeasurements(itemID, earthResistanceOhms, insulationResistanceMOhms, testOperatorUserID);
    }
    
    public void testItem(int itemID, int testOperatorUserID) {
        testDAO.testItem(itemID, testOperatorUserID);
    }
    
}
