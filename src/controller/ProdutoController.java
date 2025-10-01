package controller;

import javax.swing.DefaultListModel;

import model.Produto;
import model.ProdutoDAO;
import view.JanelaCadastroProduto;

public class ProdutoController {
	private final JanelaCadastroProduto view;
	private final ProdutoDAO model;
	private final Navegador navegador;
	private DefaultListModel<Produto> lstM;

	public ProdutoController(JanelaCadastroProduto view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		lstM = new DefaultListModel<Produto>();

		this.view.cadastrarProduto(e -> {
			String nomeProduto = view.getTfNomeProduto();
			String quantidade = view.getTfQuantidade();
			String preco = view.getTfPreco();
			String codProd = view.getTfCodProd();

			if (!nomeProduto.equals("") && !quantidade.equals("") && !preco.equals("") && !codProd.equals("")) {

				Produto p = new Produto(nomeProduto, Integer.parseInt(quantidade), Double.parseDouble(preco),
						Integer.parseInt(codProd));
				this.model.adicionarProduto(p);

				this.view.limparFormulario();

			}
		});
		this.view.atualizarProduto(e -> {

			String nomeProduto = view.getTfNomeProduto();
			String quantidade = view.getTfQuantidade();
			String preco = view.getTfPreco();
			String codProd = view.getTfCodProd();

			if (!nomeProduto.trim().isEmpty() && !quantidade.trim().isEmpty() && !preco.trim().isEmpty() && !codProd.trim().isEmpty()) {

				Produto p = new Produto(nomeProduto, Integer.parseInt(quantidade), Double.parseDouble(preco),
						Integer.parseInt(codProd));
				this.model.atualizarProduto(p);

				this.view.limparFormulario();
			}
		});
		this.view.deletarProduto(e -> {
			model.excluirProduto(Integer.parseInt(view.getTfCodProd()));
		});
		this.view.deslogar(e -> {
			navegador.navegarPara("LOGIN");
		});

	}

	public void carregarProdutosNaLista() {

		for (Produto p : model.listarProdutos()) {
			lstM.addElement(p);
		}

	}

}
