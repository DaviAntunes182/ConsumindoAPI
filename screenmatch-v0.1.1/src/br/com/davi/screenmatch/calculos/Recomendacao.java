package br.com.davi.screenmatch.calculos;

public class Recomendacao {

    public void filtrar(Classificavel c){
        if(c.getClassificacao() >= 9) {
            System.out.println("Em alta");
        } else if (c.getClassificacao() >= 7) {
            System.out.println("É uma boa obra");
        } else {
            System.out.println("É uma obra duvidosa");
        }
    }
}
