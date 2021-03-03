package com.hibrido.pedidos.ws.operation.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibrido.pedidos.ws.models.destino.request.PedidoDestinoRequestBody;
import com.hibrido.pedidos.ws.models.origem.response.PedidoOrigemResponseBody;

class DestinoBuilderTest {

	DestinoBuilder builder = new DestinoBuilder();

	@Test
	void buildRequestSuccess() throws JsonParseException, JsonMappingException, IOException {
		List<PedidoOrigemResponseBody> origemResponseMock = buildPedidoOrigemResponseMock("/origemResponseMockSuccess.json");
		List<PedidoDestinoRequestBody> request = builder.buildRequest(origemResponseMock);
		
		// index = 0
		assertEquals(request.get(0).getCpfCnpjCliente(), origemResponseMock.get(0).getCliente().getCpfCnpj());
		assertEquals(request.get(0).getCpfCnpjRepresentante(), origemResponseMock.get(0).getRepresentante().getCpfCnpj());
		assertEquals(request.get(0).getEnderecoEntrega().getBairro(), origemResponseMock.get(0).getCliente().getEndereco().getBairro());
		assertEquals(request.get(0).getEnderecoEntrega().getCidade(), origemResponseMock.get(0).getCliente().getEndereco().getCidade());
		assertEquals(request.get(0).getEnderecoEntrega().getComplemento(), origemResponseMock.get(0).getCliente().getEndereco().getComplemento());
		assertEquals(request.get(0).getEnderecoEntrega().getLogradouro(), origemResponseMock.get(0).getCliente().getEndereco().getRua());
		assertEquals(request.get(0).getEnderecoEntrega().getNumero(), origemResponseMock.get(0).getCliente().getEndereco().getNumero());
		assertEquals(request.get(0).getEnderecoEntrega().getUf(), origemResponseMock.get(0).getCliente().getEndereco().getUf());
		assertEquals(request.get(0).getNumero(), origemResponseMock.get(0).getNumero());
		assertEquals(request.get(0).getProdutos().get(0).getPrecoUnitario(), origemResponseMock.get(0).getItens().get(0).getPreco());
		assertEquals(request.get(0).getProdutos().get(0).getQuantidade(), origemResponseMock.get(0).getItens().get(0).getQuantidade());
		assertEquals(request.get(0).getProdutos().get(0).getSku(), origemResponseMock.get(0).getItens().get(0).getCodigo());
		assertEquals(request.get(0).getProdutos().get(0).getValorTotal(), origemResponseMock.get(0).getItens().get(0).getValorTotal());
		assertEquals(request.get(0).getProdutos().get(1).getPrecoUnitario(), origemResponseMock.get(0).getItens().get(1).getPreco());
		assertEquals(request.get(0).getProdutos().get(1).getQuantidade(), origemResponseMock.get(0).getItens().get(1).getQuantidade());
		assertEquals(request.get(0).getProdutos().get(1).getSku(), origemResponseMock.get(0).getItens().get(1).getCodigo());
		assertEquals(request.get(0).getProdutos().get(1).getValorTotal(), origemResponseMock.get(0).getItens().get(1).getValorTotal());
		assertEquals(request.get(0).getValorDesconto(), origemResponseMock.get(0).getValorDesconto());
		assertEquals(request.get(0).getValorFrete(), origemResponseMock.get(0).getValorFrete());
		assertEquals(request.get(0).getValorTotal(), 51.55);
		
		// index = 1
		assertEquals(request.get(1).getCpfCnpjCliente(), origemResponseMock.get(1).getCliente().getCpfCnpj());
		assertEquals(request.get(1).getCpfCnpjRepresentante(), origemResponseMock.get(1).getRepresentante().getCpfCnpj());
		assertEquals(request.get(1).getEnderecoEntrega().getBairro(), origemResponseMock.get(1).getCliente().getEndereco().getBairro());
		assertEquals(request.get(1).getEnderecoEntrega().getCidade(), origemResponseMock.get(1).getCliente().getEndereco().getCidade());
		assertEquals(request.get(1).getEnderecoEntrega().getComplemento(), origemResponseMock.get(1).getCliente().getEndereco().getComplemento());
		assertEquals(request.get(1).getEnderecoEntrega().getLogradouro(), origemResponseMock.get(1).getCliente().getEndereco().getRua());
		assertEquals(request.get(1).getEnderecoEntrega().getNumero(), origemResponseMock.get(1).getCliente().getEndereco().getNumero());
		assertEquals(request.get(1).getEnderecoEntrega().getUf(), origemResponseMock.get(1).getCliente().getEndereco().getUf());
		assertEquals(request.get(1).getNumero(), origemResponseMock.get(1).getNumero());
		assertEquals(request.get(1).getProdutos().get(0).getPrecoUnitario(), origemResponseMock.get(1).getItens().get(0).getPreco());
		assertEquals(request.get(1).getProdutos().get(0).getQuantidade(), origemResponseMock.get(1).getItens().get(0).getQuantidade());
		assertEquals(request.get(1).getProdutos().get(0).getSku(), origemResponseMock.get(1).getItens().get(0).getCodigo());
		assertEquals(request.get(1).getProdutos().get(0).getValorTotal(), origemResponseMock.get(1).getItens().get(0).getValorTotal());
		assertEquals(request.get(1).getProdutos().get(1).getPrecoUnitario(), origemResponseMock.get(1).getItens().get(1).getPreco());
		assertEquals(request.get(1).getProdutos().get(1).getQuantidade(), origemResponseMock.get(1).getItens().get(1).getQuantidade());
		assertEquals(request.get(1).getProdutos().get(1).getSku(), origemResponseMock.get(1).getItens().get(1).getCodigo());
		assertEquals(request.get(1).getProdutos().get(1).getValorTotal(), origemResponseMock.get(1).getItens().get(1).getValorTotal());
		assertEquals(request.get(1).getValorDesconto(), origemResponseMock.get(1).getValorDesconto());
		assertEquals(request.get(1).getValorFrete(), origemResponseMock.get(1).getValorFrete());
		assertEquals(request.get(1).getValorTotal(), 99.55);
	}

	private List<PedidoOrigemResponseBody> buildPedidoOrigemResponseMock(String scenario)
			throws JsonParseException, JsonMappingException, IOException {

		InputStream inJson = PedidoOrigemResponseBody[].class.getResourceAsStream(scenario);
		PedidoOrigemResponseBody[] request = new ObjectMapper().readValue(inJson, PedidoOrigemResponseBody[].class);
		List<PedidoOrigemResponseBody> origemResponseList = Arrays.asList(request);

		return origemResponseList;
	}
}
