package projet.models;

public class Podcast {
    private String createur;
    private String episodes;

    public Podcast(String createur, String episodes) {
        this.createur = createur;
        this.episodes = episodes;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }
}
