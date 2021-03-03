
package com.hibrido.pedidos.ws.models.destino.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "precoUnitario",
    "quantidade",
    "sku",
    "valorTotal"
})
public class Produto {

    @JsonProperty("precoUnitario")
    private Double precoUnitario;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("valorTotal")
    private Double valorTotal;

    @JsonProperty("precoUnitario")
    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    @JsonProperty("precoUnitario")
    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @JsonProperty("quantidade")
    public Integer getQuantidade() {
        return quantidade;
    }

    @JsonProperty("quantidade")
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
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
