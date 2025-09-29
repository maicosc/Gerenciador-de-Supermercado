package model;

public class Usuario {

	private String nome,cpf,tipoUsuario;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome, String cpf, String tipoUsuario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.tipoUsuario = tipoUsuario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public void logar() {
		
	}
	public void deslogar() {
		
	}
}
