package br.com.alura.estoquews.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import br.com.alura.estoquews.dao.ItemDao;
import br.com.alura.estoquews.domain.Item;
import br.com.alura.estoquews.util.Filtro;
import br.com.alura.estoquews.util.Filtros;
import br.com.alura.estoquews.util.ListaItem;

@WebService
public class EstoqueWS {
	
	ItemDao dao = new ItemDao();
	
	
	@WebMethod(operationName="todosOsItens") //nome do método na camada SOAP
	@WebResult(name="item")					 //nome do elemento que retorna o objeto ex: <item> objeto </item>
	@ResponseWrapper(localName = "itens")	 //cria um "embrulhe" ex: <ns2:itens xmlns> <item>..</item> </itens> </ns2...>
	public List<Item> getItens(){
		return dao.todosItens();
	}
	
	/* 
	 conforme utilizado o método acima, ele irá retornar um <item> pra cada objeto
	 ficando sem um atributo pai. Ex: <itens>  <item>...</item> <item>...</item> </itens>
	 para criar um atributo pai e retornar os objetos dentro dele, foi necessário
	 criar uma classe auxiliar ListaItem
	 o método abaixo é um WebResult itens que chama esta classe
	 o XMLAccessorType acessa diretamente o FIELD e retorna os elementos da lista
	 com <item> conforme mapeado na classe. */
	
	@WebMethod(operationName="todosOsItens2")
	@WebResult(name="itens")					 //nome do elemento que retorna o objeto ex: <itens> objeto </itens>
	public ListaItem getItens2(){
		return new ListaItem(dao.todosItens());
	}
	
	public String getGreeting() {
		return "Hello! This is my first WS.";
	}
	
	//Métodos utilizando filtros e parâmetros
	@WebMethod(operationName="todosOsItensFiltered")
    @WebResult(name="itens")
    public ListaItem getItensFiltered(@WebParam(name="filtros") Filtros filtros) { //cuidado, plural
        System.out.println("Chamando getItens()");
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return new ListaItem(itensResultado);
    }
}
