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
 * Servlet implementation class BuscarTitulosServlet
 */
@WebServlet("/BuscarTitulosServlet")
public class BuscarTitulosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTitulosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lê o tipo de espetáculo selecionado pelo usuário
		String tipo = request.getParameter("tipo");
		TipoEspetaculo tipoEscolhido = TipoEspetaculo.valueOf(tipo);
		ControleEspetaculos controle = new ControleEspetaculos();
		List<String> titulos = controle.buscarTitulos(tipoEscolhido);
		System.out.println(titulos);
		HttpSession sessao = request.getSession();
		sessao.setAttribute("TITULOS", titulos);
		sessao.setAttribute("TIPO_ESCOLHIDO", tipoEscolhido.toString());
		sessao.setAttribute("TIPO_ESPETACULO", tipoEscolhido);
		RequestDispatcher rd = request
				.getRequestDispatcher("espetaculos/continuarConsultaProgramacao.jsp");
		rd.forward(request, response);
	}

}
