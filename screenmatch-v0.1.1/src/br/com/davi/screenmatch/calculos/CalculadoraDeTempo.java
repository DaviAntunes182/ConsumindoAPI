package br.com.davi.screenmatch.calculos;

import br.com.davi.screenmatch.models.Filme;
import br.com.davi.screenmatch.models.Obra;
import br.com.davi.screenmatch.models.Serie;

public class CalculadoraDeTempo {
    private int tempoTotel;

    public int getTempoTotel() {
        return tempoTotel;
    }

//    public void inclui(Filme f){
//        tempoTotel += f.getDuration();
//    }
//    public void inclui(Serie s){
//        tempoTotel += s.getDurationFull();
//    }
    public void inclui(Obra o){
        if(o.getClass() == Filme.class){
            tempoTotel += ((Filme) o).getDuration();
        }else{
            tempoTotel += ((Serie) o).getDurationFull();
        }
    }
}
