
package Model;

/*Cette classe nous permet de récupérer toutes les données du candidat qui sont dans notre SQL*/
public class Candidat extends Person {
    private boolean selection;
    
    /*Constructeur*/
    public Candidat(int id, String lastname, String firstname, String email, String motdepasse, String phone, boolean selection){
        super(id, lastname, firstname, email, motdepasse, phone);
        this.selection=selection;
    }
    
    /*Getter afin de nous permettre de mieux manipuler l'ensemble des variables*/
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

    public boolean isSelection() {
        return selection;
    }
    
    
}
