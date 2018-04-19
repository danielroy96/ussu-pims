/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ussu.pims.DAO.JobDAO;
import ussu.pims.Model.Item;
import ussu.pims.Model.Job;
import ussu.pims.Model.JobItem;

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

    public List<Job> quickSearch(String searchTerm) {
        return jobDAO.quickSearch(searchTerm);
    }

    public Job getJob(int jobId) {
        return jobDAO.getJob(jobId);
    }
    
    public List<JobItem> getJobItems (int jobId) {
        return jobDAO.getJobItems(jobId);
    }

    public int addJobItem(int jobId, int itemId) {
        return jobDAO.addJobItem(jobId, itemId);
    }

    public void returnJobItem(int jobId, int itemId) {
        jobDAO.returnJobItem(jobId,itemId);
    }

    public void removeJobItem(int jobId, int itemId) {
        jobDAO.removeJobItem(jobId, itemId);
    }
    
}
