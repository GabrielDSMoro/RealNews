package models;

public class Comentario extends Noticia{

	private int comentarioId;
	private String nome;
	private String comentario;
	
	public Comentario() {}
	
	public Comentario(int noticiaId,int comentarioId, String nome, String comentario) {
		super(noticiaId);
		setComentarioId(comentarioId);
		setNome(nome);
		setComentario(comentario);
	}
	
	public int getComentarioId() {
		return this.comentarioId;
	}
	public String getNome() {
		return this.nome;
	}
	public String getComentario() {
		return this.comentario;
	}
	
	public void setComentarioId(int comentarioId) {
		this.comentarioId = comentarioId;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
