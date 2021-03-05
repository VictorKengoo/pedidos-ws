package com.hibrido.pedidos.ws.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hibrido.pedidos.ws.models.destino.request.PedidoDestinoRequestBody;
import com.hibrido.pedidos.ws.models.origem.response.PedidoOrigemResponseBody;
import com.hibrido.pedidos.ws.operation.builder.DestinoBuilder;

public class PedidoOperation {

	public static String call(String URL_ORIGEM, String URL_DESTINO, RestTemplate restTemplate, DestinoBuilder destinoBuilder) {			
		// fetch from "http://origem.demacode.com.br:8181/WS/Pedido"
		PedidoOrigemResponseBody[] origemResponse = restTemplate.getForObject(URL_ORIGEM, PedidoOrigemResponseBody[].class);
		
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		List<PedidoOrigemResponseBody> origemResponseList = new ArrayList<>();
		if(origemResponse != null) {
			origemResponseList = Arrays.asList(origemResponse);			
		
			List<PedidoDestinoRequestBody> destinoRequestBody = destinoBuilder.buildRequest(origemResponseList);
			
			for(PedidoDestinoRequestBody item : destinoRequestBody) {
				// insert into "http://destino.demacode.com.br:8282/v1/pedido"
				response = restTemplate.postForEntity(URL_DESTINO, item , Void.class);			
			}
		}		
		return "WS realizou a requisição POST e retornou código HTTP: " + response.getStatusCode().toString();
	}
}