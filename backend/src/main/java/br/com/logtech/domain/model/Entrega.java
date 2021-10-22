package br.com.logtech.domain.model;

import br.com.logtech.domain.model.pk.EntregaPK;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {

    @EmbeddedId
    private EntregaPK entregaPK = new EntregaPK();

    private OffsetDateTime dataChegada;

    private Integer sequencia;

    private String latitude;

    private String longitude;

    public Entrega() {
    }

    public Entrega(EntregaPK entregaPK) {
        this.entregaPK = entregaPK;
    }

    public EntregaPK getEntregaPK() {
        return entregaPK;
    }

    public void setEntregaPK(EntregaPK entregaPK) {
        this.entregaPK = entregaPK;
    }

    public OffsetDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(OffsetDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
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
}
