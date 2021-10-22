package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Romaneio;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RomaneioOutput {

    private OffsetDateTime dataCriacao;

    private String nomeMotorista;

    private String modeloVeiculo;

    private String latitudePartida;

    private String longitudePartida;

    private List<EntregaOutput> notas;

    public RomaneioOutput(OffsetDateTime dataCriacao, String nomeMotorista, String modeloVeiculo, String latitudePartida, String longitudePartida, List<EntregaOutput> notas) {
        this.dataCriacao = dataCriacao;
        this.nomeMotorista = nomeMotorista;
        this.modeloVeiculo = modeloVeiculo;
        this.latitudePartida = latitudePartida;
        this.longitudePartida = longitudePartida;
        this.notas = notas;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
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

    public List<EntregaOutput> getNotas() {
        return notas;
    }

    public void setNotas(List<EntregaOutput> notas) {
        this.notas = notas;
    }

    public static RomaneioOutput toOutput(Romaneio romaneio) {
        return new RomaneioOutput(
                romaneio.getDataCriacao(),
                romaneio.getMotorista().getNome(),
                romaneio.getVeiculo().getModelo(),
                romaneio.getLatitudePartida(),
                romaneio.getLongitudePartida(),
                romaneio.getNotas().stream().map(EntregaOutput::toOutput).collect(Collectors.toList()));
    }
}
