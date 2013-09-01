package bbb.negocio.email;

/**
 * Representa um e-mail de confirmação para o usuário, confirmando seu cadastramento no sistema.
 */
public class EmailConfirmacao {

	private String destinatario;
	private StringBuffer textoEmail;

	/**
	 * @return the destinatario
	 */
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * @return the textoEmail
	 */
	public StringBuffer getTextoEmail() {
		return textoEmail;
	}

	/**
	 * @param textoEmail the textoEmail to set
	 */
	public void setTextoEmail(StringBuffer textoEmail) {
		this.textoEmail = textoEmail;
	}

}
