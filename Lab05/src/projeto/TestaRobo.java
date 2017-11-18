/*Aluno 1: Adenou Dantas De Farias Júnior*/

package projeto;

/**
 *
 * @author Adenou
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaRobo {
    
 private Sala sala = null;
	private Robo robo = null;
	private int BATERIA_TOTAL = 10;
	private int LINHA = 3;
	private int COLUNA = 3;
	
	public Sala criaSala() throws Exception{
		return new Sala(LINHA, COLUNA);
	}
	
	public void preencheSala(Sala sala) {
		for(int i = 0; i < sala.getNumPosicoesHorizontais(); i++) {
			for(int j = 0; j < sala.getNumPosicoesVerticais(); j++) {
				sala.setPosicao(i, j, Sala.OCUPADO);
			}
		}
	}
	
	@Before
	public void criaRobo() throws Exception {
		sala = criaSala();
		robo = new Robo(sala, BATERIA_TOTAL);
	}
	
	@Test
	public void testaCriacaoRobo() {
		try {
			Assert.assertTrue(robo.isPosicaoAtual(0, 0));
			Assert.assertFalse(sala.isPosicaoLivre(0, 0));
		}catch(Exception e) {
			Assert.fail("Não deve cair aqui.");
		}
		try {
			sala = criaSala();
			sala.inserirObstaculo(0, 0);
			robo = new Robo(sala, BATERIA_TOTAL);
		}catch(Exception e) {
			Assert.fail("Não deve entrar aqui.");
		}
		Assert.assertTrue(robo.isPosicaoAtual(0, 1));

		try {
			new Robo(criaSala(), BATERIA_TOTAL);
		}catch(Exception e) {
			Assert.fail("Não deve entrar aqui!");
			e.printStackTrace();
		}
		try {
			new Robo(criaSala(), -1);
			Assert.fail("Esperado uma exceção pois a bateria não pode ser negativa.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Você não pode criar um robô com a bateria igual ou menor que zero!", e.getMessage());
		}
		try {
			new Robo(criaSala(), 0);
			Assert.fail("Esperado uma exceção pois a bateria não pode ser igual a zero.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Você não pode criar um robô com a bateria igual ou menor que zero!", e.getMessage());
		}
		try {
			new Robo(null, BATERIA_TOTAL);
			Assert.fail("Esperado uma exceção pois não pode ser passado null no parâmetro sala");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Nenhuma sala criada para o robô!", e.getMessage());
		}
		try {
			Sala salaAux = criaSala();
			preencheSala(salaAux);
			new Robo(salaAux, BATERIA_TOTAL);
			Assert.fail("Esperado uma exceção pois a sala passada está cheia.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Sala está lotada, o robô não pode ser posionado nela!", e.getMessage());
		}	
	}
	
	@Test
	public void testaMovimentosIniciaisRobo() throws Exception {
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));
		Assert.assertFalse(robo.praTras());
		Assert.assertFalse(robo.esquerda());
		Assert.assertEquals(BATERIA_TOTAL, robo.energiaAtual());
		Assert.assertEquals(0, robo.numeroPassos());
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.isPosicaoAtual(1,0));
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertTrue(robo.praTras());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		
		try {
			sala = criaSala();
			sala.inserirObstaculo(0, 0);
			robo = new Robo(sala, BATERIA_TOTAL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(robo.isPosicaoAtual(0,0));
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
	}
	
	@Test
	public void testaMovimentosComObstaculos() throws Exception {
		sala.inserirObstaculo(1, 0);
		sala.inserirObstaculo(0, 2);
		Assert.assertFalse(robo.praFrente());
		Assert.assertEquals(BATERIA_TOTAL, robo.energiaAtual());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertEquals(1, robo.numeroPassos());
		Assert.assertEquals(BATERIA_TOTAL-1, robo.energiaAtual());
		Assert.assertFalse(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertEquals(1, robo.numeroPassos());
		Assert.assertEquals(BATERIA_TOTAL-1, robo.energiaAtual());
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertEquals(2, robo.numeroPassos());
		Assert.assertEquals(BATERIA_TOTAL-2, robo.energiaAtual());
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(1,2));
		Assert.assertEquals(BATERIA_TOTAL-3, robo.energiaAtual());
		Assert.assertEquals(3, robo.numeroPassos());
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertFalse(robo.esquerda());
		Assert.assertEquals(BATERIA_TOTAL-4, robo.energiaAtual());
		Assert.assertEquals(4, robo.numeroPassos());
	}
	
	@Test
	public void testeEmSalaVazia() {
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.praFrente());
		Assert.assertEquals(BATERIA_TOTAL-3, robo.energiaAtual());
		Assert.assertEquals(3, robo.numeroPassos());
		Assert.assertTrue(robo.isPosicaoAtual(2,1));
		
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.praTras());
		Assert.assertTrue(robo.esquerda());
		Assert.assertEquals(BATERIA_TOTAL-6, robo.energiaAtual());
		Assert.assertEquals(6, robo.numeroPassos());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.praTras());
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.esquerda());
		Assert.assertEquals(0, robo.energiaAtual());
		Assert.assertEquals(10, robo.numeroPassos());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		
		Assert.assertFalse(robo.direita());
		Assert.assertEquals(0, robo.energiaAtual());
	}
	
	@Test
	public void testarQuinas() {
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.direita());
		Assert.assertFalse(robo.direita());
		Assert.assertFalse(robo.praTras());
		Assert.assertTrue(robo.isPosicaoAtual(0,2));
		Assert.assertEquals(BATERIA_TOTAL-2, robo.energiaAtual());
		Assert.assertEquals(2, robo.numeroPassos());
		
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.praFrente());
		Assert.assertFalse(robo.praFrente());
		Assert.assertFalse(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(2,2));
		Assert.assertEquals(BATERIA_TOTAL-4, robo.energiaAtual());
		Assert.assertEquals(4, robo.numeroPassos());
		
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.esquerda());
		Assert.assertFalse(robo.esquerda());
		Assert.assertFalse(robo.praFrente());
		Assert.assertTrue(robo.isPosicaoAtual(2,0));
		Assert.assertEquals(BATERIA_TOTAL-6, robo.energiaAtual());
		Assert.assertEquals(6, robo.numeroPassos());
	}
	
	@Test
	public void testaEquals() throws Exception {
		Sala sala2 = null;
		Robo robo2 = null;
		Assert.assertFalse(robo.equals(robo2));
		try {
			sala2 = new Sala(10, 10);
			robo2 = new Robo(sala2, BATERIA_TOTAL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(robo.equals(robo2));
		
		try{
			sala2 = criaSala();
			 robo2 = new Robo(sala2, BATERIA_TOTAL);
		}catch(Exception e){
			e.printStackTrace();
		}
		Assert.assertTrue(robo.equals(robo2));
		Assert.assertTrue(sala2.inserirObstaculo(0, 1));
		Assert.assertFalse(robo.equals(robo2));
		Assert.assertTrue(sala.inserirObstaculo(0, 1));
		Assert.assertTrue(robo.equals(robo2));
		Assert.assertTrue(robo2.praFrente());
		Assert.assertFalse(robo.equals(robo2));
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.equals(robo2));
	}
}
