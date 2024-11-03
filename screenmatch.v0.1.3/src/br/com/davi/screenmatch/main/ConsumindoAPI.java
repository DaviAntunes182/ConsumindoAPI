package br.com.davi.screenmatch.main;

import br.com.davi.screenmatch.exceptions.ErroConversaoAnoException;
import br.com.davi.screenmatch.models.Filme;
import br.com.davi.screenmatch.models.Obra;
import br.com.davi.screenmatch.models.ObraOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsumindoAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        List<Obra> obras = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while(!busca.equalsIgnoreCase("sair")){

            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do filme");
            String titulo = sc.nextLine();
            busca = titulo;

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            String tituloParan = titulo.trim().replace(" ", "+");

            String uri = "http://www.omdbapi.com/?t=" + tituloParan + "&apikey=c070cbb8";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();


            ObraOMDB obraOMDB = gson.fromJson(json, ObraOMDB.class);
            try {
                Filme meuFilme = new Filme(obraOMDB);
                System.out.println(meuFilme);

                obras.add(meuFilme);
            }catch (NumberFormatException | ErroConversaoAnoException ex) {
                System.out.println("Ocorreu um erro -> " + ex.getMessage());
            }
        }
        System.out.println(obras);
        FileWriter fw = new FileWriter("filmes.json");
        fw.write(gson.toJson(obras));
        fw.close();
    }
}
