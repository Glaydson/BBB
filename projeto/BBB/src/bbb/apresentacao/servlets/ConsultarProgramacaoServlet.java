package bbb.apresentacao.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbb.apresentacao.dto.ConsultarProgramacaoDTO;
import bbb.negocio.espetaculos.ControleEspetaculos;
import bbb.negocio.espetaculos.TipoEspetaculo;

/**
 * Servlet implementation class ConsultarProgramacaoServlet
 */
@WebServlet("/ConsultarProgramacaoServlet")
public class ConsultarProgramacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarProgramacaoServlet() {
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
		String titulo = request.getParameter("titulo");
		HttpSession sessao = request.getSession();
		TipoEspetaculo tipoEspetaculo = (TipoEspetaculo) sessao.getAttribute("TIPO_ESPETACULO");
		ControleEspetaculos controleEspetaculos = new ControleEspetaculos();
		ConsultarProgramacaoDTO dto = controleEspetaculos.consultarProgramacao(tipoEspetaculo, titulo);
		sessao.setAttribute("TITULO", titulo);
		sessao.setAttribute("SESSOES", dto);
		RequestDispatcher rd = request
				.getRequestDispatcher("espetaculos/detalharTitulo.jsp");
		rd.forward(request, response);
	}

}
