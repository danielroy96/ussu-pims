/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.MaintenanceDAO;

/**
 *
 * @author danielroy
 */
@Service
public class MaintenanceService {
    
    @Autowired
    private MaintenanceDAO maintenanceDAO;
    
    @Autowired
    private ItemEventService itemEventService;
    
    public int maintainItem(int itemID, String description, int userID) {
        int maintenanceID = maintenanceDAO.maintainItem(itemID, description, userID);
        itemEventService.logEvent("MAINTENANCE", "Maintenance log added", itemID, userID, null, maintenanceID);
        return maintenanceID;
    }
    
}
