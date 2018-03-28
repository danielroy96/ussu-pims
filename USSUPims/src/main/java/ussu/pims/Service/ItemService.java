/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.ItemDAO;
import ussu.pims.Model.Item;

/**
 *
 * @author danielroy
 */
@Service
public class ItemService {
    
    @Autowired
    private ItemDAO itemDAO;
    
    public Item getItem(int itemID) {
        return null;
    }
    
    public int getItemId(String barcode) {
        return itemDAO.getItemID(barcode);
    }
    
    public List<Item> quickSearch(String searchTerm) {
        return itemDAO.quickSearch(searchTerm);
    }
    
    public boolean checkItemBarcode(String barcode) {
        return itemDAO.checkItemBarcode(barcode);
    }
    
    public void addItem(String barcode, String description, int itemType, int userID) {
        itemDAO.addItem(barcode, description, itemType, userID);
    }
    
    public void updateItem(int itemID, String barcode, String description, int itemType, int userID) {
        itemDAO.updateItem(itemID, barcode, description, itemType, userID);
    }
    
    public void retireItem(int itemID, int userID) {
        itemDAO.updateItemStatus(itemID, "RETIRED", userID);
    }
    
    public void deleteItem(int itemID, int userID) {
        itemDAO.updateItemStatus(itemID, "DELETED", userID);
    }
}
