package controller;

import model.Usuario;
import model.UsuarioDAO;
import view.JanelaLogin;

public class LoginController {
	private final JanelaLogin view;
	private final UsuarioDAO model;
	private final Navegador navegador;
	private String salvaCliente;

	public LoginController(JanelaLogin view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		this.view.logar(e -> {
			String nome = view.getNome();
			String cpf = view.getCpf();

			if (!nome.equals("") && !cpf.equals("")) {

				for (Usuario usuario : model.listarUsuarios()) {
					if (usuario.getNome().equalsIgnoreCase(nome) && usuario.getCpf().equals(cpf)) {
						if (usuario.getTipoUsuario().equalsIgnoreCase("Administrador")) {
							navegador.navegarPara("PRODUTOS");
						} else {
							setSalvaCliente(usuario.getCpf());
							navegador.navegarPara("COMPRA");
						}
					}
				}

				this.view.limparFormulario();

			}
		});
		this.view.irParaCadastro(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {

				navegador.navegarPara("CADASTRO");
			}
		});
	}

	public String getSalvaCliente() {
		return salvaCliente;
	}

	public void setSalvaCliente(String salvaCliente) {
		this.salvaCliente = salvaCliente;
	}

}
