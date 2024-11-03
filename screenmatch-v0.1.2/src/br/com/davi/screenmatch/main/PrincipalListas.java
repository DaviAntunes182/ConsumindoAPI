package br.com.davi.screenmatch.main;

import br.com.davi.screenmatch.models.Filme;
import br.com.davi.screenmatch.models.Obra;
import br.com.davi.screenmatch.models.Serie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalListas {
    public static void main(String[] args) {
        Filme f1 = new Filme("Poderoso Chefão", 1970, 180);
        f1.avalia(9);
        Filme f2 = new Filme("Avatar", 2023, 200);
        f2.avalia(6);
        var f3 = new Filme("Dogville", 2003, 180);
        f3.avalia(10);

        Serie lost = new Serie("Lost", 2000);

        List<Obra> lista = new ArrayList<>();
        lista.add(f1);
        lista.add(f2);
        lista.add(f3);
        lista.add(lost);

        for(Obra o: lista){
            System.out.println(o);
            if(o.getClass() == Filme.class) {
                System.out.println(((Filme) o).getDirector() + "\n");
            }else if(o.getClass() == Serie.class){
                System.out.println(((Serie) o).getSeasons() + "\n");
            }
        }

        Collections.sort(lista);
        System.out.println(lista);

        //Ignora os compareTo das classes e faz uma comparação baseada no parâmetro
        lista.sort(Comparator.comparing(Obra::getYear));
        System.out.println(lista);
    }
}
