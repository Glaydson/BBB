package bbb.persistencia;

import java.util.ArrayList;
import java.util.List;

import bbb.negocio.usuarios.Usuario;

/**
 * Implementa��o de persist�ncia para a entidade Usuario, utilizando lista em mem�ria.
 */
public class UsuarioDAO {

	/** Lista de usu�rios. */
	List<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Adiciona um novo usu�rio na lista.
	 * 
	 * @param usuario
	 */
	public void inserir(Usuario usuario) {
		usuarios.add(usuario);
	}

	/**
	 * Retorna o usu�rio com o login fornecido
	 * 
	 * @param login Login cujo usu�rio se deseja buscar.
	 * @return Usuario com o login fornecido ou NULL caso n�o seja encontrado.
	 */
	public Usuario buscar(String login) {
		for (Usuario usu : usuarios) {
			if (usu.getLogin().equals(login)) {
				return usu;
			}
		}
		return null;
	}
}
