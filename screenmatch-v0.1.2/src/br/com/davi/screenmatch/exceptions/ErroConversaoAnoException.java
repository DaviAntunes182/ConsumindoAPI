package br.com.davi.screenmatch.exceptions;

public class ErroConversaoAnoException extends RuntimeException {
    private String msg;
    public ErroConversaoAnoException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
