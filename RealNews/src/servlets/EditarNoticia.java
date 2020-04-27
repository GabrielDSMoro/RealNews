package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class EditarNoticia
 */
@WebServlet("/EditarNoticia.do")
public class EditarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instanciando um PrintWriter para saída de dados;
		PrintWriter saida = response.getWriter();
		
		// Capturando os parâmetros inseridos no html;
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("title");
		String desc = request.getParameter("desc");
		String noticia = request.getParameter("not");
		
		// Instanciando a classe Noticia e atribuindo valores a ela;
		Noticia news = new Noticia();
		
		news.setNoticiaId(id);
		news.setDescricao(desc);
		news.setTitulo(titulo);
		news.setTextoNoticia(noticia);
		
		// Instanciando a classe service de Noticia;
		NoticiaService serv = new NoticiaService();
		
		// Enviando as informações para a service;
		serv.editarNoticia(news);
		
		// Confirmação de êxito:
		saida.print("Notícia editada com sucesso!"  + "<br>" + 
				"<button   onclick=\"window.location.href = 'menu.html'\">Voltar</button>");
	}

}
