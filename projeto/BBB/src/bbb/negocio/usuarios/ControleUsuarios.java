package bbb.negocio.usuarios;

import bbb.apresentacao.dto.ClienteDTO;
import bbb.negocio.usuarios.Usuario;
import bbb.persistencia.UsuarioDAO;

/**
 * Classe controladora para Usu�rios.
 */
public class ControleUsuarios {

	private static final int NIVEL_CLIENTE = 2;
	UsuarioDAO dao = new UsuarioDAO();

	/**
	 * Cria um novo usu�rio e insere no sistema.
	 * 
	 * @param cli Cliente a partir do qual o novo usu�rio � criado.
	 * @return Usuario criado pelo sistema.
	 */
	public Usuario criarUsuario(ClienteDTO cli) {
		Usuario usu = new Usuario();
		usu.setLogin(cli.getEmail());
		usu.setSenha(cli.getSenha());
		usu.setNivel(NIVEL_CLIENTE);
		dao.inserir(usu);
		return usu;
	}

	/**
	 * Busca um usu�rio a partir do seu e-mail
	 * 
	 * @param email E-mail do usu�rio que se deseja buscar.
	 * @return Usu�rio com o e-mail informado.
	 * @throws Exception Caso o usu�rio n�o seja encontrado.
	 */
	public Usuario buscarUsuario(String email) throws Exception {
		Usuario usu = dao.buscar(email);
		if (usu != null) {
			return usu;
		} else {
			throw new Exception("Usu�rio n�o encontrado");
		}
	}

}
