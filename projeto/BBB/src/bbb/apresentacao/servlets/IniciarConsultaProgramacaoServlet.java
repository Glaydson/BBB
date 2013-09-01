package bbb.apresentacao.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbb.negocio.espetaculos.ControleEspetaculos;
import bbb.negocio.espetaculos.TipoEspetaculo;

/**
 * Servlet implementation class IniciarConsultaProgramacaoServlet
 */
@WebServlet("/IniciarConsultaProgramacaoServlet")
public class IniciarConsultaProgramacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IniciarConsultaProgramacaoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControleEspetaculos controle = new ControleEspetaculos();
		List<TipoEspetaculo> tipos = controle.buscarTiposEspetaculo();
		HttpSession sessao = request.getSession();
		sessao.setAttribute("TIPOS", tipos);
		RequestDispatcher rd = request
				.getRequestDispatcher("espetaculos/iniciarConsultaProgramacao.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
