package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		String Id = request.getParameter("id");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(Id);
		} catch (NumberFormatException e) {}


		String acao = (request.getParameter("acao"));
		RequestDispatcher view = null;
		HttpSession session = request.getSession();


		// javabean
		Conjunto conjunto = new Conjunto();
		

		// service
		ConjuntoService cs = new ConjuntoService();
		

		// enviar parametros para o jsp
		
		if(acao.equals("Visualizar")){
			conjunto = cs.consultarConjunto(id);
			
			request.setAttribute("conjunto", conjunto);
			view = request.getRequestDispatcher("ConsultarConjunto.jsp");
		}
		
		if(acao.equals("Voltar")){
			session.setAttribute("lista", null);
			view = request.getRequestDispatcher("ListaConjuntos.jsp");
		}

		view.forward(request, response);

	}

}