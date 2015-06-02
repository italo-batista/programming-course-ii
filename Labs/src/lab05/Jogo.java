package lab05;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

	private String nome;
	private double preco;
	private double maiorScore;
	private int vezesJogada;
	private int vezesZerada;
	private List jogabadilidades; 
	
	
	public Jogo(String nome, double preco) throws Exception {
		
		if (nome == null || nome.equals("")) {
			throw new Exception("O nome de um jogo não pode ser vazio.");
		} else {
			this.nome = nome;
		}
		
		this.preco = preco;
		this.maiorScore = 0.0;
		this.vezesJogada = 0;
		this.vezesZerada = 0;
		
		// Falta tratar o uso de Jogabilidades //
		this.jogabadilidades = new <Jogabilidade> ArrayList(); 
	}

	
	public void joga(int score, boolean zerou) {
		if (score > getMaiorScore()) {
			setMaiorScore(score);
		}
		if (zerou == true) {
			setVezesZerada( getVezesZerada() + 1 );
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Jogo){
		
			Jogo outroJogo = (Jogo) obj; 
			if (this.nome.equals(outroJogo.nome)
				&& this.preco == outroJogo.preco){
				return true;
			}
		}
		
		return false;
	}
	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public double getPreco() {
		return preco;
	}
	

	public void setPreco(double preco) {
		this.preco = preco;
	}

	
	public double getMaiorScore() {
		return maiorScore;
	}

	
	public void setMaiorScore(double maiorScore) {
		this.maiorScore = maiorScore;
	}

	
	public int getVezesJogada() {
		return vezesJogada;
	}


	public void setVezesJogada(int vezesJogada) {
		this.vezesJogada = vezesJogada;
	}


	public int getVezesZerada() {
		return vezesZerada;
	}


	public void setVezesZerada(int vezesZerada) {
		this.vezesZerada = vezesZerada;
	}
	
	public List getJogabadilidades() {
		return jogabadilidades;
	}

	public void setJogabadilidades(List jogabadilidades) {
		this.jogabadilidades = jogabadilidades;
	}

	enum Jogabilidade {
		ONLINE, OFFLINE, MULTIPLAYER, COOPERATIVO, COMPETITIVO
	}
}