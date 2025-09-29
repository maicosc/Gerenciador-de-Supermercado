package controller;

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

		
		this.view.cadastrar(e -> {
			String nome = view.getNome();
			String cpf = view.getCpf();
			String tipoUser = view.getTipoUser();

			if(!nome.equals("") &&
					!cpf.equals("") &&
					!tipoUser.equals("")) {

				Usuario u = new Usuario(nome, cpf, tipoUser);
				this.model.adicionarUsuario(u);

				this.view.limparFormulario();
				
			}
		});
	}

}
