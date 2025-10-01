package main;

import java.awt.EventQueue;

import view.*;
import model.*;
import controller.*;

public class Main {

	public static void main(String[] args) {

		Janela janela = new Janela();
		Navegador navegador = new Navegador(janela);
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		JanelaLogin janelaLogin = new JanelaLogin();
		JanelaCadastro janelaCadastro = new JanelaCadastro();
		JanelaCadastroProduto janelaCadProd = new JanelaCadastroProduto();
		JanelaCompra janelaCompra = new JanelaCompra();
		JanelaCarrinho janelaCarrinho = new JanelaCarrinho();

		CadastroController cadastroController = new CadastroController(janelaCadastro, usuarioDAO, navegador);
		LoginController loginController = new LoginController(janelaLogin, usuarioDAO, navegador);
		ProdutoController produtoController = new ProdutoController(janelaCadProd, produtoDAO, navegador);
		CompraController compraController = new CompraController(janelaCompra, janelaCarrinho, carrinhoDAO, navegador);

		navegador.adicionarPainel("CADASTRO", janelaCadastro);
		navegador.adicionarPainel("PRODUTOS", janelaCadProd);
		navegador.adicionarPainel("COMPRA", janelaCompra);
		navegador.adicionarPainel("LOGIN", janelaLogin);

		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");

	}

}
