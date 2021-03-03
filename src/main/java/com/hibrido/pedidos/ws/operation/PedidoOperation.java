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

import com.hibrido.pedidos.ws.models.v1pedido.request.PedidoRequestBody;
import com.hibrido.pedidos.ws.models.wspedido.response.PedidoResponseBody;
import com.hibrido.pedidos.ws.operation.builder.DestinoRequestBuilder;

@EnableScheduling
@Component
public class PedidoOperation implements CommandLineRunner {

	private final String URL_ORIGEM = "http://origem.demacode.com.br:8181/WS/Pedido?data_final=2022-07-20T00:00&data_inicial=2020-07-20T00:00";
	private final String URL_DESTINO = "http://destino.demacode.com.br:8282/v1/pedido";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DestinoRequestBuilder responseBuilder;

	@Scheduled(fixedRate = 5000)
	public void call() {		
		// fetch from "http://origem.demacode.com.br:8181/WS/Pedido"
		PedidoResponseBody[] wsPedidoResponse = restTemplate.getForObject(URL_ORIGEM, PedidoResponseBody[].class);
		List<PedidoResponseBody> wsPedidoResponseLsit = new ArrayList<>();
		if(wsPedidoResponse != null) {
			wsPedidoResponseLsit = Arrays.asList(wsPedidoResponse);			
		
			List<PedidoRequestBody> v1PedidoRequestBody = responseBuilder.buildRequest(wsPedidoResponseLsit);
			
			// insert into "http://destino.demacode.com.br:8282/v1/pedido"
			ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
			for(PedidoRequestBody item : v1PedidoRequestBody) {
				response = restTemplate.postForEntity(URL_DESTINO, item , Void.class);			
			}
			System.out.println("WS realizou a requisição e retornou código HTTP: " + response.getStatusCode().toString());
		}
	}

	@Override
	public void run(String... args) throws Exception {
		call();
	}
}
