/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.JobDAO;

/**
 *
 * @author danielroy
 */
@Service
public class JobService {
    
    @Autowired
    private JobDAO jobDAO;
    
    public int addJob(String name, String description, Integer clientId, String jobStartDatetime, String jobEndDatetime, String venue) {
        return jobDAO.addJob(name, description, clientId, jobStartDatetime, jobEndDatetime, venue);
    }
    
    
}
