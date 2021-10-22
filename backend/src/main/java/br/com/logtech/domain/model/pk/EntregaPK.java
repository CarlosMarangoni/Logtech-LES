package br.com.logtech.domain.model.pk;

import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.Romaneio;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EntregaPK implements Serializable {

    @ManyToOne
    private NotaFiscal nota;

    @JsonIgnore
    @ManyToOne
    private Romaneio romaneio;

    public EntregaPK() {
    }

    public EntregaPK(NotaFiscal nota, Romaneio romaneio) {
        this.nota = nota;
        this.romaneio = romaneio;
    }

    public NotaFiscal getNota() {
        return nota;
    }

    public void setNota(NotaFiscal nota) {
        this.nota = nota;
    }

    public Romaneio getRomaneio() {
        return romaneio;
    }

    public void setRomaneio(Romaneio romaneio) {
        this.romaneio = romaneio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntregaPK entregaPK = (EntregaPK) o;
        return nota.equals(entregaPK.nota) && romaneio.equals(entregaPK.romaneio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota, romaneio);
    }
}
