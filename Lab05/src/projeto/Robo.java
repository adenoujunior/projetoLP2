/*Aluno 1: Adenou Dantas De Farias Júnior*/

package projeto;

/**
 *
 * @author Adenou
 */
public class Robo {
    
    	private Sala sala = null;
	private int linhaAtual;
	private int colunaAtual;
	private int bateria;
	private int nMovimentos;
	
	
	public Robo(Sala sala, int bateria) throws Exception{
		validaEnergia(bateria);
		posicionaRobo(sala);
	}
	
	
	private void validaEnergia(int energia) throws Exception{
		if(energia > 0) {
			this.bateria = energia;
		}else {
			throw new Exception("Você não pode criar um robô com a bateria igual ou menor que zero!");
		}
	}
	
	
	private void posicionaRobo(Sala sala) throws Exception{
	    boolean status = false;
	    if(!(sala == null)){
		for(int i = 0; i < sala.getNumPosicoesHorizontais(); i++){
		   for(int j = 0; j < sala.getNumPosicoesVerticais(); j++){
			if(sala.isPosicaoLivre(i, j)){
			linhaAtual = i;
			colunaAtual = j;
			sala.setPosicao(linhaAtual, colunaAtual, Sala.OCUPADO);
			this.sala = sala;
			status = true;
			break;
					}
				}
				if(status) break;
			}
			if(!status){
				throw new Exception("Sala está lotada, o robô não pode ser posionado nela!");
			}
		}else{
			throw new Exception("Nenhuma sala criada para o robô!");
		}
	}

	
	public boolean isPosicaoAtual(int linha, int coluna) {
		return linha == linhaAtual && coluna == colunaAtual;
	}
	
	
	public int numeroPassos() {
		return nMovimentos;
	}

	
	public int energiaAtual() {
		return bateria;
	}	

	
	private void atualizaPosicao(int linhaAtual, int colunaAtual, int status) {
		sala.setPosicao(linhaAtual, colunaAtual, status);
		nMovimentos++;
		bateria--;
	}
	
	
	private boolean movimentarRobo(int linha, int coluna) {
		try {
			if(sala.isPosicaoLivre(linha, coluna)) {
				sala.setPosicao(linhaAtual, colunaAtual, Sala.LIVRE);
				return true;
			}	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
	
	public boolean praTras() {
		if(energiaAtual() > 0 && linhaAtual > 0) {
			if(movimentarRobo(linhaAtual-1, colunaAtual)) {
				atualizaPosicao(--linhaAtual, colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}
	
	
	public boolean praFrente() {
		if(energiaAtual() > 0 && linhaAtual < this.sala.getNumPosicoesVerticais()-1) {
			if(movimentarRobo(linhaAtual+1, colunaAtual)) {
				atualizaPosicao(++linhaAtual, colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}
	
	
	public boolean esquerda() {
		if(energiaAtual() > 0 && colunaAtual > 0) {
			if(movimentarRobo(linhaAtual, colunaAtual-1)) {
				atualizaPosicao(linhaAtual, --colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}

	
	public boolean direita() {
		if(energiaAtual() > 0 && colunaAtual < this.sala.getNumPosicoesHorizontais()-1) {
			if(movimentarRobo(linhaAtual, colunaAtual+1)) {
				atualizaPosicao(linhaAtual, ++colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}

	
	@Override
	public boolean equals(Object robo2) {
		if(!(robo2 == null)) {
			Robo roboAux = (Robo) robo2;
			if(sala.equals(roboAux.sala) && isPosicaoAtual(roboAux.linhaAtual, roboAux.colunaAtual)) {
				return true;
			}
		}
		return false;
	}
}
    

