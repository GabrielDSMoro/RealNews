package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comentario;
import service.ComentarioService;

/**
 * Servlet implementation class ComentarioServlet
 */
@WebServlet("/ComentarioServlet.do")
public class ComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instanciando a classe Comentario;
				 Comentario msg = new Comentario();
				
				// Capturando as informações inseridas nos campos;
				int notId = Integer.parseInt(request.getParameter("id"));
				String nome = request.getParameter("nome");
				String texto = request.getParameter("comentario");
				
				
				// Imputando as informações na instancia de Comentario:
				msg.setNome(nome);
				msg.setComentario(texto);
				msg.setNoticiaId(notId);
				
				// Instanciando a classe service de comentario;
				ComentarioService serv = new ComentarioService();
				
				// Enviando as informações para o banco de dados;
				serv.cadastrarComentario(msg);
				
				// Redirecionando o usuário para a listagem de notícias:
				response.sendRedirect("ListarNoticia.do");
	}

}
