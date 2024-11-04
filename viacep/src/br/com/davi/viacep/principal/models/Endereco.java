package br.com.davi.viacep.principal.models;

public record Endereco(String cep,
                       String logradouro,
                       String complemento,
                       String localidade,
                       String uf) {
}
