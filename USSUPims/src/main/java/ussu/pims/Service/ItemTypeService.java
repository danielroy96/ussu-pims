/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.ItemTypeDAO;
import ussu.pims.Model.ItemType;

/**
 *
 * @author danielroy
 */
@Service
public class ItemTypeService {
    
    @Autowired
    private ItemTypeDAO itemTypeDAO;
    
    public List<ItemType> quickSearch(String searchTerm) {
        return itemTypeDAO.quickSearch(searchTerm);
    }
    
    public ItemType addItemType(String name, Float value, Float weight, String requiresPAT, Integer PATIntervalMonths, int userID) {
        return itemTypeDAO.addItemType(name, value, weight, requiresPAT, PATIntervalMonths, userID);
    }
    
    public void updateItemType(int itemTypeID, String name, float value, float weight, String requiresPAT, int PATIntervalMonths, int userID) {
        itemTypeDAO.updateItemType(itemTypeID, name, value, weight, requiresPAT, PATIntervalMonths, userID);
    }
    
}
