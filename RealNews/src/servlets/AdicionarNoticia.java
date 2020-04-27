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
 * Servlet implementation class AdicionarNoticia
 */
@WebServlet("/AdicionarNoticia.do")
public class AdicionarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instanciando um PrintWriter para saída de dados;
		PrintWriter saida = response.getWriter();
		
		// Instanciando a classe Noticia;
		Noticia news = new Noticia();
		
		// Recebendo valores dos parametros do html;
		String titulo = request.getParameter("titulo");
		String desc = request.getParameter("desc");
		String noticia = request.getParameter("not");
		
		// Atribuindo os valores recebidos dos parâmetros à classe Noticia;
		news.setTitulo(titulo);
		news.setDescricao(desc);
		news.setTextoNoticia(noticia);
		
		// Instanciando a classe service de Noticia;
		NoticiaService serv = new NoticiaService();
		
		// Enviando os atributos para o banco de dados;
		serv.cadastrarNoticia(news);
		
		// Saída de dados confirmando o cadastro
		saida.print("Notícia adicionada com sucesso!" + "<br>" 
		+ "<button   onclick=\"window.location.href = 'menu.html'\">Voltar</button>");
	}

}
