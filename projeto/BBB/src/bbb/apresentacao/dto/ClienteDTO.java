package bbb.apresentacao.dto;

import java.util.Date;

/**
 * Classe de transporte para dados de cadastramento de clientes.
 * 
 * @author glaydson
 */
public class ClienteDTO {
	private String nomeCompleto;
	private String endereco;
	private String telefone;
	private Date dataNascimento;
	private String email;
	private String emailConfirmacao;
	private String senha;
	private String senhaConfirmacao;

	public ClienteDTO(String nomeCompleto, String endereco, String telefone, Date dataNascimento,
			String email, String emailConfirmacao, String senha, String senhaConfirmacao) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.emailConfirmacao = emailConfirmacao;
		this.senha = senha;
		this.senhaConfirmacao = senhaConfirmacao;
	}

	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the emailConfirmacao
	 */
	public String getEmailConfirmacao() {
		return emailConfirmacao;
	}

	/**
	 * @param emailConfirmacao the emailConfirmacao to set
	 */
	public void setEmailConfirmacao(String emailConfirmacao) {
		this.emailConfirmacao = emailConfirmacao;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the senhaConfirmacao
	 */
	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	/**
	 * @param senhaConfirmacao the senhaConfirmacao to set
	 */
	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

}
