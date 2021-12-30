package projet.models;

public class Label {
    private String nom;
    private String artistes; // List<Book> bookList = new ArrayList<Book>(); pour faire une vraie liste
    private String fondateur;

    public Label(String nom, String artistes, String fondateur) {
        this.nom = nom;
        this.artistes = artistes;
        this.fondateur = fondateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getArtistes() {
        return artistes;
    }

    public void setArtistes(String artistes) {
        this.artistes = artistes;
    }

    public String getFondateur() {
        return fondateur;
    }

    public void setFondateur(String fondateur) {
        this.fondateur = fondateur;
    }
}
