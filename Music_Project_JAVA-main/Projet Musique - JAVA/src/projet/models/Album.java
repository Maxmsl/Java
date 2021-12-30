package projet.models;

import java.time.LocalDate;

public class Album {
    private String nom;
    private String titres;
    private LocalDate dateDeSortie;
    private String genre;
    private int nombreDeVentes;
    private String certification;

    public Album(String nom, String titres, LocalDate dateDeSortie, String genre, int nombreDeVentes, String certification) {
        this.nom = nom;
        this.titres = titres;
        this.dateDeSortie = dateDeSortie;
        this.genre = genre;
        this.nombreDeVentes = nombreDeVentes;
        this.certification = certification;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitres() {
        return titres;
    }

    public void setTitres(String titres) {
        this.titres = titres;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNombreDeVentes() {
        return nombreDeVentes;
    }

    public void setNombreDeVentes(int nombreDeVentes) {
        this.nombreDeVentes = nombreDeVentes;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}
