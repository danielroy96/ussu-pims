/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Service.ClientService;

/**
 *
 * @author danielroy
 */
@RestController
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @RequestMapping(value="client", method = RequestMethod.PUT)
    public int addClient(String name, String contactName, String contactEmail, String contactPhone) {
        String contactNameLocal = null;
        String contactEmailLocal = null;
        String contactPhoneLocal = null;
        if (!"null".equals(contactName)) {
            contactNameLocal = contactName;
        }
        if (!"null".equals(contactEmail)) {
            contactEmailLocal = contactEmail;
        }
        if (!"null".equals(contactPhone)) {
            contactPhoneLocal = contactPhone;
        }
        return clientService.addClient(name, contactNameLocal, contactEmailLocal, contactPhoneLocal);
    }
    
}
