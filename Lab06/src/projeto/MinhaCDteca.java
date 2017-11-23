/*Aluno: Adenou Dantas de Farias Júnior*/
/*Aluno 2: Joyce Mikaella das Mercês Aciole*/

package projeto;

/**
 * Classe que contém uma coleção de CD's com métodos para manipulá-los.
 * @author Adenou
 */

import java.util.ArrayList;
import java.util.List;


public class MinhaCDteca {
    
 private List<CD> colecaoDeCDs;
	private int variedade;
	
	/**
	 * Contrutor que instancia um coleção do CD's.
	 */
	public MinhaCDteca() {
		colecaoDeCDs = new ArrayList<CD>();
		variedade = 0;
	}
	
	/**.
	 * @param novoCD Um CD que será adicionado a coleção.
	 */
	public void adicionaCD(CD novoCD) {
		int cont=0;
		for(int i = 0; i < colecaoDeCDs.size(); i++) {
			if(!novoCD.getTitulo().equals(colecaoDeCDs.get(i).getTitulo()))
				cont++;
		}
		if(cont == numeroDeCDs())
			variedade++;
		colecaoDeCDs.add(novoCD);
	}
	
	/**
	 * Adiciona uma lista de CD's na coleção de CD's.
	 * @param listaCDs Uma List<CD> que será adicionada a coleção.
	 */
	public void adicionaCDs(List<CD> listaCDs) {
		for(int i = 0; i < listaCDs.size(); i++) {
			adicionaCD(listaCDs.get(i));
		}
	}
	
	/**
	 * Remove um CD da lista de CD's a partir do título do CD.
	 * @param titulo O título do CD que se quer remover.
	 * @return O CD removido, ou null se não tiver sido encontrado.
	 * @throws Exception Será lançada caso o CD que o usuário esteja tentando remover não esteja na coleção.
	 */
	public CD removeCD(String titulo) throws Exception{
		for(int i = 0; i < colecaoDeCDs.size(); i++) {
			if(titulo.equals(colecaoDeCDs.get(i).getTitulo())) {
				return colecaoDeCDs.remove(i);
			}
		}
		throw new Exception("Este CD não está na discografia.");
	}
	
	/**
	 * @param titulos Uma List<CD> com os CD's que se deseja remover.
	 * @return true se pelo menos um CD for removido, false se não remover nenhum CD da coleção.
	 */
	public boolean removeCDs(List<CD> listaCDs) {
		int cont = 0;
		for(int i = 0; i < listaCDs.size(); i++) {
			try {
				removeCD(listaCDs.get(i).getTitulo());
				cont++;
			}catch(Exception e) {
			}
		}
		if(cont != 0)
			return true;
		return false;
	}
	
	/**
	 * Pesquisa um CD na discografia de CD's com base no título.
	 * @param titulo O título do CD procurado.
	 * @return O CD caso ele esteja na coleção ou null se não o achar.
	 */
	public CD pesquisaCD(String titulo) {
		for(int i = 0; i < colecaoDeCDs.size(); i++)
			if(titulo.equals(colecaoDeCDs.get(i).getTitulo()))
				return colecaoDeCDs.get(i);
		return null;
	}
	
	/**
	 * @return O número de CD's que existem na discografia.
	 */
	public int numeroDeCDs() {
		return this.colecaoDeCDs.size();
	}
	
	/**
	 * Compara as coleções de CD's para ver uma é igual a outra.
	 */
	@Override
	public boolean equals(Object outraBiblioteca) {
		if(outraBiblioteca instanceof MinhaCDteca && outraBiblioteca != null) {
			MinhaCDteca auxCDteca = (MinhaCDteca) outraBiblioteca;
			if(variedade == auxCDteca.variedade) {
				for(int i = 0; i < colecaoDeCDs.size(); i++) {
					if(auxCDteca.pesquisaCD(colecaoDeCDs.get(i).getTitulo()) == null) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @retorn uma representação da String da coleção de CD's.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Lista de CD's da discografia: ");
		for(int i = 0; i < colecaoDeCDs.size(); i++) {
			string.append(String.format("\n\nCD %02d", i+1));
			string.append("\nArtista: "+colecaoDeCDs.get(i).getArtista());
			string.append("\nTítulo: "+colecaoDeCDs.get(i).getTitulo());
		}
		return string.toString();
	}
    
}
    

