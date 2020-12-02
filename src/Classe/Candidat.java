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
public class Candidat extends Person {
    public Candidat(String id, String lastname, String firstname, String email, String motdepasse, int phone){
        super(id, lastname, firstname, email, motdepasse, phone);
    }

    public String getId() {
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

    public int getPhone() {
        return phone;
    }

    
}
