package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JanelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JButton btnEntrar;
	private JLabel lblCadastro;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JanelaLogin() {
		
		setBounds(100, 100, 820, 568);
	
		setBackground(new Color(234, 253, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		
		
		JLabel lblMercado = new JLabel("REDE MAIK");
		lblMercado.setForeground(new Color(255, 0, 0));
		lblMercado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMercado.setBounds(77, 11, 104, 22);
		add(lblMercado);
		
		JLabel lblSlogan = new JLabel("Sempre do seu lado");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSlogan.setBounds(77, 37, 123, 14);
		add(lblSlogan);
		
		tfNome = new JTextField();
		tfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		tfNome.setName("");
		tfNome.setToolTipText("Nome");
		tfNome.setBounds(179, 159, 487, 37);
		add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setEnabled(false);
		tfCpf.setToolTipText("CPF");
		tfCpf.setDragEnabled(true);
		tfCpf.setColumns(10);
		tfCpf.setBounds(179, 248, 487, 37);
		
		add(tfCpf);
		
		btnEntrar = new JButton("");
		btnEntrar.setBorderPainted(false);
		btnEntrar.setEnabled(false);
		btnEntrar.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/Entrar.png")));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(255, 0, 0));
		btnEntrar.setBounds(277, 338, 264, 50);
		
		add(btnEntrar);
		
		JLabel lblTextCadastro = new JLabel("Não possui cadastro?");
		lblTextCadastro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTextCadastro.setBounds(287, 400, 165, 14);
		add(lblTextCadastro);
		
		lblCadastro = new JLabel("Cadastrar");
		lblCadastro.setBackground(new Color(0, 128, 255));
		lblCadastro.setForeground(new Color(0, 128, 255));
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCadastro.setBounds(458, 399, 83, 16);
		add(lblCadastro);
		
		JLabel lblEmpresa = new JLabel("Maker by Cybernooste Technologies Solutions");
		lblEmpresa.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmpresa.setBounds(270, 511, 271, 11);
		add(lblEmpresa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/LogoSuperMercado.png")));
		lblNewLabel.setBounds(27, 11, 56, 40);
		add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNome.setBounds(108, 163, 60, 22);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCpf.setBounds(128, 252, 41, 22);
		add(lblCpf);
	}
	public void logar(ActionListener actionListener) {
		this.btnEntrar.addActionListener(actionListener);
	}
	public String getNome() {
		return this.tfNome.getText();
	}
	public void setNome() {
		this.tfNome.setText("");
	}
	public String getCpf() {
		return this.tfCpf.getText();
	}
	public void setCpf() {
		this.tfCpf.setText("");
	}
	public void limparFormulario() {
		this.tfNome.setText("");
		this.tfCpf.setText("");
	}
	public JTextField getTfNome() {
		return this.tfNome;
	}
	public JTextField getTfCpf() {
		return this.tfCpf;
	}
	public JButton getBotaoEntrar() {
		return this.btnEntrar;
	}
	public void ativaCpf(KeyListener kLis) {
		this.tfNome.addKeyListener(kLis);
	}
	public void ativaBotao(KeyListener kLis) {
		this.tfCpf.addKeyListener(kLis);
	}
	public void irParaCadastro(MouseListener mouseListener) {
		this.lblCadastro.addMouseListener(mouseListener);
	}
	
}
