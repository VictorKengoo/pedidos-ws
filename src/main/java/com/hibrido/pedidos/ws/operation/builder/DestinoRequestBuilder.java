package com.hibrido.pedidos.ws.operation.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hibrido.pedidos.ws.models.v1pedido.request.EnderecoEntrega;
import com.hibrido.pedidos.ws.models.v1pedido.request.PedidoRequestBody;
import com.hibrido.pedidos.ws.models.v1pedido.request.Produto;
import com.hibrido.pedidos.ws.models.wspedido.response.Endereco;
import com.hibrido.pedidos.ws.models.wspedido.response.Iten;
import com.hibrido.pedidos.ws.models.wspedido.response.PedidoResponseBody;

@Component
public class DestinoRequestBuilder {
	public List<PedidoRequestBody> buildRequest(List<PedidoResponseBody> pedidoResponse) {
		Integer valorTotal = 0;
		
		PedidoRequestBody requestBody = new PedidoRequestBody();
		List<PedidoRequestBody> request = new ArrayList<>();
		
		if (!pedidoResponse.equals(null)) {
			for(PedidoResponseBody item : pedidoResponse) {
				List<Iten> itensList = item.getItens();
				if(itensList != null && !itensList.isEmpty()) {					
					for(Iten iten : itensList) {
						valorTotal += iten.getValorTotal();
					}
					requestBody.setValorTotal(valorTotal);
					requestBody.setCpfCnpjCliente(item.getCliente().getCpfCnpj());
					requestBody.setCpfCnpjRepresentante(item.getRepresentante().getCpfCnpj());
					requestBody.setEnderecoEntrega(buildEnderecoEntrega(item.getCliente().getEndereco()));
					requestBody.setNumero(item.getNumero());
					requestBody.setProdutos(buildProducts(item.getItens()));
					requestBody.setValorDesconto(item.getValorDesconto());
					requestBody.setValorFrete(item.getValorFrete());
					
					request.add(requestBody);
				}
			}
		}		
		return request;
	}

	private List<Produto> buildProducts(List<Iten> itens) {
		List<Produto> produtos = new ArrayList<>();
		Produto produto = new Produto();

		if(itens != null && !itens.isEmpty()) {			
			for(Iten item : itens) {
				produto.setPrecoUnitario(item.getPreco());
				produto.setQuantidade(item.getQuantidade());
				produto.setSku(item.getCodigo());
				produto.setValorTotal(item.getValorTotal());
			}
		}		
		produtos.add(produto);
		
		return produtos;
	}

	private EnderecoEntrega buildEnderecoEntrega(Endereco endereco) {
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		if(!endereco.equals(null)) {
			enderecoEntrega.setBairro(endereco.getBairro());
			enderecoEntrega.setCidade(endereco.getCidade());
			enderecoEntrega.setComplemento(endereco.getComplemento());
			enderecoEntrega.setLogradouro(endereco.getRua());
			enderecoEntrega.setNumero(endereco.getNumero());
			enderecoEntrega.setPais(endereco.getPais());
			enderecoEntrega.setUf(endereco.getUf());	
		}
		return enderecoEntrega;
	}
}
