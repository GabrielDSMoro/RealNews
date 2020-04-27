package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import models.Comentario;

public class ComentarioService {

	// Instanciando a DAO da classe Comentario;
	ComentarioDAO dao = new ComentarioDAO();
	
	// Método para cadastrar o comentário:
	public void cadastrarComentario(Comentario msg) {
		if(msg.getNome().length() > 126 && msg.getNome().length() < 3) {
			return;
		}
		if(msg.getComentario().length() > 512 && msg.getComentario().length() < 3) {
			return;
		}
		dao.cadastrar(msg);
	}
	
	// Método para listar os comentários de uma notícia;
	public ArrayList<Comentario> listarComentarios(){
		dao.listarComentarios();
		return dao.listarComentarios();
	}
}
