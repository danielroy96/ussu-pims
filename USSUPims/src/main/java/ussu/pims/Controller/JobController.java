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
import ussu.pims.Service.JobService;

/**
 *
 * @author danielroy
 */
@RestController
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    @RequestMapping(value="job", method = RequestMethod.PUT)
    public int addJob(String name, String description, String clientId, String jobStartDatetime, String jobEndDatetime, String venue) {
        String descriptionLocal = null;
        Integer clientIdLocal = null;
        String jobStartDatetimeLocal = null;
        String jobEndDatetimeLocal = null;
        String venueLocal = null;
        if (!"null".equals(description)) {
            descriptionLocal = description;
        }
        if (!"null".equals(clientId)) {
            clientIdLocal = Integer.parseInt(clientId);
        }
        if (!"null".equals(jobStartDatetime)) {
            jobStartDatetimeLocal = jobStartDatetime;
        }
        if (!"null".equals(jobEndDatetime)) {
            jobEndDatetimeLocal = jobEndDatetime;
        }
        if (!"null".equals(venue)) {
            venueLocal = venue;
        }
        return jobService.addJob(name, descriptionLocal, clientIdLocal, jobStartDatetimeLocal, jobEndDatetimeLocal, venueLocal);
    }
    
}
