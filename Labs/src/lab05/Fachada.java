package lab05;

import java.util.HashSet;
import java.util.List;

import lab05.Usuario.tipoUsuario;



public class Fachada {
	
	private List usuarios;
	
	
	public void vendeJogo(Usuario usuario, Jogo jogo) throws Exception {
	
		double jogoPreco = jogo.getPreco();
		
		if (jogoPreco > usuario.getDinheiro()) {
			throw new Exception("Voce nao tem saldo suficiente");
		} else {
			Jogo copiaDoUsuario = copia(jogo);
			usuario.compraJogo(copiaDoUsuario);
		}
	}
		
	
	public Jogo copia(Jogo jogo) throws Exception{
		
		Jogo copiaDeJogo;
		
		String copiaNome = jogo.getNome();
		double copiaPreco = jogo.getPreco();
		HashSet copiaJogabilidades = jogo.getJogabilidades();
		
		copiaDeJogo = new Jogo(copiaNome, copiaPreco, copiaJogabilidades);
		return copiaDeJogo;
	}
	
}
