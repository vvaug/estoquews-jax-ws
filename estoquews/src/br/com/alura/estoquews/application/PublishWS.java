package br.com.alura.estoquews.application;

import javax.xml.ws.Endpoint;

import br.com.alura.estoquews.service.EstoqueWS;

public class PublishWS {

	//como ainda o serviço não possui um server, publicarei o serviço programaticamente.
	
	public static void main(String[] args) {
		
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews"; //?WSDL
		
		System.out.println("Serviço Online: " + URL);
		
		//associando URL com implementação
		
		Endpoint.publish(URL, implementacaoWS);
	
	}

}
