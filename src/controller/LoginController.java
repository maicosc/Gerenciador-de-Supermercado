package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import model.UsuarioDAO;
import view.JanelaLogin;

public class LoginController {
	private final JanelaLogin view;
	private final UsuarioDAO model;
	private final Navegador navegador;

	public LoginController(JanelaLogin view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		
		JTextField tfCpf = this.view.getTfCpf();
		JTextField tfNome = this.view.getTfNome();
		JButton btnEntrar = this.view.getBotaoEntrar();
		

		this.view.ativaCpf(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String nome = view.getNome();
				boolean existe =false;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!nome.trim().isEmpty()) {
						for (Usuario usuario : model.listarUsuarios()) {
							if (usuario.getNome().equalsIgnoreCase(nome) ) {
								tfCpf.setEnabled(true);
								tfCpf.requestFocus();
								existe=true;
							}
						}
						if(!existe) {
							JOptionPane.showMessageDialog(tfNome, "Não existe um usuário com o nome \""+nome+"\"", "Nome encontrado", JOptionPane.ERROR_MESSAGE);
							tfNome.setText("");
						}
						
					} else {
						JOptionPane.showMessageDialog(tfNome, "Digite seu nome!", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		this.view.ativaBotao(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String cpf = view.getCpf();
				boolean existe =false;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!cpf.trim().isEmpty()) {
						
							if(cpf.matches("\\d{11}")) {
								for (Usuario usuario : model.listarUsuarios()) {
									if (usuario.getCpf().equalsIgnoreCase(cpf) ) {
										btnEntrar.setEnabled(true);
										existe=true;
									}
								}
								if(!existe) {
									JOptionPane.showMessageDialog(tfCpf, "Não existe um usuário com o CPF \""+cpf+"\"", "CPF não encontrado", JOptionPane.ERROR_MESSAGE);
									tfCpf.setText("");
								}
							} else {
								JOptionPane.showMessageDialog(tfCpf, "O CPF deve conter 11 números, sem simbolos ou letras", "Erro de tamanho", JOptionPane.ERROR_MESSAGE);
								tfCpf.setText("");
							}
							
					}
						
					 else {
						JOptionPane.showMessageDialog(tfCpf, "Digite seu CPF!", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				}
		});

		this.view.logar(e -> {
			String nome = view.getNome();
			String cpf = view.getCpf();

			if (!nome.trim().isEmpty() && !cpf.trim().isEmpty()) {
				boolean estaCorreto =false;
				for (Usuario usuario : model.listarUsuarios()) {
					if (usuario.getNome().equalsIgnoreCase(nome) && usuario.getCpf().equals(cpf)) {
						estaCorreto =true;
						if (usuario.getTipoUsuario().equalsIgnoreCase("Administrador")) {
							navegador.navegarPara("PRODUTOS");
						} else {
							navegador.setCpf(usuario.getCpf());
							navegador.setNome(usuario.getNome());
							navegador.navegarPara("COMPRA");
						}
					}
				}
				if(!estaCorreto) {
					JOptionPane.showMessageDialog(view, "Nome e cpf incorretos ou usuário não existente", "Erro ao fazer login", JOptionPane.WARNING_MESSAGE);
				}

				this.view.limparFormulario();

			}
		});
		this.view.irParaCadastro(new MouseAdapter() {

	@Override
	public void mouseClicked(MouseEvent e) {

		navegador.navegarPara("CADASTRO");
	}
});
		}

}
