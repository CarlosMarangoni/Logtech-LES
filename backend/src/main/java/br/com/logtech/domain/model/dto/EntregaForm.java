package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Entrega;

import java.time.OffsetDateTime;

public class EntregaForm {

    private Long idNota;

    public EntregaForm() {
    }

    public EntregaForm(Long idNota) {
        this.idNota = idNota;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public static EntregaForm toOutput(Entrega entrega) {
        return new EntregaForm(
                entrega.getEntregaPK().getNota().getId());
    }
}
