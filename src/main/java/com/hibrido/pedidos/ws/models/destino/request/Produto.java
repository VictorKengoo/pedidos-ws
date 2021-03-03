
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
    private Integer precoUnitario;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("valorTotal")
    private Integer valorTotal;

    @JsonProperty("precoUnitario")
    public Integer getPrecoUnitario() {
        return precoUnitario;
    }

    @JsonProperty("precoUnitario")
    public void setPrecoUnitario(Integer precoUnitario) {
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
    public Integer getValorTotal() {
        return valorTotal;
    }

    @JsonProperty("valorTotal")
    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

}
