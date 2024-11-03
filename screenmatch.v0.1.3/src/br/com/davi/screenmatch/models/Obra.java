package br.com.davi.screenmatch.models;

import br.com.davi.screenmatch.exceptions.ErroConversaoAnoException;

public abstract class Obra implements Comparable<Obra>{
    private String title;
    private Integer year;
    private boolean noPlano;
    private double stars;
    private double sumRatings;
    private int totalRatings;

    public Obra(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public Obra(ObraOMDB obraOMDB) {
        this.title = obraOMDB.title();
        if(obraOMDB.year().length() > 4){
            throw new ErroConversaoAnoException("Não foi possível converter o ano do objeto passado no construtor");
        }else{
            this.year = Integer.valueOf(obraOMDB.year());
        }
    }

    public void avalia(double nota){
        this.sumRatings += nota;
        this.totalRatings++;
    }
    protected void avaliacao(){
        if(getTotalRatings() >0){
        this.stars = getSumRatings() / getTotalRatings() / 2;
        }else{
            this.stars =0;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isNoPlano() {
        return noPlano;
    }

    public void setNoPlano(boolean noPlano) {
        this.noPlano = noPlano;
    }

    public double getStars() {
        return stars;
    }

    public double getSumRatings() {
        return sumRatings;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    @Override
    public int compareTo(Obra obra) {
        if(this.getClass() == Filme.class && obra.getClass() == Serie.class){
            return -1;
        }else if(this.getClass() == obra.getClass()){
            return this.getTitle().compareTo(obra.getTitle());
        }else {
            return 1;
        }
    }
}
