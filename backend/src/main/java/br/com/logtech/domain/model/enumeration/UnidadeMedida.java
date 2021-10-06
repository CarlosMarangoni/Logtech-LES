package br.com.logtech.domain.model.enumeration;

import java.util.Arrays;
import java.util.Locale;

public enum UnidadeMedida {

    UNIDADE("unidade"),
    KG("kg");

    private String message;

    UnidadeMedida(String message) {
    this.message=message;
    }

}
