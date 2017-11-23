/*Aluno: Adenou Dantas de Farias Júnior*/
/*Aluno 2: Joyce Mikaella das Mercês Aciole*/

package projeto;

/**
 * Classe de testes da classe CD.
 * @author Adenou
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestaCD {
    
 CD cd = null;
	int NUMERO_DE_MUSICAS_CD = 12;
	String[] colecaoDeMusicas = {"Piano Bar", "Refrão de Bolero", "Pra Ser Sincero", "Dom Quixote", "3x4", 
	"Somos Quem Podemos Ser", "Infinita Highway", "Eu Que Não Amo Você", "Perfeita Simetria", "Até o Fim",
	"Terra de Gigantes", "O Papa É Pop", "Pose"}; //array com 13 músicas
	
	@Before
	public void criaCD() throws Exception {
		cd = new CD("Piano Bar", "Engenheiros do Hawaii", NUMERO_DE_MUSICAS_CD); //instâcia um objeto CD
	}
	
	@Test
	public void testaCriacao() {
		//tenta criar um CD passando null como argumento para o parâmetro título
		try {
			cd = new CD(null, "Meteora");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um título.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o parâmetro título
		try {
			cd = new CD("   ", "Xero");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um título.", e.getMessage());
		}
		//tenta criar um CD passando null como argumento para o parâmetro artista
		try {
			cd = new CD("Meteora", null);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o parâmetro artista
		try {
			cd = new CD("Meteora", "   ");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando um valor negativo como argumento para o parâmetro quantMusicas
		try {
			cd = new CD("Meteora", "Xero", -2);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O álbum não pode ser vazio.", e.getMessage());
		}
		//tenta criar um CD passando zero como argumento para o parâmetro quantMusicas
		try {
			cd = new CD("Meteora", "Xero", 0);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O álbum não pode ser vazio.", e.getMessage());
		}
	}
	
	@Test
	public void testaEstadoInicial() {
		assertEquals("Piano Bar", cd.getArtista()); //confere se o artista foi "setado" corretamente
		assertEquals("Numb", cd.getTitulo()); //confere se o titulo do CD foi "setado" corretamente
		assertEquals(null, cd.getFaixaPrincipal()); //retorna null já que ainda não foi atribuído nenhuma música ao CD
		assertEquals(NUMERO_DE_MUSICAS_CD, cd.getNumeroMusicas()); //confere se o número de músicas foi "setado" corretamente
		assertEquals(null, cd.getMusica(0)); //retorna null já que o CD ainda está vazio
	}
	
	@Test
	public void testaCadastroDeMusicas() {
		assertFalse(cd.alteraFaixaPrincipal("Piano Bar")); //Ainda não tem nenhuma música cadastrada.
		assertFalse(cd.cadastrarMusica(null)); //Tenta atribuir null a faixa principal
		assertFalse(cd.cadastrarMusica("     ")); //Tenta atribuir uma String em branco a faixa principal
		for(int i = 0; i < cd.getNumeroMusicas(); i++) {
			assertTrue(cd.cadastrarMusica(colecaoDeMusicas[i]));
		} //cadastra 10 músicas no CD
		assertFalse(cd.cadastrarMusica(colecaoDeMusicas[cd.getNumeroMusicas()])); //tenta cadastrar mais uma música, porém, já chegou ao limite permitido
		assertTrue(cd.alteraFaixaPrincipal("Piano Bar")); //altera a faixa principal (a música está na lista)
		assertFalse(cd.alteraFaixaPrincipal("Numb")); //tentativa de alterar a faixa principal (a música não está na lista)
		assertFalse(cd.alteraFaixaPrincipal(null)); //novamente uma tentativa de atribuir null a faixa principal
		assertFalse(cd.alteraFaixaPrincipal("    ")); //novamente uma tentativa de atribuir uma String em branco a faixa principal
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "Não é um CD";
		assertFalse(cd.equals(obj)); //testa o equals com outro objeto
		assertFalse(cd.equals(null)); //testa o equals passando null
		CD novoCD = new CD("Novo CD", "Testando Equals"); 
		assertFalse(cd.equals(novoCD)); //testa o equals passando um CD diferente
		novoCD = new CD("Engenheiros do Hawaii", "Linkin Park");
		assertTrue(cd.equals(novoCD)); //testa o equals passando um CD igual
	}   
    
}
