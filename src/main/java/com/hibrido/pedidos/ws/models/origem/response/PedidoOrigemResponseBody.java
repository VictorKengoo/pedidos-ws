
package com.hibrido.pedidos.ws.models.origem.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cliente",
    "data",
    "hora",
    "itens",
    "numero",
    "representante",
    "valorDesconto",
    "valorFrete"
})
public class PedidoOrigemResponseBody {

    @JsonProperty("cliente")
    private Cliente cliente;
    @JsonProperty("data")
    private String data;
    @JsonProperty("hora")
    private String hora;
    @JsonProperty("itens")
    private List<Iten> itens = null;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("representante")
    private Representante representante;
    @JsonProperty("valorDesconto")
    private Double valorDesconto;
    @JsonProperty("valorFrete")
    private Double valorFrete;

    @JsonProperty("cliente")
    public Cliente getCliente() {
        return cliente;
    }

    @JsonProperty("cliente")
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    @JsonProperty("hora")
    public String getHora() {
        return hora;
    }

    @JsonProperty("hora")
    public void setHora(String hora) {
        this.hora = hora;
    }

    @JsonProperty("itens")
    public List<Iten> getItens() {
        return itens;
    }

    @JsonProperty("itens")
    public void setItens(List<Iten> itens) {
        this.itens = itens;
    }

    @JsonProperty("numero")
    public String getNumero() {
        return numero;
    }

    @JsonProperty("numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @JsonProperty("representante")
    public Representante getRepresentante() {
        return representante;
    }

    @JsonProperty("representante")
    public void setRepresentante(Representante representante) {
        this.representante = representante;
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

}
