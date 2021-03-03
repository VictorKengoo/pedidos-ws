package com.hibrido.pedidos.ws.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibrido.pedidos.ws.models.destino.request.PedidoDestinoRequestBody;

class PedidoPostOperationTest {

	private TestRestTemplate restTemplate = new TestRestTemplate();

	private final String URL_DESTINO = "http://destino.demacode.com.br:8282/v1/pedido";

	@Test
	void postOperationSuccess201() throws JsonParseException, RestClientException, JsonMappingException, IOException {
		ResponseEntity<Void> response = restTemplate.postForEntity(URL_DESTINO,
				buildDestinoRequestMock("/destinoRequestMockSuccess.json"), Void.class);
		assertEquals(response.getStatusCodeValue(), 201);
	}

	@Test()
	void postOperationError412() throws JsonParseException, RestClientException, JsonMappingException, IOException {
		ResponseEntity<Void> response = restTemplate.postForEntity(URL_DESTINO,
				buildDestinoRequestMock("/destinoRequestMockError412.json"), Void.class);
		assertEquals(response.getStatusCodeValue(), 412);
	}
	
	private Object buildDestinoRequestMock(String scenario)
			throws JsonParseException, JsonMappingException, IOException {

		InputStream inJson = PedidoDestinoRequestBody.class.getResourceAsStream(scenario);
		Object request = new ObjectMapper().readValue(inJson, Object.class);

		return request;
	}
}