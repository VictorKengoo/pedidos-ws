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

@EnableScheduling
@Component
public class PedidoOperation implements CommandLineRunner {

	private final String URL_ORIGEM = "http://origem.demacode.com.br:8181/WS/Pedido?data_final=2022-07-20T00:00&data_inicial=2020-07-20T00:00";
	private final String URL_DESTINO = "http://destino.demacode.com.br:8282/v1/pedido";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DestinoBuilder destinoBuilder;

	@Scheduled(fixedRate = 5000)
	public void call() {		
		// fetch from "http://origem.demacode.com.br:8181/WS/Pedido"
		PedidoOrigemResponseBody[] origemResponse = restTemplate.getForObject(URL_ORIGEM, PedidoOrigemResponseBody[].class);
		
		List<PedidoOrigemResponseBody> origemResponseList = new ArrayList<>();
		if(origemResponse != null) {
			origemResponseList = Arrays.asList(origemResponse);			
		
			List<PedidoDestinoRequestBody> destinoRequestBody = destinoBuilder.buildRequest(origemResponseList);
			
			// insert into "http://destino.demacode.com.br:8282/v1/pedido"
			ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
			for(PedidoDestinoRequestBody item : destinoRequestBody) {
				response = restTemplate.postForEntity(URL_DESTINO, item , Void.class);			
			}
			System.out.println("WS realizou a requisição POST e retornou código HTTP: " + response.getStatusCode().toString());
		}
	}

	@Override
	public void run(String... args) throws Exception {
		call();
	}
}
