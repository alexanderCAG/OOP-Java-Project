
package Classe;

/*Cette classe nous permet de récupérer toutes les données du candidat qui sont dans notre SQL*/
public class Recruiter extends Person {
    private String job;
    
    /*Constructeur*/
    public Recruiter(int id, String lastname, String firstname, String email, String motdepasse, String phone, String job) {
        super(id, lastname, firstname, email, motdepasse, phone);
        this.job=job;
    }

    /*Getter afin de nous permettre de mieux manipuler l'ensemble des variables*/
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
