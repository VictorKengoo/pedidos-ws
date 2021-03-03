
package com.hibrido.pedidos.ws.models.origem.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpfCnpj",
    "email",
    "endereco",
    "nome",
    "telefone"
})
public class Representante {

    @JsonProperty("cpfCnpj")
    private String cpfCnpj;
    @JsonProperty("email")
    private String email;
    @JsonProperty("endereco")
    private RepresentanteEndereco endereco;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("cpfCnpj")
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    @JsonProperty("cpfCnpj")
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("endereco")
    public RepresentanteEndereco getEndereco() {
        return endereco;
    }

    @JsonProperty("endereco")
    public void setEndereco(RepresentanteEndereco endereco) {
        this.endereco = endereco;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("telefone")
    public String getTelefone() {
        return telefone;
    }

    @JsonProperty("telefone")
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
