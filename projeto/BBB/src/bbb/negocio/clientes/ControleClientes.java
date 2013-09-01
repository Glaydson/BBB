package bbb.negocio.clientes;

import bbb.apresentacao.dto.ClienteDTO;
import bbb.negocio.email.EmailConfirmacao;
import bbb.negocio.email.InterfaceServidorEmail;
import bbb.negocio.email.ServidorEmail;
import bbb.negocio.usuarios.ControleUsuarios;
import bbb.negocio.usuarios.Usuario;
import bbb.persistencia.ClienteDAO;

/**
 * Classe de controle para operações com clientes
 * 
 * @author glaydson
 */
public class ControleClientes {

	private static final String EM_BRANCO = "";
	ClienteDAO dao = new ClienteDAO();
	ControleUsuarios controleUsu = new ControleUsuarios();

	/**
	 * Adiciona um novo cliente no sistema
	 * 
	 * @param clidto DTO contendo os dados do cliente a ser inserido.
	 * @throws Exception Caso ocorra algum erro na validação dos dados ou no cadastramento do
	 *             cliente
	 */
	public void adicionar(ClienteDTO clidto) throws Exception {
		validar(clidto);
		Cliente cli = new Cliente();
		cli.setNome(clidto.getNomeCompleto());
		cli.setEndereco(clidto.getEndereco());
		cli.setDataNascimento(clidto.getDataNascimento());
		cli.setTelefone(clidto.getTelefone());
		cli.setEmail(clidto.getEmail());
		// Gera o novo código do cliente
		cli.setCodigo(dao.gerarCodigo());
		// Cria o Usuário para este cliente
		Usuario usuario = controleUsu.criarUsuario(clidto);
		cli.setUsuario(usuario);
		// Insere no sistema
		dao.inserir(cli);
		// Enviar e-mail de confirmação
		EmailConfirmacao email = new EmailConfirmacao();
		email.setDestinatario(cli.getEmail());
		email.setTextoEmail(new StringBuffer("Blá Blá Blá"));
		InterfaceServidorEmail servidor = new ServidorEmail();
		servidor.enviarEmail(email);
	}

	/**
	 * Procura um cliente a partir do seu email.
	 * 
	 * @param email Email cujo cliente se deseja obter
	 * @return Cliente com o email informado.
	 * @throws Exception Caso o cliente não seja encontrado.
	 */
	public Cliente buscarCliente(String email) throws Exception {
		Cliente cli = dao.buscar(email);
		if (cli != null) {
			return cli;
		} else {
			throw new Exception("Cliente não encontrado");
		}
	}

	/**
	 * Efetua a validação dos dados do cliente conforme o UC02
	 * 
	 * @param clidto DTO com os dados a serem validados.
	 * @throws Exception Caso ocorra algum erro de validação
	 */
	private void validar(ClienteDTO clidto) throws Exception {
		StringBuffer erros = new StringBuffer();
		if (clidto.getNomeCompleto().equals(EM_BRANCO)) {
			erros.append("O nome é obrigatório\n");
		}
		if (clidto.getEndereco().equals(EM_BRANCO)) {
			erros.append("O endereço é obrigatório\n");
		}
		if (clidto.getTelefone().equals(EM_BRANCO)) {
			erros.append("O telefone é obrigatório\n");
		}
		if (clidto.getEmail().equals(EM_BRANCO)) {
			erros.append("O e-mail é obrigatório\n");
		} else {
			if (!clidto.getEmail().equals(clidto.getEmailConfirmacao())) {
				erros.append("Confirmação de e-mail não confere.\n");
			} else {
				// Busca se já existe cliente com o e-mail informado
				if (dao.emailJaExistente(clidto.getEmail())) {
					erros.append("E-mail já existe em nossos registros.\n");
				}
			}
		}
		if (clidto.getSenha().equals(EM_BRANCO)) {
			erros.append("A senha é obrigatória\n");
		} else {
			if (!clidto.getSenha().equals(clidto.getSenhaConfirmacao())) {
				erros.append("Confirmação de senha não confere.\n");
			} else {
				if (clidto.getSenha().length() > 8) {
					erros.append("A senha deve ter no máximo 8 caracteres\n");
				}
			}
		}
		if (erros.length() != 0) {
			throw new Exception(erros.toString());
		}
	}

	/**
	 * Retorna o controlador de usuários associado a este controlador.
	 * 
	 * @return
	 */
	public ControleUsuarios getControleUsuarios() {
		return controleUsu;
	}

}
