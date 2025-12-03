package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import model.Produto;
import javax.swing.ImageIcon;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

public class JanelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnDeslogar;
	private JButton btnCarrinho;
	private JButton btnAdicionarAoCarrinho;
	private JList<Produto> listProdutos;
	private JButton btnNotaFiscal;
	private JButton btnRecarregar;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCompra frame = new JanelaCompra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaCompra() {
		setBackground(new Color(234, 253, 255));
		
		setBounds(100, 100, 820, 568);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[50px,grow][66px,grow][471px,grow][10px,grow][60px,grow][80px,grow][63px,grow]", "[54px,grow][61px,grow][77px,grow][79px,grow][23px,grow][186px,grow]"));
		
		
		
		btnDeslogar = new JButton("");
		btnDeslogar.setBackground(new Color(234, 253, 255));
		btnDeslogar.setBorderPainted(false);
		btnDeslogar.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/icons8-sair-50.png")));
		add(btnDeslogar, "cell 0 0,grow");
		
		btnCarrinho = new JButton("");
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBackground(new Color(234, 253, 255));
		btnCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCarrinho.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/icons8-carrinho-de-compras-50 (2).png")));
		add(btnCarrinho, "cell 6 0,grow");
		
		listProdutos = new JList<Produto>();
		listProdutos.setBounds(43, 94, 554, 426);
	
		
		JScrollPane spLista = new JScrollPane();
		spLista.setViewportView(listProdutos);
		add(spLista, "cell 0 1 3 5,grow");
		
		btnRecarregar = new JButton("");
		btnRecarregar.setBorderPainted(false);
		btnRecarregar.setForeground(new Color(234, 253, 255));
		btnRecarregar.setBackground(new Color(234, 253, 255));
		btnRecarregar.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/icons8-reinicialização-50 (1).png")));
		add(btnRecarregar, "cell 4 1,grow");
		
		btnAdicionarAoCarrinho = new JButton("");
		btnAdicionarAoCarrinho.setBackground(new Color(234, 253, 255));
		btnAdicionarAoCarrinho.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/ADICIONAR_CARRINHO.png")));
		btnAdicionarAoCarrinho.setSelectedIcon(new ImageIcon(JanelaCompra.class.getResource("/images/ADICIONAR_CARRINHO.png")));
		btnAdicionarAoCarrinho.setBorderPainted(false);
		btnAdicionarAoCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdicionarAoCarrinho.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(btnAdicionarAoCarrinho, "cell 4 3 3 1,grow");
		
		JLabel lblTitulo = new JLabel("Compra de Produtos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo, "cell 2 0 3 1,grow");
		
		btnNotaFiscal = new JButton("");
		btnNotaFiscal.setBackground(new Color(234, 253, 255));
		btnNotaFiscal.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/PAGAR.png")));
		btnNotaFiscal.setBorderPainted(false);
		btnNotaFiscal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNotaFiscal.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(btnNotaFiscal, "cell 4 5 3 1,growx,aligny top");
	}
	public void deslogar(ActionListener actionListener) {
		this.btnDeslogar.addActionListener(actionListener);
	}
	public void recarregarLista(ActionListener actionListener) {
		this.btnRecarregar.addActionListener(actionListener);
	}
	public void abrirCarrinho(ActionListener actionListener) {
		this.btnCarrinho.addActionListener(actionListener);
	}
	public void adicionarAoCarrinho(ActionListener actionListener) {
		this.btnAdicionarAoCarrinho.addActionListener(actionListener);
	}
	public void emitirNotaFiscal(ActionListener actionListener) {
		this.btnNotaFiscal.addActionListener(actionListener);
	}

	public void setListaModelo(DefaultListModel<Produto> modelo) {
	    listProdutos.setModel(modelo);
	}

	public Produto getProdutoSelecionado() {
	    return listProdutos.getSelectedValue();
	}

	public JList<Produto> getListProdutos() {
		return listProdutos;
	}
}
