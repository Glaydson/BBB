package bbb.negocio.espetaculos;

import java.util.Date;
import java.util.List;

import bbb.negocio.sessoes.Sessao;

/**
 * Classe de entidade representando um espetáculo
 *
 */
public class Espetaculo {
	private String titulo;
	private Date dataInicio;
	private List<String> elenco;
	private String diretor;
	private String duracao;
	private String comentarios;
	private TipoEspetaculo tipoEspetaculo;
	private List<Sessao> sessoes;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public List<String> getElenco() {
		return elenco;
	}

	public void setElenco(List<String> elenco) {
		this.elenco = elenco;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public TipoEspetaculo getTipoEspetaculo() {
		return tipoEspetaculo;
	}

	public void setTipoEspetaculo(TipoEspetaculo tipoEspetaculo) {
		this.tipoEspetaculo = tipoEspetaculo;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

}
