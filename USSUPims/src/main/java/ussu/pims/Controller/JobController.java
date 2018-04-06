/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ussu.pims.Model.Item;
import ussu.pims.Model.JobItem;
import ussu.pims.Service.ItemService;
import ussu.pims.Service.JobService;

import javax.xml.ws.Response;

/**
 *
 * @author danielroy
 */
@RestController
public class JobController {
    
    @Autowired
    private JobService jobService;

    @Autowired
    private ItemService itemService;
    
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
    
    @RequestMapping(value="job/{jobId}", method = RequestMethod.GET)
    public List<JobItem> getJobItems (@PathVariable String jobId) {
        return jobService.getJobItems(Integer.parseInt(jobId));
    }

    @RequestMapping(value="job/{jobId}", method=RequestMethod.PUT)
    public int addJobItem(@PathVariable String jobId, @RequestParam String itemBarcode) {
        return jobService.addJobItem(Integer.parseInt(jobId), itemService.getItemId(itemBarcode));
    }

    @RequestMapping(value="job/{jobId}/{itemId}", method=RequestMethod.PATCH)
    public ResponseEntity<Object> returnJobItem(@PathVariable String jobId, @PathVariable String itemId) {
        jobService.returnJobItem(Integer.parseInt(jobId), Integer.parseInt(itemId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="job/{jobId}/{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeJobItem(@PathVariable String jobId, @PathVariable String itemId) {
        jobService.removeJobItem(Integer.parseInt(jobId), Integer.parseInt(itemId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
