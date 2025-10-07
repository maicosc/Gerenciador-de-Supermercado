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

		
		
		JLabel lblNewLabel_1 = new JLabel("REDE MAIK");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(93, 11, 104, 22);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sempre do seu lado");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(93, 44, 97, 14);
		add(lblNewLabel_2);
		
		tfNome = new JTextField();
		tfNome.setName("");
		tfNome.setToolTipText("Nome");
		tfNome.setBounds(179, 159, 487, 37);
		add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setToolTipText("CPF");
		tfCpf.setDragEnabled(true);
		tfCpf.setColumns(10);
		tfCpf.setBounds(179, 248, 487, 37);
		
		add(tfCpf);
		
		btnEntrar = new JButton("");
		btnEntrar.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/Entrar.png")));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(255, 0, 0));
		btnEntrar.setBounds(277, 338, 264, 50);
		
		add(btnEntrar);
		
		JLabel lblNewLabel_3 = new JLabel("Não possui cadastro?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(287, 400, 165, 14);
		add(lblNewLabel_3);
		
		lblCadastro = new JLabel("Cadastrar");
		lblCadastro.setBackground(new Color(0, 128, 255));
		lblCadastro.setForeground(new Color(0, 128, 255));
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCadastro.setBounds(458, 399, 83, 16);
		add(lblCadastro);
		
		JLabel lblNewLabel_5 = new JLabel("Maker by Cybernooste Technologies Solutions");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(270, 511, 271, 11);
		add(lblNewLabel_5);
		
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
	public void irParaCadastro(MouseListener mouseListener) {
		this.lblCadastro.addMouseListener(mouseListener);
	}
	
}
