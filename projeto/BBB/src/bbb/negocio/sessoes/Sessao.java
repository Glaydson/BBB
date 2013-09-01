package bbb.negocio.sessoes;

import java.util.Date;

import bbb.negocio.locais.Local;

/**
 * Entidade que representa uma sessão de um espetáculo.
 */
public class Sessao {

	private Date data;
	private String horaInicio;
	private double valorInteira;
	private double valorMeia;
	private Local local;

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the horaInicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the valorInteira
	 */
	public double getValorInteira() {
		return valorInteira;
	}

	/**
	 * @param valorInteira the valorInteira to set
	 */
	public void setValorInteira(double valorInteira) {
		this.valorInteira = valorInteira;
	}

	/**
	 * @return the valorMeia
	 */
	public double getValorMeia() {
		return valorMeia;
	}

	/**
	 * @param valorMeia the valorMeia to set
	 */
	public void setValorMeia(double valorMeia) {
		this.valorMeia = valorMeia;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
