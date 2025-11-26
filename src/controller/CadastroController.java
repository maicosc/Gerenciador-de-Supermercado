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
import excecoespersonalizadas.*;

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

					try {
						if (!!nome.trim().isEmpty()) {
							throw new ExcecaoR("Digite seu nome!");
						}
						boolean existe = false;
						for (Usuario usuario : model.listarUsuarios()) {
							if (usuario.getNome().equalsIgnoreCase(nome)) {
								existe = true;
							}
						}
						if (existe) {
							throw new ExcecaoR("Já existe um usuário com este nome ");
						}
						tfCpf.setEnabled(true);
						tfCpf.requestFocus();
					} catch (ExcecaoR err) {
						JOptionPane.showMessageDialog(tfNome, err.getMessage(),
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		this.view.ativaRButtons(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String cpf = view.getCpf();

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						if (!!cpf.trim().isEmpty()) {
							throw new ExcecaoR("Digite seu CPF!");
						}
						if (!cpf.matches("\\d{11}")) {
							tfCpf.setText("");
							throw new ExcecaoR("O CPF deve conter 11 números, sem simbolos ou letras");
						}
						boolean existe = false;
						for (Usuario usuario : model.listarUsuarios()) {
							if (usuario.getCpf().equals(cpf)) {
								existe = true;
							}
						}
						if (existe) {
							throw new ExcecaoR("Já existe um usuário com este CPF");
						}
						rAdm.setEnabled(true);
						rCliente.setEnabled(true);
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tfCpf, err.getMessage(),
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}

			}
		});

		rAdm.addActionListener(e -> bCadas.setEnabled(true));
		rCliente.addActionListener(e -> bCadas.setEnabled(true));
		this.view.cadastrar(e ->

		{

			String nome = view.getNome();
			String cpf = view.getCpf();
			String tipoUser = view.getTipoUser();

			try {
				if (!!nome.trim().isEmpty() && !!cpf.trim().isEmpty() && !!tipoUser.trim().isEmpty()) {
					throw new ExcecaoR("Todos os campos devem estar preenchidos!");
				}
				boolean existe = false;
				for (Usuario usuario : model.listarUsuarios()) {
					if (usuario.getCpf().equals(cpf)) {
						existe = true;
					}
				}
				for (Usuario usuario : model.listarUsuarios()) {
					if (usuario.getNome().equalsIgnoreCase(nome)) {
						existe = true;
					}
				}
				if (existe) {
					throw new ExcecaoR("Já existe um usuário com este CPF e/ou nome ");
				}
				Usuario u = new Usuario(nome, cpf, tipoUser);
				this.model.adicionarUsuario(u);
				JOptionPane.showMessageDialog(view, "Cadastro concluído!", "Cadastro Feito",
						JOptionPane.INFORMATION_MESSAGE);
				this.view.limparFormulario();
				navegador.navegarPara("LOGIN");
				
			}catch(ExcecaoR err) {
				JOptionPane.showMessageDialog(bCadas, err.getMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
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
