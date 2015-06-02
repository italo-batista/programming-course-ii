package lab05;

import java.util.List;

import lab05.Usuario.tipoUsuario;

public class Fachada {
	
	private List usuarios;
	
	
	public void vendeJogo(Usuario usuario, Jogo jogo) throws Exception {
	
		double valorCompra = calculaBeneficio(usuario, jogo.getPreco());
		
		if (valorCompra > usuario.getDinheiro()) {
			throw new Exception("Voce nao tem saldo suficiente");
		} else {
			Jogo copiaDoUsuario = copia(jogo);
			usuario.compraJogo(copiaDoUsuario, valorCompra);
		}
	}
		
	public double calculaBeneficio(Usuario usuario, double jogoPreco){
		double valorCompra;
			if (usuario.getTipo().equals(tipoUsuario.Veterano)) {
				valorCompra = jogoPreco * (1 - 0.2);
			} else {
				valorCompra = jogoPreco * (1 - 0.1);
			}
		
		return valorCompra;
	}
	
	public Jogo copia(Jogo jogo) throws Exception{
		
		Jogo copiaDeJogo;
		
		String copiaNome = jogo.getNome();
		double copiaPreco = jogo.getPreco();
		List copiaJogabilidades = jogo.getJogabadilidades();
		
		copiaDeJogo = new Jogo(copiaNome, copiaPreco);
		return copiaDeJogo;
	}
	
}