package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String nome;
	public String endereco;
	public String telefone;
	public String pedido;
	public boolean isEntregue;
}
