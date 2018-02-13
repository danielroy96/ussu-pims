/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.Item;

/**
 *
 * @author danielroy
 */
@RestController
public class ItemController {

    @RequestMapping(value = "item/{itemID}", method = RequestMethod.GET)
    public Item getItem(@PathVariable String itemID) {
        // Return item
        return null;
    }

    @RequestMapping(value = "item", method = RequestMethod.PUT)
    public ResponseEntity<Object> addItem(@RequestParam String barcode, @RequestParam String description, @RequestParam String itemType, Principal principal) {
        // Call to item service to add item
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "item/{itemID}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateItem(@PathVariable String itemID, @RequestParam String barcode, @RequestParam String description, @RequestParam String itemType, Principal principal) {
        // Call to item service to update item
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value="item/{itemID}", method=RequestMethod.PATCH)
    public ResponseEntity<Object> retireItem(@PathVariable String itemID, Principal principal) {
        // Call to item service to retire item
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "item/{itemID}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteItem(@PathVariable String itemID, Principal principal) {
        //Call to item service to delete item
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
