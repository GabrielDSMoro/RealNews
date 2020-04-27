package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Comentario;
import models.Noticia;

import java.sql.ResultSet;

public class ComentarioDAO {

	private Connection conexao;

	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario msg) {

		String inserir = "INSERT INTO comentario " + " (nome,texto,fk_noticia_id) " + " VALUES (?,?,?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, msg.getNome());
			pst.setString(2, msg.getComentario());
			pst.setInt(3, msg.getNoticiaId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela comentario.");
			ex.printStackTrace();

		}
	}
	public ArrayList<Comentario> listarComentarios() {

		String inserir = "SELECT * FROM comentario";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			ResultSet resultado = pst.executeQuery();

			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario msg = new Comentario();
				msg.setComentarioId(resultado.getInt("id"));
				msg.setNome(resultado.getString("nome"));
				msg.setComentario(resultado.getString("texto"));
				msg.setNoticiaId(resultado.getInt("fk_noticia_id"));
			
				lista.add(msg);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela comentario.");
			ex.printStackTrace();

			return null;
		}
	}
}
