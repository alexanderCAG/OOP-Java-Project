/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Geoffroy
 */
public class AJob {
    private String namejob;
    private ArrayList<Person> listPerson;
    public AJob(String namejob) {
        this.namejob = namejob;
        this.listPerson = listPerson;
        ArrayList<Person> listPerson= new ArrayList();
    }
    public void newPerson(Person person){
        listPerson.add(person);
    }
    public void deletePerson(Person person){
        listPerson.remove(person);
    }
}
