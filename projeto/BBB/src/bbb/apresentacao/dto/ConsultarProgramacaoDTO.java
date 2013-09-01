package bbb.apresentacao.dto;

import java.util.List;

import bbb.negocio.espetaculos.TipoEspetaculo;

public class ConsultarProgramacaoDTO {
	private TipoEspetaculo tipo;
	private String titulo;
	private String comentarios;
	private List<SessaoDTO> listaSessoes;

	public TipoEspetaculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspetaculo tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<SessaoDTO> getListaSessoes() {
		return listaSessoes;
	}

	public void setListaSessoes(List<SessaoDTO> listaSessoes) {
		this.listaSessoes = listaSessoes;
	}

}
