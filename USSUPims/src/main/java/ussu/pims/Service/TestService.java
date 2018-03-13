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
    
    public void testItem(int itemID, Float earthResistanceOhms, Float insulationResistanceMOhms, int userID) {
        testDAO.testItem(itemID, earthResistanceOhms, insulationResistanceMOhms, userID);
    }
    
}
