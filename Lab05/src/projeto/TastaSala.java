/*Aluno 1: Adenou Dantas De Farias Júnior*/
/*Aluno 2: <seu nome>*/
/*Aluno 3: <seu nome>*/
package projeto;

/**
 *
 * @author Adenou
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaSala {
	private Sala sala;
	private final int NUM_LINHAS = 10;
	private final int NUM_COLUNAS = 10;

	@Before
	public void criaObjetos() throws Exception {
		sala = new Sala(NUM_LINHAS, NUM_COLUNAS);
	}

	@Test
	public void testaCriaSala() {
		try {
			new Sala(-1, 10);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Sala(10, -1);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Sala(-1, -1);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) e na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Sala(0, 0);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) e na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Sala(10, 0);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Sala(0, 10);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Sala(0, 0);
			Assert.fail("Esperava excecao, pois a quantidade de posi coes na horizontal (linhas) e na vertical (colunas) esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero",
					e.getMessage());
		}
	}
	
	@Test
	public void testaDimensoesDaSala() {
		Assert.assertTrue(sala.getNumPosicoesHorizontais() == 10);
		Assert.assertTrue(sala.getNumPosicoesVerticais() == 10);
		try {
			sala = new Sala(8, 9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(sala.getNumPosicoesHorizontais() == 8);
		Assert.assertTrue(sala.getNumPosicoesVerticais() == 9);
	}

	@Test
	public void testaIsVazia() {
		Assert.assertTrue(sala.isVazia());
		Assert.assertTrue(sala.inserirObstaculo(0, 0));
		Assert.assertFalse(sala.isVazia());
	}

	@Test
	public void testaVerificaPosicaoValida() {
		Assert.assertTrue(sala.posicaoValida(0, 0));
		Assert.assertTrue(sala.posicaoValida(9, 9));

		Assert.assertFalse(sala.posicaoValida(-1, -1));
		Assert.assertFalse(sala.posicaoValida(-1, 0));
		Assert.assertFalse(sala.posicaoValida(0, -1));

		Assert.assertFalse(sala.posicaoValida(10, 10));
		Assert.assertFalse(sala.posicaoValida(10, 0));
		Assert.assertFalse(sala.posicaoValida(0, 10));

		Assert.assertFalse(sala.posicaoValida(10, -1));
		Assert.assertFalse(sala.posicaoValida(-1, 10));
	}

	@Test
	public void testaInserirObstaculos() throws Exception {
		Assert.assertTrue(sala.inserirObstaculo(0, 0));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));

		Assert.assertTrue(sala.inserirObstaculo(9, 9));
		Assert.assertFalse(sala.isPosicaoLivre(9, 9));

		Assert.assertFalse(sala.inserirObstaculo(10, 10));
		Assert.assertFalse(sala.inserirObstaculo(-1, -1));
		Assert.assertFalse(sala.inserirObstaculo(-1, 0));
		Assert.assertFalse(sala.inserirObstaculo(0, -1));
	}

	@Test
	public void testaSetPosicao() throws Exception {
		Assert.assertTrue(sala.setPosicao(0, 0, Sala.OCUPADO));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));

		Assert.assertTrue(sala.setPosicao(0, 0, Sala.LIVRE));
		Assert.assertTrue(sala.isPosicaoLivre(0, 0));

		Assert.assertTrue(sala.setPosicao(9, 9, Sala.OCUPADO));
		Assert.assertFalse(sala.isPosicaoLivre(9, 9));

		Assert.assertTrue(sala.setPosicao(9, 9, Sala.LIVRE));
		Assert.assertTrue(sala.isPosicaoLivre(9, 9));

		Assert.assertFalse(sala.setPosicao(10, 10, Sala.OCUPADO));
		Assert.assertFalse(sala.setPosicao(-1, -1, Sala.OCUPADO));
		Assert.assertFalse(sala.setPosicao(-1, 0, Sala.OCUPADO));
		Assert.assertFalse(sala.setPosicao(0, -1, Sala.OCUPADO));
	}

	@Test
	public void testaIsPosicaoLivre() throws Exception {
		Assert.assertTrue(sala.isPosicaoLivre(0, 0));
		Assert.assertTrue(sala.isPosicaoLivre(9, 9));
		try {
			Assert.assertTrue(sala.isPosicaoLivre(-1, 0));
			Assert.fail("Uma excecao de posicao inexistente deve ser lancada.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem de erro", "Posicao inexistente.",
					e.getMessage());
		}
		try {
			Assert.assertTrue(sala.isPosicaoLivre(-1, -1));
			Assert.fail("Uma excecao de posicao inexistente deve ser lancada.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem de erro", "Posicao inexistente.",
					e.getMessage());
		}

		try {
			Assert.assertTrue(sala.isPosicaoLivre(0, -1));
			Assert.fail("Uma excecao de posicao inexistente deve ser lancada.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem de erro", "Posicao inexistente.",
					e.getMessage());
		}
	}
	
	@Test
	public void testaEquals() {
		Sala outraSala = null;
		try {
			outraSala = new Sala(NUM_LINHAS, NUM_COLUNAS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(sala.equals(outraSala));
		sala.inserirObstaculo(5, 5);
		Assert.assertFalse(sala.equals(outraSala));
		outraSala.inserirObstaculo(5, 5);
		Assert.assertTrue(sala.equals(outraSala));	
		
		sala.inserirObstaculo(0, 9);
		Assert.assertFalse(sala.equals(outraSala));
		outraSala.inserirObstaculo(0, 9);
		Assert.assertTrue(sala.equals(outraSala));
		
		sala.inserirObstaculo(9, 9);
		Assert.assertFalse(sala.equals(outraSala));
		outraSala.inserirObstaculo(9, 9);
		Assert.assertTrue(sala.equals(outraSala));
	}

}
