package br.com.davi.screenmatch.models;

import br.com.davi.screenmatch.calculos.Classificavel;

public class Episode implements Classificavel {
    private int number;
    private String name;
    private Serie serie;
    private int views;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public double getClassificacao() {
        if(getViews() <= 1000){
            return 3;
        }else if(getViews() <= 5000){
            return 6;
        } else if (getViews() <= 9999) {
            return 9;
        }else{
            return 10;
        }
    }
}
