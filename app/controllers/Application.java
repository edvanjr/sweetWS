package controllers;

import java.util.List;

import models.Pedido;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
    public static Result salvarPedido(String nome, String endereco, String telefone, String pedido) {
    	
    	Pedido pedidoCliente = new Pedido();
    	pedidoCliente.nome = nome;
    	pedidoCliente.endereco = endereco;
    	pedidoCliente.telefone = telefone;
    	pedidoCliente.pedido = pedido;
    	pedidoCliente.isEntregue = false;
    	
    	JPA.em().persist(pedidoCliente);
    	
        return ok(Json.toJson("ok"));
    }
    
    @Transactional
    public static Result listarPedidos(String nome, String endereco, String telefone, String pedido) {
    	
    	List<Pedido> pedidos = JPA.em().createQuery("FROM Pedido").getResultList();
    	
        return ok(Json.toJson(pedidos));
    }
  
}
