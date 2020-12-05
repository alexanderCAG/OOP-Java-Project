/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author Geoffroy
 */
public class Recruiter extends Person {
    private String job;
    public Recruiter(int id, String lastname, String firstname, String email, String motdepasse, String phone, String job) {
        super(id, lastname, firstname, email, motdepasse, phone);
        this.job=job;
    }

    public String getJob() {
        return job;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getPhone() {
        return phone;
    }
    
    
}
