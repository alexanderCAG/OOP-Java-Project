
package Model;

/*Cette classe est utilisé pour la création d'un nouveau compte*/
public class Person {
    protected int id;
    protected String lastname;
    protected String firstname;
    protected String email;
    protected String motdepasse;
    protected String phone;
    
    /*Constructeur*/
    public Person(int id, String lastname, String firstname, String email, String motdepasse, String phone){
        this.id=id;
        this.lastname=lastname;
        this.firstname=firstname;
        this.email=email;
        this.email=email;
        this.motdepasse=motdepasse;
        this.phone=phone;
    }
    
}
