package br.com.logtech.domain.model.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RomaneioForm {

  private Long motoristaId;

  @NotNull
  private Long veiculoId;

  private List<EntregaForm> notas;

    public RomaneioForm() {
    }

    public RomaneioForm(Long motoristaId, Long veiculoId, List<EntregaForm> notas) {
        this.motoristaId = motoristaId;
        this.veiculoId = veiculoId;
        this.notas = notas;
    }

    public Long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Long motoristaId) {
        this.motoristaId = motoristaId;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public List<EntregaForm> getNotas() {
        return notas;
    }

    public void setNotas(List<EntregaForm> notas) {
        this.notas = notas;
    }
}
