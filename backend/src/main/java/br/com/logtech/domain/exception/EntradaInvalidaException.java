package br.com.logtech.domain.exception;

public class EntradaInvalidaException extends RuntimeException {

    private String message;

    public EntradaInvalidaException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
