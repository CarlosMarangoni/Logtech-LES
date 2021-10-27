package br.com.logtech.domain.model;

import br.com.logtech.domain.exception.EntradaInvalidaException;
import br.com.logtech.domain.model.dto.ClienteForm;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String nome;

    @Email
    protected  String email;

    public Cliente() {
    }

    public static Cliente of(Long clienteId) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        return cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Cliente toModel(ClienteForm clienteForm) {
       if(clienteForm.getTipoPessoa().equalsIgnoreCase("FISICA")){
           return new PessoaFisica(
                   clienteForm.getNome(),
                   clienteForm.getDocumento());

       }else{
           if (clienteForm.getTipoPessoa().equalsIgnoreCase("JURIDICA")){
               return new PessoaJuridica(
                       clienteForm.getNome(),
                       clienteForm.getDocumento());
           }
       }
       throw new EntradaInvalidaException("Informe se é pessoa física ou jurídica.");
    }

}
