
package Classe;

/*Cette classe nous permet de récupérer toutes les données de l'employeur qui sont dans notre SQL*/
public class Employer extends Person{
    private String sizecompany;
    private int compteur;
    
    /*Constructeur*/
    public Employer(int id, String lastname, String firstname, String email, String motdepasse, String phone, String job, String sizecompany, int compteur){
        super(id, lastname, firstname, email, motdepasse, phone);
        this.sizecompany=sizecompany;
        this.compteur=compteur;
    }

    /*Getter afin de nous permettre de mieux manipuler l'ensemble des variables*/
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

    public String getPhone() {
        return phone;
    }
    
}
