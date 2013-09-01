package bbb.negocio.espetaculos;

import java.util.ArrayList;
import java.util.List;

import bbb.apresentacao.dto.ConsultarProgramacaoDTO;
import bbb.persistencia.EspetaculoDAO;

/**
 * Classe controladora de espet�culos.
 */
public class ControleEspetaculos {

	/**
	 * Inst�ncia do DAO que d� acesso aos dados
	 */
	private EspetaculoDAO dao = new EspetaculoDAO();

	public ControleEspetaculos() {

	}

	/**
	 * Busca os tipos de espet�culo cadastrados no sistema.
	 * 
	 * @return Tipos de espet�culo dispon�veis
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
	 * Busca a lista de t�tulos cadastrada para um determinado tipo de espet�culo
	 * 
	 * @param tipoEscolhido Tipo de espet�culo para o qual se deseja buscar os t�tulos
	 * @return Lista de t�tulos correspondente ao tipo de espet�culo escolhido.
	 */
	public List<String> buscarTitulos(TipoEspetaculo tipoEscolhido) {
		return dao.buscarTitulos(tipoEscolhido);
	}

	/**
	 * Chama o DAO para consultar a programa��o de um espet�culo
	 * 
	 * @param tipoEspetaculo Tipo de Espet�culo que se deseja consultar.
	 * @param titulo T�tulo do espet�culo para o qual se deseja obter a programa��o.
	 * @return Programa��o prevista do espet�culo desejado.
	 */
	public ConsultarProgramacaoDTO consultarProgramacao(TipoEspetaculo tipoEspetaculo, String titulo) {

		return dao.consultarProgramacao(tipoEspetaculo, titulo);
	}

}
