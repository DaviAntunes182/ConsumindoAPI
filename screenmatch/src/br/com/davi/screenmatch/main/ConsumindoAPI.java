package br.com.davi.screenmatch.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsumindoAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Iteratividade com o usuário
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do filme");
        String titulo = sc.nextLine();

//        String[] tituloComp = titulo.split(" ");
        String tituloParan = titulo.trim().replace(" ", "+");

//        for (int i = 0; i < tituloComp.length; i++) {
//            if(i == 0) {
//                tituloParan += tituloComp[i];
//            }else{
//                tituloParan += "+" + tituloComp[i];
//            }
//        }
//
//        System.out.println(tituloParan);
//
//        for(String parte : tituloComp){
//            if(titulo.indexOf(parte) > 0){
//                tituloParan += "+";
//            }
//            tituloParan += parte;
//        }
        String uri = "http://www.omdbapi.com/?t=" + tituloParan + "&apikey=c070cbb8";

        //Faremos uma requesição Http do tipo get
        //Cliente pede o serviço
        HttpClient client = HttpClient.newHttpClient();
        //Criando objetos complexos, que são abstrados
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
