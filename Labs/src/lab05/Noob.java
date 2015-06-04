package lab05;

import java.util.List;

public class Noob extends Usuario {

	public Noob(String nome, String login, List jogosComprados, double dinheiro){
		super(nome, login, jogosComprados, dinheiro);
	}
	
	public double calculaDesconto(double jogoPreco){
		double valorCompra = jogoPreco * (1 - 0.1);
		return valorCompra;
	}
	
}
