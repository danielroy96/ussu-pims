/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.ItemEventDAO;
import ussu.pims.Model.MaintenanceEvent;
import ussu.pims.Model.TestEvent;

/**
 *
 * @author danielroy
 */
@Service
public class ItemEventService {
    
    @Autowired
    private ItemEventDAO itemEventDAO;
    
    public List<TestEvent> getTestEvents(int itemId) {
        return itemEventDAO.getTestEvents(itemId);
    }
    
    public List<MaintenanceEvent> getMaintenanceEvents(int itemId) {
        return null;
    }
    
}
