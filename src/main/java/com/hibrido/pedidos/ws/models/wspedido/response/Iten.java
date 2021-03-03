
package com.hibrido.pedidos.ws.models.wspedido.response;

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
    private Integer preco;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("valorTotal")
    private Integer valorTotal;

    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonProperty("preco")
    public Integer getPreco() {
        return preco;
    }

    @JsonProperty("preco")
    public void setPreco(Integer preco) {
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
    public Integer getValorTotal() {
        return valorTotal;
    }

    @JsonProperty("valorTotal")
    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

}
