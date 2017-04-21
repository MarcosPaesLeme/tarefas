package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conjunto;
import service.ConjuntoService;

/**
 * Servlet implementation class ConsultarServlet
 */
@WebServlet("/ConsultarServlet")
public class ConsultarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("idConjunto");
		//String acao = (request.getParameter("acao"));

		// javabean
		Conjunto conjunto = new Conjunto();
		

		// service
		ConjuntoService cs = new ConjuntoService();
		conjunto = cs.consultarConjunto(Integer.parseInt(id));

		// enviar parametros para o jsp

		request.setAttribute("conjunto", conjunto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarConjunto.jsp");
		dispatcher.forward(request, response);

	}

}