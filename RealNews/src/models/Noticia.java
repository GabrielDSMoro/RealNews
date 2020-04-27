package models;

public class Noticia {

	private int noticiaId;
	private String descricao;
	private String titulo;
	private String textoNoticia;
	
	public Noticia() {}
	
	public Noticia(int noticiaId, String descricao, String titulo, String textoNoticia) {
		setNoticiaId(noticiaId);
		setDescricao(descricao);
		setTitulo(titulo);
		setTextoNoticia(textoNoticia);
	}
	
	public Noticia(int noticiaId) {
		this.noticiaId = noticiaId;
	}

	public int getNoticiaId() {
		return this.noticiaId;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public String getTextoNoticia() {
		return this.textoNoticia;
	}
	
	public void setNoticiaId(int noticiaId) {
		this.noticiaId = noticiaId;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setTextoNoticia(String textoNoticia) {
		this.textoNoticia = textoNoticia;
	}
}
