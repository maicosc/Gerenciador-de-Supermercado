package controller;

import model.Produto;
import model.ProdutoDAO;
import view.JanelaCadastroProduto;


public class ProdutoController {
	private final JanelaCadastroProduto view;
	private final ProdutoDAO model;
	private final Navegador navegador;

	
	public ProdutoController(JanelaCadastroProduto view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		
		this.view.cadastrarProduto(e -> {
			String nomeProduto = view.getTfNomeProduto();
			String quantidade = view.getTfQuantidade();
			String preco = view.getTfPreco();
			String codProd = view.getTfCodProd();

			if(!nomeProduto.equals("") &&
					!quantidade.equals("") &&
					!preco.equals("") && !codProd.equals("")) {

				Produto p = new Produto(nomeProduto, Integer.parseInt(quantidade), Double.parseDouble(preco), Integer.parseInt(codProd));
				this.model.adicionarProduto(p);

				this.view.limparFormulario();
				
			}
		});
		this.view.atualizarProduto(e -> {
		    
		String nomeProduto = view.getTfNomeProduto();
			String quantidade = view.getTfQuantidade();
			String preco = view.getTfPreco();
			String codProd = view.getTfCodProd();

			if(!nomeProduto.equals("") &&
					!quantidade.equals("") &&
					!preco.equals("") && !codProd.equals("")) {

				Produto p = new Produto(nomeProduto, Integer.parseInt(quantidade), Double.parseDouble(preco), Integer.parseInt(codProd));
				this.model.atualizarProduto(p);

				this.view.limparFormulario();
					}
					});
				this.view.deletarProduto(e->{
				    model.excluirProduto(Integer.parseInt(view.getTfCodProd()));
				});
			this.view.deslogar( e->{
				navegador.navegarPara("LOGIN");
			});
				
			
	}

}
