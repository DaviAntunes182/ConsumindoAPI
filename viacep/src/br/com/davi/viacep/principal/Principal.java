package br.com.davi.viacep.principal;

import br.com.davi.viacep.principal.models.Endereco;
import br.com.davi.viacep.principal.util.ConsultaCep;
import br.com.davi.viacep.principal.util.GeradorArquivos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var cep = sc.nextLine();
        try {
            ConsultaCep cc = new ConsultaCep();
            Endereco novoEndereco = cc.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorArquivos gerador = new GeradorArquivos();
            gerador.salvaJson(novoEndereco);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }

    }
}
