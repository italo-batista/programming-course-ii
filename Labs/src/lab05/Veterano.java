package lab05;

import java.util.List;

public class Veterano extends Usuario {

	public Veterano(String nome, String login, List jogosComprados, double dinheiro){
		super(nome, login, jogosComprados, dinheiro);
	}
	
	public double calculaDesconto(double jogoPreco){
		double valorCompra = jogoPreco * (1 - 0.2);
		return valorCompra;
	}
}
