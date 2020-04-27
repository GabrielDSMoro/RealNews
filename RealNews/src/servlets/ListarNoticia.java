package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Noticia;
import models.Comentario;
import service.NoticiaService;
import service.ComentarioService;


/**
 * Servlet implementation class ListarNoticia
 */
@WebServlet("/ListarNoticia.do")
public class ListarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Instanciando o recurso de saída de dados;
		PrintWriter saida = response.getWriter();

		// Instanciando a classe Service de Noticia e Comentario;
		NoticiaService serv = new NoticiaService();
		ComentarioService com = new ComentarioService();
		
		// Retornando a lista de noticias:
		ArrayList<Noticia> lista = serv.listarNoticias();
		ArrayList<Comentario> lista2 = com.listarComentarios();
		for (Noticia news : lista) {
			
			saida.println("<h4>Id da Notícia:" + news.getNoticiaId()+ "</h4>"
			+ "<br><b>Descrição:</b> " + news.getDescricao() 
			+ "<br><b>Título:</b> " + news.getTitulo()
			+ "<br><b>Texto:</b> " + news.getTextoNoticia() + "<br>");
			
			
			
			for(Comentario msg : lista2) {

				if (msg.getNoticiaId() == news.getNoticiaId()) {
					saida.println("<br>Nome: " + msg.getNome()
					+ "<br>Comentário: " + msg.getComentario()
					+ "<br>N° Notícia: " + msg.getNoticiaId() + "<br>");
					
				}				
			}
			response.setContentType("text/html; charset=UTF-8");
			
			saida.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>Comentários</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<h2></h2>\r\n" + 
					"	<form action=\"ComentarioServlet.do\" method=\"post\">\r\n" + 
					"		<tr>\r\n" + 
					"			Id da Notícia:<input type=\"number\" name=\"id\" size=\"5\">\r\n" + 
					"		</tr>\r\n" + 
					"		<br> <br>\r\n" + 
					"		<tr>\r\n" + 
					"			Nome:\r\n" + 
					"			<input type=\"text\" name=\"nome\" size=\"20\">\r\n" + 
					"		</tr>\r\n" + 
					"		<br> <br>\r\n" + 
					"		<tr>\r\n" + 
					"			Comentário:\r\n" + 
					"			<textarea name=\"comentario\" rows=\"10\" cols=\"50\"></textarea>\r\n" + 
					"		</tr>\r\n" + 
					"		<br> <br> <input type=\"submit\" />\r\n" + 
					"	</form>\r\n" + 
					"<br>\r\n" + 
					"		<a href=\"menu.html\"><button>Voltar</button></a>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		}
	}
}
