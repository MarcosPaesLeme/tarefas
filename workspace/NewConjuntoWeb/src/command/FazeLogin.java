package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class FazeLogin
 */
@WebServlet("/controller.do")
public class FazeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FazeLogin(){
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	execute(request, response);
    }


	public void execute(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("password");
		
		Usuario usuario = new Usuario(nome, senha);
		UsuarioService user = new UsuarioService();
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(user.validaUsuario(usuario)){
			session.setAttribute("logado", usuario);
			System.out.println("Logou "+usuario.getUsername());
		} else {
			System.out.println("Não Logou "+usuario);
			throw new ServletException("Usuário/Senha inválidos");
		}
		
		response.sendRedirect("index.jsp");
	}
}
