/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.Item;
import ussu.pims.Service.ItemService;
import ussu.pims.Service.UserService;

/**
 *
 * @author danielroy
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "item/{itemID}", method = RequestMethod.GET)
//    public Item getItem(@PathVariable String itemID) {
//        return itemService.getItem(Integer.parseInt(itemID));
//    }

    @RequestMapping(value = "item/{barcode}/check", method = RequestMethod.GET)
    public String checkItemBarcodeExists(@PathVariable String barcode) {
        if (itemService.checkItemBarcode(barcode)) {
            return "barcode_in_use";
        } else {
            return "barcode_not_in_use";
        }
    }
    
    @RequestMapping(value="item/search", method = RequestMethod.GET)
    public List<Item> quickSearch(@RequestParam String searchTerm) {
        return itemService.quickSearch(searchTerm);
    }

    @RequestMapping(value = "item", method = RequestMethod.PUT)
    public String addItem(@RequestParam String barcode, @RequestParam String description, @RequestParam String itemType, Principal principal) {
        String descriptionLocal = null;
        if (!"null".equals(description)) {
            descriptionLocal = description;
        }
        return itemService.addItem(barcode, descriptionLocal, Integer.parseInt(itemType), userService.getUserID(principal));
    }

    @RequestMapping(value = "item/{itemBarcode}", method = RequestMethod.GET)
    public Item getItem(@PathVariable String itemBarcode) {
        return itemService.getItem(itemBarcode);
    }

    @RequestMapping(value = "item/{itemID}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateItem(@PathVariable String itemID, @RequestParam String barcode, @RequestParam String description, @RequestParam String itemType, Principal principal) {
        itemService.updateItem(Integer.parseInt(itemID), barcode, description, Integer.parseInt(itemType), userService.getUserID(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "item/{itemID}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> retireItem(@PathVariable String itemID, Principal principal) {
        itemService.retireItem(Integer.parseInt(itemID), userService.getUserID(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "item/{itemID}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteItem(@PathVariable String itemID, Principal principal) {
        itemService.retireItem(Integer.parseInt(itemID), userService.getUserID(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
