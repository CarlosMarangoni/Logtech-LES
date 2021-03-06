package br.com.logtech.domain.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<Object> handleNoSuchElementException(PageNotFoundException ex, WebRequest request) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }

    @ExceptionHandler(JaExisteException.class)
    public ResponseEntity<Object> handleJaExisteException(JaExisteException ex, WebRequest request) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        error.setStatus(HttpStatus.CONFLICT.value());

        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);

    }

    @ExceptionHandler(EntradaInvalidaException.class)
    public ResponseEntity<Object> handleEntradaInvalidaException(EntradaInvalidaException ex, WebRequest request) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        String message = "";
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            message += nome + " " + messageSource.getMessage(error, LocaleContextHolder.getLocale()) + System.lineSeparator();
        }

        Error error = new Error();
        error.setStatus(status.value());
        error.setTimestamp(OffsetDateTime.now());
        error.setMessage(message);
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        error.setError(ex.getMessage());

        return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
    }

}
