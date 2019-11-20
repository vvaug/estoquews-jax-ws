package br.com.alura.estoquews.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.estoquews.domain.Item;

public class ItemDao {

	private static Map<String, Item> ITENS = new HashMap();
	
	public ItemDao() {
		
		//gera alguns registros
		ITENS.put("ITEN1", new Item("1", "Java SE",  "Book", 10));
		ITENS.put("ITEN2", new Item("2", "Java OCP", "Book", 8));
		ITENS.put("ITEN3", new Item("3", "Java OCA", "Book", 7));
		ITENS.put("ITEN4", new Item("4", "Java OCM", "Book", 9));
		ITENS.put("ITEN5", new Item("5", "Java EXP", "Book", 9));
	}
	
	public List<Item> getItens() {
		return new ArrayList<Item>(ITENS.values());
	}
	
}
