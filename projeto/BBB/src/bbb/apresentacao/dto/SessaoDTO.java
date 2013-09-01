package bbb.apresentacao.dto;

import java.util.Date;

public class SessaoDTO {

	private Date dataSessao;
	private String inicio;
	private String duracao;
	private double valorInteira;
	private double valorMeia;
	private String nomeLocal;

	public Date getDataSessao() {
		return dataSessao;
	}

	public void setDataSessao(Date dataSessao) {
		this.dataSessao = dataSessao;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public double getValorInteira() {
		return valorInteira;
	}

	public void setValorInteira(double valorInteira) {
		this.valorInteira = valorInteira;
	}

	public double getValorMeia() {
		return valorMeia;
	}

	public void setValorMeia(double valorMeia) {
		this.valorMeia = valorMeia;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

}
