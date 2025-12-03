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
import excecoespersonalizadas.*;

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
					try {
						if (!!nome.trim().isEmpty()) {
							throw new ExcecaoR("Digite seu nome!");
						}
						boolean ehNumero = true;
						char[] arrayNome = nome.toCharArray();
						for(int i=0; i<arrayNome.length; i++) {
							 for (char c : arrayNome) {
							      
							        if (Character.isDigit(c)) {
							            
							            throw new ExcecaoR("O nome não pode conter numeros! ");
							        }
							    }
						}
						for (Usuario usuario : model.listarUsuarios()) {
							if (usuario.getNome().equalsIgnoreCase(nome) ) {
								tfCpf.setEnabled(true);
								tfCpf.requestFocus();
								existe=true;
							}
						}
						if(!existe) {
							tfNome.setText("");
							throw new ExcecaoR("Não existe um usuário com o nome \""+nome+"\"");
							
						}
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tfNome, err.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		this.view.ativaBotao(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String cpf = view.getCpf();
				boolean existe =false;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if (!!cpf.trim().isEmpty()) {
							throw new ExcecaoR("Digite seu CPF!");
						}
						if(!cpf.matches("\\d{11}")) {
							tfCpf.setText("");
							throw new ExcecaoR("O CPF deve conter 11 números, sem simbolos ou letras");
						}
						for (Usuario usuario : model.listarUsuarios()) {
							if (usuario.getCpf().equalsIgnoreCase(cpf) ) {
								btnEntrar.setEnabled(true);
								existe=true;
							}
						}
						if(!existe) {
							tfCpf.setText("");
							throw new ExcecaoR("Não existe um usuário com o CPF \""+cpf+"\"");
						}
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tfCpf, err.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
				}
		});

		this.view.logar(e -> {
			String nome = view.getNome();
			String cpf = view.getCpf();
			
			try {
				if (!!nome.trim().isEmpty() && !!cpf.trim().isEmpty()) {
					throw new ExcecaoR("Nenhum campo pode ficar vazio!");
				}
				boolean ehNumero = true;
				char[] arrayNome = nome.toCharArray();
				for(int i=0; i<arrayNome.length; i++) {
					 for (char c : arrayNome) {
					      
					        if (Character.isDigit(c)) {
					            
					            throw new ExcecaoR("O nome não pode conter numeros! ");
					        }
					    }
				}
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
				this.view.limparFormulario();
				if(!estaCorreto) {
					throw new ExcecaoR("Nome e/ou cpf incorretos ou usuário não existente");
					
				}

				
			}catch(ExcecaoR err) {
				JOptionPane.showMessageDialog(view, err.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
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
