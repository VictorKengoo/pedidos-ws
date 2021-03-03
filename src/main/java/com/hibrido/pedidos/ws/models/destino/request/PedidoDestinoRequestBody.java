
package com.hibrido.pedidos.ws.models.destino.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpfCnpjCliente",
    "cpfCnpjRepresentante",
    "enderecoEntrega",
    "numero",
    "produtos",
    "valorDesconto",
    "valorFrete",
    "valorTotal"
})
public class PedidoDestinoRequestBody {

    @JsonProperty("cpfCnpjCliente")
    private String cpfCnpjCliente;
    @JsonProperty("cpfCnpjRepresentante")
    private String cpfCnpjRepresentante;
    @JsonProperty("enderecoEntrega")
    private EnderecoEntrega enderecoEntrega;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("produtos")
    private List<Produto> produtos = null;
    @JsonProperty("valorDesconto")
    private Double valorDesconto;
    @JsonProperty("valorFrete")
    private Double valorFrete;
    @JsonProperty("valorTotal")
    private Double valorTotal;

    @JsonProperty("cpfCnpjCliente")
    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    @JsonProperty("cpfCnpjCliente")
    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    @JsonProperty("cpfCnpjRepresentante")
    public String getCpfCnpjRepresentante() {
        return cpfCnpjRepresentante;
    }

    @JsonProperty("cpfCnpjRepresentante")
    public void setCpfCnpjRepresentante(String cpfCnpjRepresentante) {
        this.cpfCnpjRepresentante = cpfCnpjRepresentante;
    }

    @JsonProperty("enderecoEntrega")
    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    @JsonProperty("enderecoEntrega")
    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    @JsonProperty("numero")
    public String getNumero() {
        return numero;
    }

    @JsonProperty("numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @JsonProperty("produtos")
    public List<Produto> getProdutos() {
        return produtos;
    }

    @JsonProperty("produtos")
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @JsonProperty("valorDesconto")
    public Double getValorDesconto() {
        return valorDesconto;
    }

    @JsonProperty("valorDesconto")
    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @JsonProperty("valorFrete")
    public Double getValorFrete() {
        return valorFrete;
    }

    @JsonProperty("valorFrete")
    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    @JsonProperty("valorTotal")
    public Double getValorTotal() {
        return valorTotal;
    }

    @JsonProperty("valorTotal")
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
