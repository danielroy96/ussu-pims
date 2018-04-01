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
import ussu.pims.Service.ItemService;
import ussu.pims.Service.MaintenanceService;
import ussu.pims.Service.UserService;

/**
 *
 * @author danielroy
 */
@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private ItemService itemService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "item/{barcode}/maintain", method = RequestMethod.GET)
    public ResponseEntity<Object> maintainItem(@PathVariable String barcode, @RequestParam String description, Principal principal) {
        maintenanceService.maintainItem(itemService.getItemId(barcode), description, userService.getUserID(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
