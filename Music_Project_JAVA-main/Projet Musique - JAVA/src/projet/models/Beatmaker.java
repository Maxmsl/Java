package projet.models;

public class Beatmaker {
    private String prenom;
    private String nom;
    private String pseudo;
    private int age;

    public Beatmaker(String prenom, String nom, String pseudo, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
