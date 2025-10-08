package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Usuario;
import model.UsuarioDAO;
import view.JanelaCadastro;

public class CadastroController {
	private final JanelaCadastro view;
	private final UsuarioDAO model;
	private final Navegador navegador;

	public CadastroController(JanelaCadastro view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		JTextField tfNome = this.view.getTfNome();
		JTextField tfCpf = this.view.getTfCpf();
		JRadioButton rAdm = this.view.getRAdmin();
		JRadioButton rCliente = this.view.getRCliente();
		JButton bCadas = this.view.getBtnCadastro();
		
		this.view.ativaCpf(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String nome = view.getNome();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!nome.trim().isEmpty()) {
						
								tfCpf.setEnabled(true);
								tfCpf.requestFocus();				
					} else {
						JOptionPane.showMessageDialog(tfNome, "Digite seu nome!", "Campo Vazio", JOptionPane.ERROR_MESSAGE);
					}
			}
			}
		});
		
		this.view.ativaRButtons(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String cpf = view.getCpf();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!cpf.trim().isEmpty()) {
						
							if(cpf.matches("\\d{11}")) {
								
										rAdm.setEnabled(true);
										rCliente.setEnabled(true);
										
								
							} else {
								JOptionPane.showMessageDialog(tfCpf, "O CPF deve conter 11 números, sem simbolos ou letras", "Erro de tamanho", JOptionPane.ERROR_MESSAGE);
								tfCpf.setText("");
							}
							
					}
						
					 else {
						JOptionPane.showMessageDialog(tfCpf, "Digite seu CPF!", "Campo Vazio", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				}
		});

		rAdm.addActionListener(e -> bCadas.setEnabled(true));
		rCliente.addActionListener(e -> bCadas.setEnabled(true));
	this.view.cadastrar(e->

	{

		String nome = view.getNome();
		String cpf = view.getCpf();
		String tipoUser = view.getTipoUser();

		if (!nome.trim().isEmpty() && !cpf.trim().isEmpty() && !tipoUser.trim().isEmpty()) {

			Usuario u = new Usuario(nome, cpf, tipoUser);
			this.model.adicionarUsuario(u);
			JOptionPane.showMessageDialog(view, "Cadastro concluído!", "Cadastro Feito", JOptionPane.DEFAULT_OPTION);
			this.view.limparFormulario();
			navegador.navegarPara("LOGIN");

		}
	});
	this.view.irParaLogin(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			navegador.navegarPara("LOGIN");
		}
	});
}

}
