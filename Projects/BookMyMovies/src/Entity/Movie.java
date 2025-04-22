package Entity;

public class Movie {

    private int movieId;

    private String title;

    private String genere;

    private String lang;

    private int duration;

    public Movie(int movieId, String title, String genere, String lang, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.genere = genere;
        this.lang = lang;
        this.duration = duration;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenere() {
        return genere;
    }

    public String getLang() {
        return lang;
    }

    public int getDuration() {
        return duration;
    }
}
