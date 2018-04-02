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
public class Client {
    
    private int id;
    private String name;
    private String contactName;
    private String contactEmail;
    private String contactPhone;

    public Client(int id, String name, String contactName, String contactEmail, String contactPhone) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }
    
}
