package br.com.davi.screenmatch.models;

public class Serie extends Obra{
    private int seasons;
    private boolean active;
    private int episodes;
    private int durationFull;
    private int durationAvg;

    public Serie(String title, Integer year) {
        super(title, year);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getDurationAvg() {
        return durationAvg;
    }

    public void setDurationAvg(int durationAvg) {
        this.durationAvg = durationAvg;
    }

    public int getDurationFull() {
        setDurationFull();
        return durationFull;
    }

    private void setDurationFull() {
        this.durationFull = getEpisodes() * getDurationAvg();
    }

    @Override
    public String toString() {
        this.avaliacao();
        return  String.format(
                """
                   Serie:      %s
                   Ano:        %d
                   Temporadas: %d
                   Epsodios:   %d
                   Duração:    %d minutos
                   Avaliações: %d
                   Estrelas:   %.1f""", getTitle(), getYear(), getSeasons(), getEpisodes(), getDurationFull(),getTotalRatings(), getStars());
    }

}
