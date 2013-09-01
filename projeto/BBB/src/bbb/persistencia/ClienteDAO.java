package bbb.persistencia;

import java.util.ArrayList;
import java.util.List;

import bbb.negocio.clientes.Cliente;

/**
 * Implementa��o da persist�ncia de clientes em Lista (mem�ria)
 */
public class ClienteDAO {

	/** Lista de clientes */
	List<Cliente> clientes = new ArrayList<Cliente>();

	/**
	 * Adiciona um novo cliente na lista.
	 * 
	 * @param cliente
	 */
	public void inserir(Cliente cliente) {
		clientes.add(cliente);
	}

	/**
	 * Verifica se j� existe um cliente com o email informado.
	 * 
	 * @param email Email que se deseja procurar.
	 * @return True caso j� exista cliente com o email informado, False caso n�o exista.
	 */
	public boolean emailJaExistente(String email) {
		boolean existe = false;
		for (Cliente cli : clientes) {
			if (cli.getEmail().equals(email)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Retorna um cliente com o email informado.
	 * 
	 * @param email Email do cliente que se deseja buscar.
	 * @return Cliente com o email informado, ou NULL caso o cliente n�o seja encontrado.
	 */
	public Cliente buscar(String email) {
		for (Cliente cli : clientes) {
			if (cli.getEmail().equals(email)) {
				return cli;
			}
		}
		return null;
	}

	/**
	 * Gera o c�digo de um novo cliente conforme RN01 do UC02
	 * 
	 * @return C�digo do novo cliente a ser adicionado no sistema.
	 */
	public int gerarCodigo() {
		if (clientes.size() > 0) {
			Cliente cli = clientes.get(clientes.size());
			return cli.getCodigo() + 1;
		} else {
			return 1;
		}
	}

}
