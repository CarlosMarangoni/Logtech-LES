package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Veiculo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VeiculoForm {

    @NotEmpty
    private String placa;

    @NotEmpty
    private String chassi;

    @NotEmpty
    private String cor;

    @NotEmpty
    private String modelo;

    @NotNull
    private Double comprimento;

    @NotNull
    private Double largura;

    @NotNull
    private Double altura;

    @NotNull
    private Double volumeMax;

    @NotNull
    private Double capacidadeMax;

    public VeiculoForm() {
    }

    public VeiculoForm(String placa, String chassi, String cor, String modelo, Double comprimento, Double largura, Double altura, Double volumeMax, Double capacidadeMax) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.modelo = modelo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.volumeMax = volumeMax;
        this.capacidadeMax = capacidadeMax;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(Double volumeMax) {
        this.volumeMax = volumeMax;
    }

    public Double getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(Double capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public static VeiculoForm toForm(Veiculo veiculo){
        return new VeiculoForm(
                veiculo.getPlaca(),
                veiculo.getChassi(),
                veiculo.getCor(),
                veiculo.getModelo(),
                veiculo.getComprimento(),
                veiculo.getLargura(),
                veiculo.getAltura(),
                veiculo.getVolumeMax(),
                veiculo.getCapacidadeMax());
    }

}
