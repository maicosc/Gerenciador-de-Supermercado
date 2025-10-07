package controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.Janela;


public class Navegador {

	private Janela janela;
	private String cpf;
	private String nome;
	

	
	public Navegador(Janela janela) {
		this.janela = janela;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}

	
	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void sair() {
		this.janela.dispose();
	}
	public void abrirJanela(JFrame jan) {
		jan.setVisible(true);
		jan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}