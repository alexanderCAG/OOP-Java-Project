/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Geoffroy
 */
public class Employer extends Person{
    private String sizecompany;
    private int compteur;
    public Employer(int id, String lastname, String firstname, String email, String motdepasse, int phone, String job, String sizecompany, int compteur){
        super(id, lastname, firstname, email, motdepasse, phone);
        this.sizecompany=sizecompany;
        this.compteur=compteur;
    }

    public int getCompteur() {
        return compteur;
    }
    
    public String getSizecompany() {
        return sizecompany;
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

    public int getPhone() {
        return phone;
    }
    
}
