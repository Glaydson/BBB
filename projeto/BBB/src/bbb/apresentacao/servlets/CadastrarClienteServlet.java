package bbb.apresentacao.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbb.apresentacao.dto.ClienteDTO;
import bbb.negocio.clientes.ControleClientes;

/**
 * Servlet para cadastramento de um novo cliente
 */
@WebServlet("/CadastrarClienteServlet")
public class CadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post?");
	}

	/**
	 * Processa o formulário de cadastramento e adiciona um novo cliente no sistema.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		// Lê os dados da requisição
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		String dataNascimentoString = request.getParameter("dataNascimento");
		String email = request.getParameter("email");
		String emailConfirmacao = request.getParameter("emailConfirmacao");
		String senha = request.getParameter("senha");
		String senhaConfirmacao = request.getParameter("senhaConfirmacao");

		boolean dataErrada = false;
		// Cria um DTO e envia para a camada de negócio para validação e
		// cadastramento
		ClienteDTO clidto = new ClienteDTO();
		clidto.setNomeCompleto(nome);
		clidto.setEndereco(endereco);
		clidto.setTelefone(telefone);
		try {
			Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoString);
			clidto.setDataNascimento(dataNascimento);
		} catch (ParseException e) {
			dataErrada = true;
		}

		clidto.setEmail(email);
		clidto.setEmailConfirmacao(emailConfirmacao);
		clidto.setSenha(senha);
		clidto.setSenhaConfirmacao(senhaConfirmacao);

		ControleClientes clientes = new ControleClientes();
		try {
			clientes.adicionar(clidto);
			out.println("Cliente adicionado com sucesso!");
			rd = request.getRequestDispatcher("clientes/cadastrar.html");
			rd.include(request, response);
		} catch (Exception e) {
			if (dataErrada)
				out.println("A data deve ser válida e estar no formato dd/mm/yyyy");
			out.println(e.getMessage());
			rd = request.getRequestDispatcher("clientes/cadastrar.html");
			rd.include(request, response);
		}
	}

}
