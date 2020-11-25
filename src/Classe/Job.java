/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.*;

/**
 *
 * @author Geoffroy
 */
public class Job {
    private String namejob;
    private ArrayList<Person> listPerson;
    public Job(String namejob, ArrayList<Person> listPerson) {
        this.namejob = namejob;
        this.listPerson = listPerson;
    }
    public void newPerson(Person person){
        listPerson.add(person);
    }
    public void deletePerson(Person person){
        listPerson.remove(person);
    }
    
}
