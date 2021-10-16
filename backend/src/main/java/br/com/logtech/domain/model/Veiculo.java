package br.com.logtech.domain.model;

import br.com.logtech.domain.model.dto.VeiculoForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private String modelo;

    private String renavam;

    private Double comprimento;

    private Double largura;

    private Double altura;

    private Double volumeMax;

    private Double capacidadeMax;

    private Boolean disponivel;

    public Veiculo() {
    }

    public Veiculo(String placa, String chassi, String cor, String modelo,String renavam, Double comprimento, Double largura, Double altura, Double volumeMax, Double capacidadeMax, Boolean isDisponivel) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.modelo = modelo;
        this.renavam = renavam;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.volumeMax = volumeMax;
        this.capacidadeMax = capacidadeMax;
        this.disponivel = Boolean.TRUE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
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


    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public static Veiculo toModel(VeiculoForm veiculoForm) {
        return new Veiculo(veiculoForm.getPlaca(),
                veiculoForm.getChassi(),
                veiculoForm.getCor(),
                veiculoForm.getModelo(),
                veiculoForm.getRenavam(),
                veiculoForm.getComprimento(),
                veiculoForm.getLargura(),
                veiculoForm.getAltura(),
                veiculoForm.getVolumeMax(),
                veiculoForm.getCapacidadeMax(),
                Boolean.TRUE);
    }
}
