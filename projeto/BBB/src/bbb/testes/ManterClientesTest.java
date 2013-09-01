package bbb.testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import bbb.apresentacao.dto.ClienteDTO;
import bbb.negocio.clientes.Cliente;
import bbb.negocio.clientes.ControleClientes;
import bbb.negocio.usuarios.ControleUsuarios;
import bbb.negocio.usuarios.Usuario;

/**
 * Classe de testes para operações com clientes.
 * Utiliza framework JUnit.
 * @author glaydson
 *
 */
public class ManterClientesTest {

	private ControleClientes controleCli;
	private ControleUsuarios controleUsu;

	@Before
	public void setUp() throws Exception {
		controleCli = new ControleClientes();
		controleUsu = controleCli.getControleUsuarios();
	}

	@Test
	public void testCadastrarClienteSucesso() {
		// Cria um ClienteDTO para cadastramento
		ClienteDTO clidto = new ClienteDTO("Francisco José", "Rua 3 número 4", "3342-3222",
				stringParaDate("15/05/1980"), "franciscojose@email.com", "franciscojose@email.com",
				"12345", "12345");
		try {
			// Tenta cadastrar
			controleCli.adicionar(clidto);
			// Cria Usuário e Cliente esperados.
			Usuario usuEsperado = new Usuario("franciscojose@email.com", "12345", 2);
			Cliente cliEsperado = new Cliente("Francisco José", "Rua 3 número 4", "3342-3222",
					stringParaDate("15/05/1980"), "franciscojose@email.com", usuEsperado);
			// Obtém Usuário e Cliente criados pelo sistema.
			Usuario usuObtido = controleUsu.buscarUsuario(clidto.getEmail());
			Cliente cliObtido = controleCli.buscarCliente(clidto.getEmail());
			// Verifica se são iguais
			assertTrue(usuObtido.equals(usuEsperado));
			assertTrue(cliObtido.equals(cliEsperado));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testCadastrarClienteErroSemEndereco() {
		// Cria um ClienteDTO para cadastramento
		ClienteDTO clidto = new ClienteDTO("Francisco José", "", "3342-3222",
				stringParaDate("15/05/1980"), "franciscojose@email.com", "franciscojose@email.com",
				"12345", "12345");
		try {
			// Tenta cadastrar
			controleCli.adicionar(clidto);
			fail("Endereço é obrigatório!");
		} catch (Exception e) {
			// Sucesso - a exceção foi capturada.
		}
	}

	@Test
	public void testCadastrarClienteErroSemTelefone() {
		// Cria um ClienteDTO para cadastramento
		ClienteDTO clidto = new ClienteDTO("Francisco José", "Rua 3 número 4", "",
				stringParaDate("15/05/1980"), "franciscojose@email.com", "franciscojose@email.com",
				"12345", "12345");
		try {
			// Tenta cadastrar
			controleCli.adicionar(clidto);
			fail("Telefone é obrigatório!");
		} catch (Exception e) {
			// Sucesso - a exceção foi capturada.
		}
	}

	@Test
	public void testCadastrarClienteErroConfirmacaoDiferente() {
		// Cria um ClienteDTO para cadastramento
		ClienteDTO clidto = new ClienteDTO("Francisco José", "Rua 3 número 4", "3342-3322",
				stringParaDate("15/05/1980"), "franciscojose@email.com", "franciscojos@email.com",
				"12345", "12345");
		try {
			// Tenta cadastrar
			controleCli.adicionar(clidto);
			fail("Senha deve ser igual à sua confirmação!");
		} catch (Exception e) {
			// Sucesso - a exceção foi capturada.
		}
	}
	
	@Test
	public void testCadastrarClienteErroClienteJaExistente() {
		// Cria um ClienteDTO para cadastramento
		ClienteDTO clidto1 = new ClienteDTO("Francisco José", "Rua 3 número 4", "3342-3322",
				stringParaDate("15/05/1980"), "franciscojose@email.com", "franciscojose@email.com",
				"12345", "12345");
		ClienteDTO clidto2 = new ClienteDTO("Maria José", "Rua 3 número 4", "3342-3322",
				stringParaDate("06/10/1974"), "franciscojose@email.com", "franciscojose@email.com",
				"54321", "54321");
		try {
			// Tenta cadastrar
			controleCli.adicionar(clidto1);
			controleCli.adicionar(clidto2);
			fail("Cliente já existente!");
		} catch (Exception e) {
			// Sucesso - a exceção foi capturada.
		}
	}

	private Date stringParaDate(String dataString) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(dataString.substring(6)),
				Integer.parseInt(dataString.substring(3, 5)),
				Integer.parseInt(dataString.substring(0, 2)), 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
