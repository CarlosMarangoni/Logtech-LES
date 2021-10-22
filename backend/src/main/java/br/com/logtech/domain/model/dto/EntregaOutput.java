package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Entrega;

import java.time.OffsetDateTime;

public class  EntregaOutput {

    private String numeroNota;

    private Integer sequencia;

    private OffsetDateTime dataChegada;

    private String latitude;

    private String longitude;

    public EntregaOutput(String numeroNota,Integer sequencia, OffsetDateTime dataChegada, String latitude, String longitude) {
        this.numeroNota = numeroNota;
        this.sequencia = sequencia;
        this.dataChegada = dataChegada;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public OffsetDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(OffsetDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public static EntregaOutput toOutput(Entrega entrega) {
        return new EntregaOutput(
                entrega.getEntregaPK().getNota().getNumero(),
                entrega.getSequencia(),
                entrega.getDataChegada(),
                entrega.getLatitude(),
                entrega.getLongitude());
    }
}
