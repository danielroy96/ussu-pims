/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Model;

/**
 *
 * @author danielroy
 */
public class Job {
    
    private int id;
    private String name;
    private String description;
    private Client client;
    private String jobStartDatetime;
    private String jobEndDatetime;
    private String venue;

    public Job(int id, String name, String description, String jobStartDatetime, String jobEndDatetime, String venue, int clientId, String clientName, String clientContactName, String clientContactEmail, String clientContactPhone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobStartDatetime = jobStartDatetime;
        this.jobEndDatetime = jobEndDatetime;
        this.venue = venue;
        this.client = new Client(clientId, clientName, clientContactName, clientContactEmail, clientContactPhone);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Client getClient() {
        return client;
    }

    public String getJobStartDatetime() {
        return jobStartDatetime;
    }

    public String getJobEndDatetime() {
        return jobEndDatetime;
    }

    public String getVenue() {
        return venue;
    }
    
    
    
}
