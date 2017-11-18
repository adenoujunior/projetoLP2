/*Aluno 1: Adenou Dantas De Farias Júnior*/


package projeto;

/**
 *
 * @author Adenou
 */
public class Sala {
    
    private int[][] sala;
    public static final int LIVRE = 0;
    public static final int OCUPADO = 1;
	
	
    public Sala(int linhas, int colunas) throws Exception{
	validaDimensoes(linhas, colunas);
    }
	
	
    private void validaDimensoes(int linhas, int colunas) throws Exception{
	if(linhas > 0 && colunas > 0) {
		sala = new int[linhas][colunas];
    }else {
	throw new Exception("Você não pode criar uma sala sem espaços!");
	}
    }

	
    public int getNumPosicoesHorizontais() {
	return sala.length;
     }

	
    public int getNumPosicoesVerticais() {
	return sala[0].length;
    }
	
	
    public boolean isVazia() {
	for(int i = 0; i < getNumPosicoesHorizontais(); i++) {
	    for(int j = 0; j < getNumPosicoesVerticais(); j++) {
		if(sala[i][j] == Sala.OCUPADO) {
			return false;
			}
		}
	}
		return true;
    }

	
    public boolean inserirObstaculo(int linha, int coluna) throws Exception{
	if(isPosicaoLivre(linha, coluna)) {
		sala[linha][coluna] = Sala.OCUPADO;
			return true;
		}
		return false;
	}

	
    public boolean posicaoValida(int linha, int coluna) {
		if((linha >= 0 && linha < sala.length) && (coluna >= 0 && coluna < sala[0].length)) {
			return true;
		}
		return false;
	}

	
	public boolean isPosicaoLivre(int linha, int coluna) throws Exception{
		if(posicaoValida(linha, coluna)) {
			return sala[linha][coluna] == Sala.LIVRE;
		}
		throw new Exception("Essa posição não existe!");
	}
	
	
	public boolean setPosicao(int linha, int coluna, int status) {
		if(posicaoValida(linha, coluna)) {
			sala[linha][coluna] = status;
			return true;
		}
		return false;
	}
	
	
	@Override
    public boolean equals(Object outraSala) {
	if(!(outraSala == null)) {
	    Sala salaAux = (Sala)outraSala;
     if(getNumPosicoesHorizontais() == salaAux.getNumPosicoesHorizontais() && getNumPosicoesVerticais() == salaAux.getNumPosicoesVerticais()) {
	for(int i = 0; i < getNumPosicoesHorizontais(); i++) {
		for(int j = 0; j < getNumPosicoesVerticais(); j++) {
		if(sala[i][j] != salaAux.sala[i][j]) {
	return false;
		   }
		 }
		}
	return true;
		}
	}
		return false;
	}
}
    

