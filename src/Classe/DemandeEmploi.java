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
public class DemandeEmploi {
    private String Metier;
    private String statut;
    private String Date;

    public DemandeEmploi(String Metier, String statut, String Date) {
        this.Metier = Metier;
        this.statut = statut;
        this.Date = Date;
    }
    public String getMetier() {
        return Metier;
    }

    public String getStatut() {
        return statut;
    }

    public String getDate() {
        return Date;
    }
}
