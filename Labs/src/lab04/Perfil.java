package lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Perfil {

	private String usuario;
	private List<Album> seusAlbuns;
	private List<Album> albunsFavoritos;
	private Map<String, Album> suasPlaylists;

	public Perfil(String nomeUsuario) throws Exception {
		this.usuario = nomeUsuario;		
		this.seusAlbuns = new ArrayList<Album>();
		this.albunsFavoritos = new ArrayList<Album>();
		this.suasPlaylists = new HashMap<String, Album>();
	}

	public void adicionaAlbum(Album album) {
			seusAlbuns.add(album);
	}

	public void adicionaAosFavoritos(Album album) {
		albunsFavoritos.add(album);
	}	
	
	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {

		Musica musica = retornaMusica(nomeAlbum, faixa);
		
		if (suasPlaylists.containsKey(nomePlaylist)) {
			Album playlist = suasPlaylists.get(nomePlaylist);
			playlist.addMusica(musica);
		} else {
			Album novaPlaylist = new Album(nomePlaylist, "Varios artistas.", 0);
			novaPlaylist.addMusica(musica);
			suasPlaylists.put(nomePlaylist, novaPlaylist);
		}
		
	}
	
	public Album retornaAlbum(String nomeAlbum) throws Exception {
		
		Iterator<Album> iterator = this.seusAlbuns.iterator();
		while (iterator.hasNext()) {
			
			Album albumRetornado = iterator.next();
			if (albumRetornado.getTitulo().equals(nomeAlbum)) {
				return albumRetornado;
			}
		
		}
		
		throw new Exception("Album não pertence ao Perfil especificado.");
			
	}
	
	public Musica retornaMusica (String nomeAlbum, int faixa) throws Exception {
		Musica musica = retornaAlbum(nomeAlbum).getAlbum().get(faixa); 
		return musica;
	}
	
	public List<Album> getSeusAlbuns() {
		return this.seusAlbuns;
	}
	
	public List<Album> getAlbunsFavoritos() {
		return this.albunsFavoritos;
	}
	
	public Map<String, Album> getSuasPlaylist() {
		return this.suasPlaylists;
	}
	
}