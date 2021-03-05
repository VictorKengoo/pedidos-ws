package com.hibrido.pedidos.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hibrido.pedidos.ws.operation.PedidoOperation;
import com.hibrido.pedidos.ws.operation.builder.DestinoBuilder;

@EnableScheduling
@RestController
public class PedidoController {
	
	private Integer delayCounter = 0;	

	private final String URL_ORIGEM = "http://origem.demacode.com.br:8181/WS/Pedido?data_final=2022-07-20T00:00&data_inicial=2020-07-20T00:00";
	private final String URL_DESTINO = "http://destino.demacode.com.br:8282/v1/pedido";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DestinoBuilder destinoBuilder;
	
	@Scheduled(fixedDelay = 10000)
	@GetMapping("/operation")
	public String operation() {
		if(delayCounter != 0) {
			String result = PedidoOperation.call(URL_ORIGEM, URL_DESTINO, restTemplate, destinoBuilder);
			System.out.println(result);
			return result;
		}
		delayCounter++;
		return null;
	}
}
