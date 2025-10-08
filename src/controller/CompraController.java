package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		JList lista = this.view.getListProdutos();
		
		lstM = new DefaultListModel<Produto>();
		lstMC = new DefaultListModel<Carrinho>();
		String[] opcoes = { "Pagar", "Cancelar" };

		carregarProdutosNaLista();

		this.view.setListaModelo(lstM);

		lista.addListSelectionListener(e -> {
			Produto p = (Produto) lista.getSelectedValue();
			if (p != null) {
				JOptionPane.showMessageDialog(view2,
						p.getNomeProd().toUpperCase() + "\nPreço: R$ " + p.getPreco() + "\nQuantidade disponível: "
								+ p.getQuantidade() + "\nCódigo do Produto: " + p.getCodProd(),
						"Produto", JOptionPane.DEFAULT_OPTION);
			}

		});

		lista.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					lista.clearSelection();

				}
			}
		});

		this.view.abrirCarrinho(e -> {
			navegador.abrirJanela(view2);
			carregarProdutosNaListaCarrinho();
			this.view2.setListaModeloCarrinho(lstMC);
			this.view2.setLblValorTotal(
					"Valor Total: R$ " + String.format("%.2f", model.valorTotalDoCarrinho(navegador.getCpf())));
		});

		this.view2.atualizarProdutoEmCarrinho(e -> {

			Carrinho selecionado = view2.getProdutoSelecionadoCar();

			if (selecionado != null) {
				String quantidade = JOptionPane.showInputDialog(view2, "Informe a nova quantidade:", "Quantidade",
						JOptionPane.QUESTION_MESSAGE);

				if (quantidade != null && !quantidade.trim().isEmpty()) {

					if (quantidade.matches("\\d+")) {
						int q = Integer.parseInt(quantidade.trim());
						if (q > selecionado.getQuantidade()) {

							JOptionPane.showMessageDialog(view2, "Quantidade selecionada excede a disponível!", "erro",
									JOptionPane.WARNING_MESSAGE);
						} else {

							int qVolta = selecionado.getQuantidade() - q;
							Produto p = prodD.getProduto(selecionado.getCodProd());
							prodD.atualizarQuantidadeProd(selecionado.getCodProd(), p.getQuantidade() + qVolta);
							model.atualizarProdutoEmCarrinho(q, selecionado.getId());
							JOptionPane.showMessageDialog(view2, "Produto atualizado!", "Carrinho atualizado",
									JOptionPane.INFORMATION_MESSAGE);
							carregarProdutosNaListaCarrinho();
							this.view2.setListaModeloCarrinho(lstMC);
							carregarProdutosNaLista();
							this.view.setListaModelo(lstM);
							this.view2.setLblValorTotal("Valor Total: R$ "
									+ String.format("%.2f", model.valorTotalDoCarrinho(navegador.getCpf())));

						}
					} else {
						JOptionPane.showMessageDialog(view2, "Este campo aceita somente números inteiros positivos!",
								"Aviso", JOptionPane.WARNING_MESSAGE);
					}

				}
			} else {
				JOptionPane.showMessageDialog(view2, "Selecione um produto na lista!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		this.view.adicionarAoCarrinho(e -> {
			Produto selecionado = view.getProdutoSelecionado();

			if (selecionado != null) {
				String quantidade = JOptionPane.showInputDialog(view, "Informe a quantidade:", "Quantidade",
						JOptionPane.QUESTION_MESSAGE);

				if (quantidade != null && !quantidade.trim().isEmpty()) {

					if (quantidade.matches("\\d+")) {
						int q = Integer.parseInt(quantidade.trim());
						if (q > selecionado.getQuantidade()) {

							JOptionPane.showMessageDialog(view, "Quantidade selecionada excede a disponível!", "erro",
									JOptionPane.WARNING_MESSAGE);
						} else {
							
							boolean existe = false;
							Carrinho c = new Carrinho(selecionado.getPreco(), selecionado.getNomeProd(), q,
									selecionado.getCodProd(), navegador.getCpf());
							prodD.atualizarQuantidadeProd(selecionado.getCodProd(), selecionado.getQuantidade() - q);
							JOptionPane.showMessageDialog(view, "Produto adicionado ao carrinho", "Carrinho atualizado",
									JOptionPane.INFORMATION_MESSAGE);
							for (Carrinho carr : model.mostrarCarrinho()) {
								if(carr.getCodProd() == c.getCodProd()) {
									
									model.atualizarProdutoEmCarrinho(carr.getQuantidade() + c.getQuantidade(), carr.getId());
									existe =true;
								}
							}
							carregarProdutosNaLista();
							this.view.setListaModelo(lstM);
							if(!existe) {
								model.adicionarProdutoAoCarrinho(c);
							}
							

						}
					} else {
						JOptionPane.showMessageDialog(view2, "Este campo aceita somente números inteiros positivos!",
								"Aviso", JOptionPane.WARNING_MESSAGE);
					}

				}
			} else {
				JOptionPane.showMessageDialog(view, "Selecione um produto na lista!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		this.view2.deletarProdutoDoCarrinho(e -> {
			Carrinho selecionado = view2.getProdutoSelecionadoCar();
			model.excluirProdutoDeCarrinho(selecionado.getId());
			JOptionPane.showMessageDialog(view2, "Produto excluído do carrinho!", "Carrinho atualizado",
					JOptionPane.DEFAULT_OPTION);
			carregarProdutosNaListaCarrinho();
			this.view2.setListaModeloCarrinho(lstMC);
			carregarProdutosNaLista();
			this.view.setListaModelo(lstM);
			this.view2.setLblValorTotal(
					"Valor Total: R$ " + String.format("%.2f", model.valorTotalDoCarrinho(navegador.getCpf())));
		});

		this.view.emitirNotaFiscal(e -> {
			int confirmacao = JOptionPane.showOptionDialog(view, stringNotaFiscal(), "Nota Fiscal",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
			if (confirmacao == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(view2, "Pagamento concluído", "Pagamento", JOptionPane.DEFAULT_OPTION);
				stringNotaFiscal();
				model.excluirTodosProdutosDeCarrinho(navegador.getCpf());
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
		String resultado = "-------- NOTA FISCAL --------\n-------- COMPRA FINALIZADA ----------\nCliente: "
				+ navegador.getNome() + " ------------------ CPF: " + navegador.getCpf() + "\n";
		for (Carrinho c : model.mostrarCarrinho()) {
			if (c.getCpf().equals(navegador.getCpf())) {
				resultado += "\nProduto: " + c.getNomeProduto() + " --------- Quantidade: " + c.getQuantidade()
						+ " --------- Valor: " + String.format("%.2f", c.getQuantidade() * c.getValorProduto());

			}
		}
		resultado += "\n\nVALOR TOTAL: " + valorTotalF();
		return resultado;
	}

	public String valorTotalF() {
		String valorTotalF = String.format("%.2f", model.valorTotalDoCarrinho(navegador.getCpf()));
		return valorTotalF;
	}

}