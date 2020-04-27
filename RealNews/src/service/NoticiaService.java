package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import models.Noticia;

public class NoticiaService {

	// Instanciando a classe DAO de Noticia;
	NoticiaDAO dao = new NoticiaDAO();
	
	// Método para cadastrar notícias;
	public void cadastrarNoticia(Noticia news) {
		if(news.getTitulo().length() > 126 && news.getTitulo().length() < 3) {
			return;
		}
		if(news.getDescricao().length() > 512 && news.getDescricao().length() < 3) {
			return;
		}
		if(news.getTextoNoticia().length() > 600 && news.getTextoNoticia().length() < 3) {
			return;
		}
		if(news.getDescricao() == null || news.getTitulo() == null || news.getTextoNoticia() == null) {
			return;
		}
		dao.cadastrar(news);
	}
	public void deletarNoticia(Noticia news) {
		if(news.getNoticiaId() == 0) {
			return;
		}
		dao.excluir(news);
	}
	public void editarNoticia(Noticia news) {
		if(news.getTitulo().length() > 126 && news.getTitulo().length() < 3) {
			return;
		}
		if(news.getDescricao().length() > 512 && news.getDescricao().length() < 3) {
			return;
		}
		if(news.getTextoNoticia().length() > 600 && news.getTextoNoticia().length() < 3) {
			return;
		}
		if(news.getDescricao() == null || news.getTitulo() == null || news.getTextoNoticia() == null) {
			return;
		}
		if(news.getNoticiaId() == 0) {
			return;
		}
		dao.alterar(news);
	}
	public ArrayList<Noticia> listarNoticias() {
		dao.listarNoticias();
		return dao.listarNoticias();
		
	}
}
