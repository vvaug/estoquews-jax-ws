package br.com.alura.estoquews.service;

import java.util.List;

import javax.jws.WebService;

import br.com.alura.estoquews.dao.ItemDao;
import br.com.alura.estoquews.domain.Item;

@WebService
public class EstoqueWS {
	
	ItemDao dao = new ItemDao();
	
	public List<Item> getItens(){
		return dao.getItens();
	}
	
	public String getGreeting() {
		return "Hello! This is my first WS.";
	}
	
}
