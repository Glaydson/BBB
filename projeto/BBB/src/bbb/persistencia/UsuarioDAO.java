package bbb.persistencia;

import java.util.ArrayList;
import java.util.List;

import bbb.negocio.usuarios.Usuario;

/**
 * Implementação de persistência para a entidade Usuario, utilizando lista em memória.
 */
public class UsuarioDAO {

	/** Lista de usuários. */
	List<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Adiciona um novo usuário na lista.
	 * 
	 * @param usuario
	 */
	public void inserir(Usuario usuario) {
		usuarios.add(usuario);
	}

	/**
	 * Retorna o usuário com o login fornecido
	 * 
	 * @param login Login cujo usuário se deseja buscar.
	 * @return Usuario com o login fornecido ou NULL caso não seja encontrado.
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
