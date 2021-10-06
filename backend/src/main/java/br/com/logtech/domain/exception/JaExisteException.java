package br.com.logtech.domain.exception;

public class JaExisteException extends RuntimeException {


    private String message;

    public JaExisteException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
