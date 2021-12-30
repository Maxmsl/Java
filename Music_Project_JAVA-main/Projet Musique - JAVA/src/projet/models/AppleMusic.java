package projet.models;

public class AppleMusic extends Plateforme{
    private int nombreUtilisateurs;
    private double prixAbonnement;


    public AppleMusic(int nombreUtilisateurs, double prixAbonnement) {
        this.nombreUtilisateurs = nombreUtilisateurs;
        this.prixAbonnement = prixAbonnement;
    }

    public int getNombreUtilisateurs() {
        return nombreUtilisateurs;
    }
    public void setNombreUtilisateurs(int nombreUtilisateurs) {
        this.nombreUtilisateurs = nombreUtilisateurs;
    }

    public double getPrixAbonnement() {
        return prixAbonnement;
    }

    public void setPrixAbonnement(double prixAbonnement) {
        this.prixAbonnement = prixAbonnement;
    }



}
