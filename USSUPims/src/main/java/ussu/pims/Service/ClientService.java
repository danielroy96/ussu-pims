/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.ClientDAO;
import ussu.pims.Model.Client;

import java.util.List;

/**
 *
 * @author danielroy
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientDAO clientDAO;

    public List<Client> quickSearch (String searchTerm) {
        return clientDAO.quickSearch(searchTerm);
    }

    public int addClient(String name, String contactName, String contactEmail, String contactPhone) {
        return clientDAO.addClient(name, contactName, contactEmail, contactPhone);
    }
    
}
