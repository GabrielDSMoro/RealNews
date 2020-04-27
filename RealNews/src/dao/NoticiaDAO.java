package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Noticia;

import java.sql.ResultSet;

public class NoticiaDAO {

	private Connection conexao;

	public NoticiaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticia noticia) {

		String inserir = "INSERT INTO noticia " + " (id, descricao, titulo, texto) " + " VALUES (?, ?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, noticia.getNoticiaId());
			pst.setString(2, noticia.getDescricao());
			pst.setString(3, noticia.getTitulo());
			pst.setString(4, noticia.getTextoNoticia());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela noticia.");
			ex.printStackTrace();

		}
	}

	public void alterar(Noticia noticia) {

		String inserir = "UPDATE noticia " + "SET descricao = ?, titulo = ?, texto = ? " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTextoNoticia());
			pst.setInt(4, noticia.getNoticiaId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela noticia.");
			ex.printStackTrace();

		}
	}

	public void excluir(Noticia noticia) {

		String inserir = "DELETE FROM noticia " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, noticia.getNoticiaId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela noticia.");
			ex.printStackTrace();
		}
	}


	public ArrayList<Noticia> listarNoticias() {

		String inserir = "SELECT * FROM noticia";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			ResultSet resultado = pst.executeQuery();

			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia not = new Noticia();
				not.setNoticiaId(resultado.getInt("id"));
				not.setDescricao(resultado.getString("descricao"));
				not.setTitulo(resultado.getString("titulo"));
				not.setTextoNoticia(resultado.getString("texto"));
			
				lista.add(not);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela noticia.");
			ex.printStackTrace();

			return null;
		}
	}

}
