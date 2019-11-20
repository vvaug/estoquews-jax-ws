package br.com.alura.estoquews.application;

import javax.xml.ws.Endpoint;

import br.com.alura.estoquews.service.EstoqueWS;

public class PublishWS {

	//como ainda o servi�o n�o possui um server, publicarei o servi�o programaticamente.
	
	public static void main(String[] args) {
		
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews"; //?WSDL
		
		System.out.println("Servi�o Online: " + URL);
		
		//associando URL com implementa��o
		
		Endpoint.publish(URL, implementacaoWS);
	
	}

}
