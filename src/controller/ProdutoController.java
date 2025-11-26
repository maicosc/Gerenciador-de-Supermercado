package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.CarrinhoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import view.JanelaCadastroProduto;
import view.*;
import excecoespersonalizadas.*;

public class ProdutoController {
	private final JanelaCadastroProduto view;
	private final ProdutoDAO model;
	private final Navegador navegador;
	private final JanelaCompra jC;
	private final JanelaCarrinho jCarr;
	private final CarrinhoDAO cDAO;
	private DefaultListModel<Produto> lstM;
	private boolean estaSelect = false;
	

	public ProdutoController(JanelaCadastroProduto view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		lstM = new DefaultListModel<Produto>();
		JTextField tNomeProd = this.view.getTfNomeProduto();
		JTextField tPreco = this.view.getTfPreco();
		JTextField tQuant = this.view.getTfQuantidade();
		JTextField tCodProd = this.view.getTfCodProd();
		JButton bAdi = this.view.getBtnAdicionarProduto();
		JButton bAtu = this.view.getBtnAtualizarProduto();
		JButton bDel = this.view.getBtnDeletarProduto();
		JList lista = this.view.getList();
		jC = new JanelaCompra();
		jCarr = new JanelaCarrinho();
		cDAO = new CarrinhoDAO();
		String [] opcoes = {"Sim", "Não"};
		
		
		carregarProdutosNaLista();

		this.view.setListaModeloProduto(lstM);
		
		lista.addListSelectionListener(e -> {
		    Produto p = (Produto) lista.getSelectedValue();
		    tNomeProd.setEnabled(true);
			tPreco.setEnabled(true);
			tQuant.setEnabled(true);
			estaSelect = true;
		    atualizaDeleta(bAdi, bAtu, bDel, lista, view, p);
		});
		
		lista.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2) {
					
					limparTudo(view, tNomeProd, tPreco, tQuant, tCodProd, bAdi, bAtu, bDel, lista);
					
				}
			}
		});

		this.view.cadastrarProduto(e -> {
			String nomeProduto = view.getNomeProduto();
			String quantidade = view.getQuantidade();
			String preco = view.getPreco().trim().replace(',', '.');
			String codProd = view.getCodProd();

			if (!nomeProduto.trim().isEmpty()&& !quantidade.trim().isEmpty() && !preco.trim().isEmpty() && !codProd.trim().isEmpty()) {

				boolean existe =false;
				for (Produto p : model.listarProdutos()) {
					if (p.getNomeProd().equalsIgnoreCase(nomeProduto)) {
						existe =true;
					}
				}
				for (Produto p : model.listarProdutos()) {
					if (p.getCodProd() == Integer.parseInt(codProd)) {
						existe =true;
					}
				}
				if(existe) {
					
					JOptionPane.showMessageDialog(bAdi, "Já existe um produto com este código ou nome", "Produto existente", JOptionPane.WARNING_MESSAGE);
				}else {
					try {
						Produto p = new Produto(nomeProduto, Integer.parseInt(quantidade), Double.parseDouble(preco),
								Integer.parseInt(codProd));
						this.model.adicionarProduto(p);
						JOptionPane.showMessageDialog(view, "Produto adicionado!", "Produtos atualizados", JOptionPane.INFORMATION_MESSAGE);
						this.view.limparFormulario();
						carregarProdutosNaLista();
						this.view.setListaModeloProduto(lstM);
						CompraController cCon = new CompraController(jC, jCarr , cDAO , navegador);
						cCon.carregarProdutosNaLista();
						jC.setListaModelo(lstM);
						if(!codProd.matches("\\d{5}")) {
							
							throw new ExcecaoR("O código deve conter apenas 5 números!");
						}
						
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tCodProd, err.getMessage(), "Erro de estrutura",JOptionPane.WARNING_MESSAGE);
						tCodProd.setText("");
					}
					 
					
				}
				
				
				limparTudo(view, tNomeProd, tPreco, tQuant, tCodProd, bAdi, bAtu, bDel, lista);
			}
		});
		this.view.atualizarProduto(e -> {
			Produto selecionado = this.view.getProdutoSelecionado();
			String nomeProduto = view.getNomeProduto();
			String quantidade = view.getQuantidade();
			String preco = view.getPreco().trim().replace(',', '.');
			
			try {
				Produto p = new Produto(nomeProduto, Integer.parseInt(quantidade), Double.parseDouble(preco),
						selecionado.getCodProd());
				this.model.atualizarProduto(p);
				JOptionPane.showMessageDialog(view, "Produto atualizado!", "Produtos atualizados", JOptionPane.INFORMATION_MESSAGE);
				carregarProdutosNaLista();
				this.view.setListaModeloProduto(lstM);
				CompraController cCon = new CompraController(jC, jCarr , cDAO , navegador);
				cCon.carregarProdutosNaLista();
				jC.setListaModelo(lstM);
			
			
			
			limparTudo(view, tNomeProd, tPreco, tQuant, tCodProd, bAdi, bAtu, bDel, lista);
				if(!!nomeProduto.trim().isEmpty() && !!quantidade.trim().isEmpty() && !!preco.trim().isEmpty()) {
					
					throw new ExcecaoR("Não deixe campos vazios!");
				}
				
			}catch(ExcecaoR err) {
				JOptionPane.showMessageDialog(tNomeProd, err.getMessage() , "Campo vazio", JOptionPane.WARNING_MESSAGE);
			}

			
		});
		this.view.deletarProduto(e -> {
			
			int escolha = JOptionPane.showOptionDialog(view, "Deseja excluir este produto?", "Excluir produto",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
			
			if(escolha == JOptionPane.YES_OPTION) {
				Produto selecionado = this.view.getProdutoSelecionado();
				model.excluirProduto(selecionado.getCodProd());
				JOptionPane.showMessageDialog(view, "Produto excluído!", "Produtos atualizados", JOptionPane.INFORMATION_MESSAGE);
				carregarProdutosNaLista();
				this.view.setListaModeloProduto(lstM);
				CompraController cCon = new CompraController(jC, jCarr , cDAO , navegador);
				cCon.carregarProdutosNaLista();
				jC.setListaModelo(lstM);
			}
			
			
			limparTudo(view, tNomeProd, tPreco, tQuant, tCodProd, bAdi, bAtu, bDel, lista);
		});
		this.view.deslogar(e -> {
			limparTudo(view, tNomeProd, tPreco, tQuant, tCodProd, bAdi, bAtu, bDel, lista);
			navegador.navegarPara("LOGIN");
		});
		
		this.view.ativaPreco(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String nomeProd = view.getNomeProduto();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if (!!nomeProd.trim().isEmpty()) {
							throw new ExcecaoR("Digite o nome do produto!");
						}
						if(!nomeProd.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+")) {
							tNomeProd.setText("");
							throw new ExcecaoR("O nome do produto deve conter apenas letras!");
							
						}
						boolean existe =false;
						for (Produto p : model.listarProdutos()) {
							if (p.getNomeProd().equalsIgnoreCase(nomeProd)) {
								existe =true;
							}
						}
						if(existe) {
							throw new ExcecaoR("Já existe um produto com este nome");
						}
						tPreco.setEnabled(true);
						tPreco.requestFocus();	
						
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tNomeProd,err.getMessage() , "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
				}
		});
		this.view.ativaQuantidade(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String preco = view.getPreco();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						if (!!preco.trim().isEmpty()) {
							throw new ExcecaoR("Digite o preço do produto!");
						}
						if(!preco.matches("\\d+([.,]\\d{1,2})?")) {
							tPreco.setText("");
							throw new ExcecaoR("O preco deve conter apenas números com duas casas decimais!");
						}
						tQuant.setEnabled(true);
						tQuant.requestFocus();
						
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tPreco, err.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
				}
		});
		this.view.ativaCodigo(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String quant = view.getQuantidade();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						if (!!quant.trim().isEmpty()) {
							throw new ExcecaoR("Digite a quantidade!");
						}
						if(!quant.matches("\\d+")) {
							tQuant.setText("");
							throw new ExcecaoR("A quantidade deve conter apenas números inteiros!");
						}
						if(!estaSelect) {
							tCodProd.setEnabled(true);
							tCodProd.requestFocus();
						}
						
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tQuant, err.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
				}
		});
		this.view.ativaAdicionar(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				String codProd = view.getCodProd();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if (!!codProd.trim().isEmpty()) {
							throw new ExcecaoR("Digite o código do produto!");
						}
						if(!codProd.matches("\\d{5}")) {
							tCodProd.setText("");
							throw new ExcecaoR("O código deve conter apenas 5 números!");
						}
						boolean existe =false;
						for (Produto p : model.listarProdutos()) {
							if (p.getCodProd() == Integer.parseInt(codProd)) {
								existe =true;
							}
						}
						if(existe) {
							throw new ExcecaoR("Já existe um produto com este código");
						}
						bAdi.setEnabled(true);
						
					}catch(ExcecaoR err) {
						JOptionPane.showMessageDialog(tCodProd,err.getMessage() , "ERROR",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
				}
		});

	}

	private void limparTudo(JanelaCadastroProduto view, JTextField tNomeProd, JTextField tPreco, JTextField tQuant,
			JTextField tCodProd, JButton bAdi, JButton bAtu, JButton bDel, JList lista) {
		lista.clearSelection();
		view.limparFormulario();
		tNomeProd.setEnabled(true);
		tPreco.setEnabled(false);
		tQuant.setEnabled(false);
		tCodProd.setEnabled(false);
		bAdi.setEnabled(true);
		bAtu.setEnabled(false);
		bDel.setEnabled(false);
		estaSelect = false;
	}

	public void carregarProdutosNaLista() {
		lstM.clear();
		for (Produto p : model.listarProdutos()) {
			lstM.addElement(p);
		}

	}
	
	public void atualizaDeleta(JButton bAdi, JButton bAtu, JButton bDel, JList l, JanelaCadastroProduto jcp, Produto p) {
		if(!l.isSelectionEmpty()) {
			bAdi.setEnabled(false);
			bAtu.setEnabled(true);
			bDel.setEnabled(true);
			jcp.preencherFormulario(p);
			jcp.getTfCodProd().setEnabled(false);
		}
	}

}
