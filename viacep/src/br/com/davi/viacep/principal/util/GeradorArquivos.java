package br.com.davi.viacep.principal.util;

import br.com.davi.viacep.principal.models.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivos {
    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(endereco.cep() + ".json");
        fw.write(gson.toJson(endereco));
        fw.close();
    }
}
