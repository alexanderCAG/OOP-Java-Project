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
public class Person {
    protected int id;
    protected String lastname;
    protected String firstname;
    protected String email;
    protected String motdepasse;
    protected int phone;
    public Person(int id, String lastname, String firstname, String email, String motdepasse, int phone){
        this.id=id;
        this.lastname=lastname;
        this.firstname=firstname;
        this.email=email;
        this.email=email;
        this.motdepasse=motdepasse;
        this.phone=phone;
    }
    
}
