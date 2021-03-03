
package com.hibrido.pedidos.ws.models.origem.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codigo",
    "preco",
    "quantidade",
    "valorTotal"
})
public class Iten {

    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("preco")
    private Double preco;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("valorTotal")
    private Double valorTotal;

    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonProperty("preco")
    public Double getPreco() {
        return preco;
    }

    @JsonProperty("preco")
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @JsonProperty("quantidade")
    public Integer getQuantidade() {
        return quantidade;
    }

    @JsonProperty("quantidade")
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
