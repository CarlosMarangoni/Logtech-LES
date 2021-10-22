package br.com.logtech.domain.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Romaneio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private OffsetDateTime dataCriacao;

    @ManyToOne
    private Funcionario motorista;

    @ManyToOne
    private Veiculo veiculo;

    private String latitudePartida;

    private String longitudePartida;

    @OneToMany(mappedBy = "entregaPK.romaneio",cascade = CascadeType.MERGE)
    private List<Entrega> notas = new ArrayList<>();

    public Romaneio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Funcionario getMotorista() {
        return motorista;
    }

    public void setMotorista(Funcionario motorista) {
        this.motorista = motorista;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getLatitudePartida() {
        return latitudePartida;
    }

    public void setLatitudePartida(String latitudePartida) {
        this.latitudePartida = latitudePartida;
    }

    public String getLongitudePartida() {
        return longitudePartida;
    }

    public void setLongitudePartida(String longitudePartida) {
        this.longitudePartida = longitudePartida;
    }

    public List<Entrega> getNotas() {
        return notas;
    }

    public void setNotas(List<Entrega> notas) {
        this.notas = notas;
    }
}
