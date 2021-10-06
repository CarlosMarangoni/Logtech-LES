package br.com.logtech.domain.exception;

public class PageNotFoundException extends RuntimeException {

    private String message;

    public PageNotFoundException(String message) {
        this.message = message;
    }

}
