package br.com.davi.screenmatch.main;

import br.com.davi.screenmatch.models.Filme;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Filme f1 = new Filme("Poderoso Chefão", 1970, 180);
        f1.avalia(10);
        f1.avalia(8);
        f1.avalia(5);

        Filme f2 = new Filme("Avatar", 2023, 200);
        f2.avalia(9);
        f2.avalia(8);
        f2.avalia(9);


        var f3 = new Filme("Dogville", 2003, 180);
        f3.avalia(10);
        f3.avalia(8);
        f3.avalia(6);

//        Serie s1 = new Serie();
//        s1.setTitle("Lost");
//        s1.setYear(2000);
//        s1.setSeasons(10);
//        s1.setEpisodes(121);
//        s1.setDurationAvg(45);
//        s1.avalia(3);
//        s1.avalia(4);
//        s1.avalia(6);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(f1);
        listaDeFilmes.add(f2);
        listaDeFilmes.add(f3);

        System.out.println(listaDeFilmes.size());
        System.out.printf("""
                Primeiro filme: %s
                """, listaDeFilmes.get(0).getTitle());
        //toString de arraylist -> ToString de cada um dentro do for
        System.out.println(listaDeFilmes);
        for(Filme f : listaDeFilmes){
            System.out.println(f);
        }

//        listaDeFilmes.forEach(System.out::println);

//        Episode ep1 = new Episode();
//        ep1.setNumber(1);
//        ep1.setSerie(s1);
//        ep1.setViews(1000);
//
//        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
//        calculadora.inclui(f1);
//        calculadora.inclui(f2);
//        calculadora.inclui(s1);
//        System.out.println(calculadora.getTempoTotel());
//
//        Recomendacao recomendacao = new Recomendacao();
//        recomendacao.filtrar(f1);
//        recomendacao.filtrar(f2);
//        recomendacao.filtrar(ep1);
    }
}
