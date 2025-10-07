package controller;

import java.util.Objects;

import javax.swing.*;

import model.Carrinho;
import model.CarrinhoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.JanelaCarrinho;
import view.JanelaCompra;
import view.JanelaLogin;
import controller.LoginController;

public class CompraController {
	private final JanelaCompra view;
	private final JanelaLogin viewUser;
	private final JanelaCarrinho view2;
	private final CarrinhoDAO model;
	private final Navegador navegador;
	private final ProdutoDAO prodD;
	private final UsuarioDAO userD;
	private DefaultListModel<Produto> lstM;
	private DefaultListModel<Carrinho> lstMC;
	private LoginController login;

	public CompraController(JanelaCompra view, JanelaCarrinho view2, CarrinhoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		this.view2 = view2;
		this.prodD = new ProdutoDAO();
		this.userD = new UsuarioDAO();
		this.viewUser = new JanelaLogin();
		lstM = new DefaultListModel<Produto>();
		lstMC = new DefaultListModel<Carrinho>();
		String [] opcoes = {"Pagar", "Cancelar"};
		
		
		carregarProdutosNaLista();

		this.view.setListaModelo(lstM);
		
		
		
		this.view.abrirCarrinho(e->{
			navegador.abrirJanela(view2);
			carregarProdutosNaListaCarrinho();
			this.view2.setListaModeloCarrinho(lstMC);
		});
		
		this.view2.setLblValorTotal("Valor Total: R$ " + valorTotalF());

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
						
						model.atualizarProdutoEmCarrinho(q, selecionado.getId());
						carregarProdutosNaListaCarrinho();
						this.view2.setListaModeloCarrinho(lstMC);
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
				String quantidade = JOptionPane.showInputDialog(view, "Informe a quantidade:", "Quantidade",
						JOptionPane.QUESTION_MESSAGE);

				if (quantidade != null && !quantidade.trim().isEmpty()) {

					int q = Integer.parseInt(quantidade.trim());
					if (q > selecionado.getQuantidade()) {

						JOptionPane.showMessageDialog(view, "Quantidade selecionada excede a disponível!", "erro",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Carrinho c = new Carrinho(selecionado.getPreco(), selecionado.getNomeProd(), q,
								selecionado.getCodProd(), navegador.getCpf());
						System.out.println("Adicionando produto ao carrinho: codProd = " + selecionado.getCodProd());
						model.adicionarProdutoAoCarrinho(c);

					}

				}
			} else {
				JOptionPane.showMessageDialog(view, "Selecione um produto na lista!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		
		this.view2.deletarProdutoDoCarrinho(e->{
			Carrinho selecionado = view2.getProdutoSelecionadoCar();
			model.excluirProdutoDeCarrinho(selecionado.getId());
		});
		
		this.view.emitirNotaFiscal(e -> {
			int confirmacao = JOptionPane.showOptionDialog(view, stringNotaFiscal(), "Nota Fiscal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
			if (confirmacao == JOptionPane.YES_OPTION) {
				stringNotaFiscal();
			}
		});

	}

	public void carregarProdutosNaLista() {
		lstM.clear();
		for (Produto p : prodD.listarProdutos()) {
			lstM.addElement(p);
		}

	}

	public void carregarProdutosNaListaCarrinho() {
		lstMC.clear();
		for (Carrinho c : model.mostrarCarrinho()) {
			if (c.getCpf().equals(navegador.getCpf())) {
				lstMC.addElement(c);
			}
		}

	}
	public String stringNotaFiscal() {
		String resultado = "Cliente: "+navegador.getNome()+"------------------ CPF: "+navegador.getCpf()+"\n\n";
		for (Carrinho c : model.mostrarCarrinho()) {
			if(c.getCpf().equals(navegador.getCpf())) {
				resultado += "\nProduto: " + c.getNomeProduto() +"--------- Quantidade: "+ c.getQuantidade()+"--------- Valor: "+String.format("%.2f", c.getQuantidade()*c.getValorProduto()); 
				
			}
		}
		resultado += "\n\n VALOR TOTAL: " + valorTotalF();
		return resultado;
	}
	public String valorTotalF() {
		String valorTotalF = String.format("%.2f", model.valorTotalDoCarrinho(navegador.getCpf()));
		return valorTotalF;
	}

}