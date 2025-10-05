package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Usuario;
import model.UsuarioDAO;
import view.JanelaLogin;

public class LoginController {
	private final JanelaLogin view;
	private final UsuarioDAO model;
	private final Navegador navegador;
	private static String salvaCliente;

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
		this.view.irParaCadastro(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				navegador.navegarPara("CADASTRO");
			}
		});
	}

	public static String getSalvaCliente() {
		return salvaCliente;
	}

	public static void setSalvaCliente(String salvaCli) {
		salvaCliente = salvaCli;
	}

}
