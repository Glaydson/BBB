package bbb.negocio.espetaculos;

import java.util.ArrayList;
import java.util.List;

import bbb.apresentacao.dto.ConsultarProgramacaoDTO;
import bbb.persistencia.EspetaculoDAO;

/**
 * Classe controladora de espetáculos.
 */
public class ControleEspetaculos {

	/**
	 * Instância do DAO que dá acesso aos dados
	 */
	private EspetaculoDAO dao = new EspetaculoDAO();

	public ControleEspetaculos() {

	}

	/**
	 * Busca os tipos de espetáculo cadastrados no sistema.
	 * 
	 * @return Tipos de espetáculo disponíveis
	 */
	public List<TipoEspetaculo> buscarTiposEspetaculo() {
		TipoEspetaculo[] tiposArray = TipoEspetaculo.values();
		List<TipoEspetaculo> tipos = new ArrayList<TipoEspetaculo>();
		for (int i = 0; i < tiposArray.length; i++) {
			tipos.add(tiposArray[i]);
		}
		return tipos;
	}

	/**
	 * Busca a lista de títulos cadastrada para um determinado tipo de espetáculo
	 * 
	 * @param tipoEscolhido Tipo de espetáculo para o qual se deseja buscar os títulos
	 * @return Lista de títulos correspondente ao tipo de espetáculo escolhido.
	 */
	public List<String> buscarTitulos(TipoEspetaculo tipoEscolhido) {
		return dao.buscarTitulos(tipoEscolhido);
	}

	/**
	 * Chama o DAO para consultar a programação de um espetáculo
	 * 
	 * @param tipoEspetaculo Tipo de Espetáculo que se deseja consultar.
	 * @param titulo Título do espetáculo para o qual se deseja obter a programação.
	 * @return Programação prevista do espetáculo desejado.
	 */
	public ConsultarProgramacaoDTO consultarProgramacao(TipoEspetaculo tipoEspetaculo, String titulo) {

		return dao.consultarProgramacao(tipoEspetaculo, titulo);
	}

}
