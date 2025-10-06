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

public class JanelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnDeslogar;
	private JButton btnCarrinho;
	private JButton btnAdicionarAoCarrinho;
	private JList<Produto> listProdutos;
	private JButton btnNotaFiscal;



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

		
		setLayout(null);
		
		
		
		btnDeslogar = new JButton("");
		btnDeslogar.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/icons8-sair-50.png")));
		btnDeslogar.setBounds(10, 11, 50, 50);
		add(btnDeslogar);
		
		btnCarrinho = new JButton("");
		btnCarrinho.setBackground(new Color(234, 253, 255));
		btnCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCarrinho.setIcon(new ImageIcon(JanelaCompra.class.getResource("/images/icons8-carrinho-de-compras-50 (2).png")));
		btnCarrinho.setBounds(747, 11, 50, 50);
		add(btnCarrinho);
		
		listProdutos = new JList<Produto>();
		listProdutos.setBounds(43, 94, 554, 426);
	
		
		JScrollPane spLista = new JScrollPane();
		spLista.setBounds(43, 94, 554, 426);
		spLista.setViewportView(listProdutos);
		add(spLista);
		
		btnAdicionarAoCarrinho = new JButton("ADICIONAR");
		btnAdicionarAoCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdicionarAoCarrinho.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAdicionarAoCarrinho.setBounds(607, 232, 203, 79);
		add(btnAdicionarAoCarrinho);
		
		JLabel lblTitulo = new JLabel("Compra de Produtos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(126, 7, 541, 54);
		add(lblTitulo);
		
		btnNotaFiscal = new JButton("NOTA FISCAL");
		btnNotaFiscal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNotaFiscal.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNotaFiscal.setBounds(607, 334, 203, 79);
		add(btnNotaFiscal);
	}
	public void deslogar(ActionListener actionListener) {
		this.btnDeslogar.addActionListener(actionListener);
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
}
