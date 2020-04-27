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
 * Servlet implementation class DeletarNoticia
 */
@WebServlet("/DeletarNoticia.do")
public class DeletarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instanciando o PrintWriter para saída de dados;
		PrintWriter saida = response.getWriter();
		
		// Recebendo parâmetros do html
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Instanciando a classe Noticia e atribuindo valores a ela;
		Noticia news = new Noticia();
		
		news.setNoticiaId(id);
		
		// Instanciando a classe service de Noticia;
		NoticiaService serv = new NoticiaService();
		
		// Enviando a classe para a service;
		serv.deletarNoticia(news);
		
		// Imprimindo o êxito da ação
		saida.print("Notícia excluída com sucesso!" + "<br>" + "<br>" +
				"<button   onclick=\"window.location.href = 'menu.html'\">Voltar</button>");
	}

}
