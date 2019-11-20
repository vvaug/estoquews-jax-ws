package br.com.alura.estoquews.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.alura.estoquews.domain.Item;

@XmlRootElement		//JAX-B Annotation
@XmlAccessorType(XmlAccessType.FIELD)	//Acessar pelo campo, não via get/set ( que é o default )
public class ListaItem {

	@XmlElement(name="item")
	private List<Item> itens;
	
	public ListaItem(List<Item> lista){
		this.itens = lista;
	}
	
	public ListaItem() {
		
	}
	
	public List<Item> getItens(){
		return itens;
	}
	
}
