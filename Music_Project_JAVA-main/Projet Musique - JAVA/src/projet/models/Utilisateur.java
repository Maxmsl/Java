package projet.models;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String abonnement;
    private int nombreAbonne;

    public Utilisateur(String nom, String prenom, String abonnement, int nombreAbonne) {
        this.nom = nom;
        this.prenom = prenom;
        this.abonnement = abonnement;
        this.nombreAbonne = nombreAbonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(String abonnement) {
        this.abonnement = abonnement;
    }

    public int getNombreAbonne() {
        return nombreAbonne;
    }

    public void setNombreAbonnés(int nombreAbonnés) {
        this.nombreAbonne = nombreAbonne;
    }



}
