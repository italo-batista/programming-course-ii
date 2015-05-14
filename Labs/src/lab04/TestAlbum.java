package lab04;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class TestAlbum {
    
	Album cenaMuda;
	Album medulla;
	
	Musica submarine;
	Musica mouthsCradle;
	Musica oceania;
	Musica demoniaca;
	
	@Before
	public void setUp() throws Exception {
		
		Album cenaMuda = new Album("A cena Muda", "Maria Bethania", 1974);
		Album medulla = new Album("Medulla", "Bjork", 2004);
		
		Musica submarine = new Musica("Submarine", 4, "Indie");
		Musica mouthsCradle = new Musica("Mouths Cradle", 5, "Indie");
		Musica oceania = new Musica("Oceania", 4, "Indie");
		Musica demoniaca = new Musica("Demoniaca", 3, "MPB");
		
	}
	
	
	@Test
	public void testCriaAlbum() {
		
		try {
			System.out.println(cenaMuda.toString() + medulla.toString() + oceania.toString());
			
			Album cantoLivre = new Album("O Canto Livre", "Nara Leao", 1962);
			Assert.assertEquals("O Canto Livre", cantoLivre.getTitulo());
			Assert.assertEquals("Nara Leao", cantoLivre.getArtista());
			Assert.assertEquals(1962, cantoLivre.getAnoLancamento());
			
		} catch (Exception e) {
		}
		
		try {
			Album cantoLivre = new Album("", "Nara Leao", 1962);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel cadastrar album sem titulo.", e.getMessage());
		}
		
		try {
			Album cantoLivre = new Album("O Canto Livre", "", 1962);
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel cadastrar album sem artista.", e.getMessage());
		}

		try {
			Album cantoLivre = new Album("O Canto Livre", "Nara Leao", -24);
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel cadastrar album sem artista.", e.getMessage());
		}

		
	}
	
	@Test
	public void testAddMusica() {
		try {
			cenaMuda.addMusica(demoniaca);
		 	
			Musica ultimaMusica = cenaMuda.getAlbum().get(0);
			Assert.assertEquals(demoniaca, ultimaMusica);
			Assert.assertEquals(3, cenaMuda.getDuracaoTotal());	
			
		} catch (Exception e) {

		}
		
		try {
			medulla.addMusica(oceania);
			medulla.addMusica(submarine);
			medulla.addMusica(mouthsCradle);			
			
			Assert.assertEquals(medulla.getAlbum().get(0).getNome(), "Oceania");
			Assert.assertEquals(medulla.getAlbum().get(1).getNome(), "Submarine");
			Assert.assertEquals(medulla.getAlbum().get(2).getNome(), "Mouths Cradle");
			
		} catch (Exception e) {
		}
	}

	@Test
	public void testAlbunsIguais(){
		try {
			Album cenaMuda = new Album("A cena Muda", "Maria Bethania", 1974);
			Album aCenaMuda = new Album("A cena Muda", "Maria Bethania", 1974);
			
			Assert.assertTrue(cenaMuda.equals(aCenaMuda));
		} catch (Exception e) {
			Assert.fail();
		}	
	}
	
}
