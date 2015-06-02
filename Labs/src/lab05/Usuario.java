package lab05;

import java.util.List;

public class Usuario {

	private String nome;
	private String login;
	private List jogosComprados;
	private double dinheiro;
	private tipoUsuario tipo;
	
	public Usuario(String nome, String login, List jogosComprados, double dinheiro, tipoUsuario tipo) throws Exception {
		
		if ( (nome == null || login == null) || (nome.equals("") || login.equals("")) ) {
			throw new Exception("Nao foi possivel concluir login.");
		} else {
			this.nome = nome;
			this.login = login;
		}
		
		this.jogosComprados = jogosComprados;
		this.dinheiro = dinheiro;
		this.tipo = tipo;
	}

	public void compraJogo(Jogo jogo, double valorCompra) throws Exception {
		this.dinheiro = this.dinheiro - valorCompra;
		jogosComprados.add(jogo);
	}
	

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List getJogosComprados() {
		return jogosComprados;
	}

	public void setJogosComprados(List jogosComprados) {
		this.jogosComprados = jogosComprados;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public tipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(tipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	enum tipoUsuario {
		Noob, Veterano
	}
}