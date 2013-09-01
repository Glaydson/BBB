package bbb.negocio.email;

/**
 * Interface com o servidor para envio de e-mail.
 */
public interface InterfaceServidorEmail {

	/**
	 * Envia o email especificado como parâmetro.
	 * 
	 * @param email E-mail a ser enviado.
	 */
	public void enviarEmail(EmailConfirmacao email);

}
