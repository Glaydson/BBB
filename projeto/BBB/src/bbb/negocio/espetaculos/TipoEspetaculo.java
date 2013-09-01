package bbb.negocio.espetaculos;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumera��o para os tipos de espet�culo existentes no sistema.
 */
public enum TipoEspetaculo {
	FILME("Filme"), PECA_TEATRO("Pe�a de Teatro"), SHOW("Show");

	String tipo;

	private TipoEspetaculo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return tipo;
	}

	/**
	 * Retorna uma lista com os tipos de espet�culo existentes.
	 * 
	 * @return Lista com os tipos de espet�culo existentes.
	 */
	public List<TipoEspetaculo> obterTiposEspetaculo() {
		List<TipoEspetaculo> tiposEspetaculo = new ArrayList<TipoEspetaculo>();
		TipoEspetaculo[] tiposEsp = TipoEspetaculo.values();
		for (int i = 0; i < tiposEsp.length; i++) {
			tiposEspetaculo.add(tiposEsp[i]);
		}
		return tiposEspetaculo;
	}

}
