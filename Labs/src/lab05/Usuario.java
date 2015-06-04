package lab05;

import java.util.List;



public class Usuario {

	private String nome;
	private String login;
	private List jogosComprados;
	private double dinheiro;
	
	public Usuario(String nome, String login, List jogosComprados, double dinheiro) {
		
		this.nome = nome;
		this.login = login;
		this.jogosComprados = jogosComprados;
		this.dinheiro = dinheiro;
	}

	public void compraJogo(Jogo jogo) {
		
		double desconto = calculaDesconto(jogo.getPreco());
		double valorCompra = jogo.getPreco() - desconto;
		this.dinheiro = this.dinheiro - valorCompra;
		jogosComprados.add(jogo);
	}
	
	public double calculaDesconto(double jogoPreco){
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {

			Usuario outroUsuario = (Usuario) obj;
			if (this.login.equals(outroUsuario.login)){
				return true;
			}
		}
		return false;
	}

	// getters and setters
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

}
