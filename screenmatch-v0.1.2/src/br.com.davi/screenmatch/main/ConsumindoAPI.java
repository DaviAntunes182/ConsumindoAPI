package br.com.davi.screenmatch.main;

import br.com.davi.screenmatch.models.Filme;
import br.com.davi.screenmatch.models.ObraOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsumindoAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do filme");
        String titulo = sc.nextLine();

        String tituloParan = titulo.trim().replace(" ", "+");

        String uri = "http://www.omdbapi.com/?t=" + tituloParan + "&apikey=c070cbb8";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        ObraOMDB obraOMDB = gson.fromJson(json, ObraOMDB.class);
        Filme meuFilme = new Filme(obraOMDB);
        System.out.println(meuFilme);
    }
}
