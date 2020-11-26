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
public class Employer extends Person{
    private String sizecompany;
    public Employer(String id, String lastname, String firstname, String email, String motdepasse, int phone, String job, String sizecompany){
        super(id, lastname, firstname, email, motdepasse, phone, job);
        this.sizecompany=sizecompany;
    }
}
