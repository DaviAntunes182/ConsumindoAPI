package br.com.davi.screenmatch.models;

//É uma nova estrutura especial do java que permite representar uma classe
//imutável, contendo apenas atributos construtores e metodos de leitura
//encaixa-se perfeitamente quando queremos representar dados sem comportamento

public record ObraOMDB(String title, String year, String runtime) {
}
