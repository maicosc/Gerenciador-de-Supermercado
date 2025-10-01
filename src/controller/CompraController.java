package controller;

import javax.swing.*;

import model.Carrinho;
import model.CarrinhoDAO;
import model.Produto;
import model.ProdutoDAO;
import view.JanelaCarrinho;
import view.JanelaCompra;
import controller.LoginController;

public class CompraController {
	private final JanelaCompra view;
	private final JanelaCarrinho view2;
	private final CarrinhoDAO model;
	private final Navegador navegador;
	private final ProdutoDAO prodD;
	private DefaultListModel<Produto> lstM;
	private DefaultListModel<Carrinho> lstMC;
	private LoginController login;

	public CompraController(JanelaCompra view, JanelaCarrinho view2, CarrinhoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.view2 = view2;
		this.prodD = new ProdutoDAO();
		lstM = new DefaultListModel<Produto>();
		lstMC = new DefaultListModel<Carrinho>();
		
		carregarProdutosNaLista();

		this.view.setListaModelo(lstM);
		
		carregarProdutosNaListaCarrinho();
		this.view2.setListaModeloCarrinho(lstMC);
		
		this.view.abrirCarrinho(e->{
			navegador.abrirJanela(view2);
		});

		this.view2.atualizarProdutoEmCarrinho(e -> {

			Carrinho selecionado = view2.getProdutoSelecionadoCar();

			if (selecionado != null) {
				String quantidade = JOptionPane.showInputDialog(view, "Informe a nova quantidade:", "Quantidade",
						JOptionPane.QUESTION_MESSAGE);

				if (quantidade != null && !quantidade.trim().isEmpty()) {

					int q = Integer.parseInt(quantidade.trim());
					if (q > selecionado.getQuantidade()) {

						JOptionPane.showMessageDialog(view, "Quantidade selecionada excede a disponível!", "erro",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Carrinho c = new Carrinho(selecionado.getValorProduto(), selecionado.getNomeProduto(), q,
								selecionado.getCodProd(), login.getSalvaCliente());

						model.atualizarProdutoEmCarrinho(c);
					}

				}
			} else {
				JOptionPane.showMessageDialog(view, "Selecione um produto na lista!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		this.view.adicionarAoCarrinho(e -> {
			Produto selecionado = view.getProdutoSelecionado();

			if (selecionado != null) {
				String quantidade = javax.swing.JOptionPane.showInputDialog(view, "Informe a quantidade:", "Quantidade",
						JOptionPane.QUESTION_MESSAGE);

				if (quantidade != null && !quantidade.trim().isEmpty()) {

					int q = Integer.parseInt(quantidade.trim());
					if (q > selecionado.getQuantidade()) {

						JOptionPane.showMessageDialog(view, "Quantidade selecionada excede a disponível!", "erro",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Carrinho c = new Carrinho(selecionado.getPreco(), selecionado.getNomeProd(), q,
								selecionado.getCodProd(), login.getSalvaCliente());

						model.adicionarProdutoAoCarrinho(c);

					}

				}
			} else {
				JOptionPane.showMessageDialog(view, "Selecione um produto na lista!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		
		this.view2.deletarProdutoDoCarrinho(e->{
			int pCodPdt = this.view2.getProdutoSelecionadoCar().getCodProd();
			model.excluirProdutoDeCarrinho(pCodPdt, login.getSalvaCliente());
		});

	}

	public void carregarProdutosNaLista() {
		
		for (Produto p : prodD.listarProdutos()) {
			lstM.addElement(p);
		}

	}

	public void carregarProdutosNaListaCarrinho() {
		
		for (Carrinho c : model.mostrarCarrinho()) {
			if (c.getCpf().equals(login.getSalvaCliente())) {
				lstMC.addElement(c);
			}
		}

	}

}