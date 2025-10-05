package controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.Janela;


public class Navegador {

	private Janela janela;

	
	public Navegador(Janela janela) {
		this.janela = janela;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}

	
	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);
	}

	
	public void sair() {
		this.janela.dispose();
	}
	public void abrirJanela(JFrame jan) {
		jan.setVisible(true);
		jan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}