/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.ItemType;
import ussu.pims.Service.ItemTypeService;
import ussu.pims.Service.UserService;

/**
 *
 * @author danielroy
 */
@RestController
public class ItemTypeController {
    
    @Autowired
    private ItemTypeService itemTypeService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="item-type/{itemTypeID}", method=RequestMethod.GET)
    public ItemType getItemType (@PathVariable String itemTypeID) {
        // Call to item type service to get item type
        
        return null;
    }
    
    @RequestMapping(value="item-type", method=RequestMethod.PUT)
    public ResponseEntity<Object> addItemType (@RequestParam String name, @RequestParam String value, @RequestParam String weight, @RequestParam String requiresPAT, @RequestParam String PATIntervalMonths, Principal principal) {
        itemTypeService.addItemType(name, Float.parseFloat(value), Float.parseFloat(weight), requiresPAT, Integer.parseInt(PATIntervalMonths), userService.getUserID(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value="item-type/{itemTypeID}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateItemType (@PathVariable String itemTypeID, @RequestParam String name, @RequestParam String value, @RequestParam String weight, @RequestParam String requiresPAT, @RequestParam String PATIntervalMonths, Principal principal) {
        // Call to item type service to update item type
        itemTypeService.updateItemType(Integer.parseInt(itemTypeID), name, Float.parseFloat(value), Float.parseFloat(weight), requiresPAT, Integer.parseInt(PATIntervalMonths), userService.getUserID(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
