package br.com.davi.screenmatch.models;

import br.com.davi.screenmatch.calculos.Classificavel;

public class Filme extends Obra implements Classificavel {
    private String director;
    private int duration;

    //public Filme(){}

    public Filme(String title, int year, int duration){
        super(title, year);
        this.setDuration(duration);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        super.avaliacao();
        return  String.format(
                """
                   Filme:      %s (%d)
                   Duração:    %d minutos
                   Avaliações: %d
                   Estrelas:   %.1f""", getTitle(), getYear(), getDuration(), getTotalRatings(), getStars());
    }

    @Override
    public double getClassificacao() {
        return getStars() * 2;
    }

}
