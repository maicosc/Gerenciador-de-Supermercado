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
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

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
		setLayout(new MigLayout("", "[90px,grow][90px,grow][90px,grow][90px,grow][100px,grow][90px,grow][90px,grow][90px,grow][90px,grow]", "[71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/LogoSuperMercado.png")));
		add(lblNewLabel, "flowy,cell 0 0 1 5,alignx center,aligny top");
		
		tfNome = new JTextField();
		tfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNome, "cell 1 3,alignx right,aligny center");
		tfNome.setName("");
		tfNome.setToolTipText("Nome");
		add(tfNome, "cell 2 3 6 1,grow");
		tfNome.setColumns(10);
		
		btnEntrar = new JButton("");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblCpf, "cell 1 4,alignx right,aligny center");
		
		tfCpf = new JTextField();
		tfCpf.setEnabled(false);
		tfCpf.setToolTipText("CPF");
		tfCpf.setDragEnabled(true);
		tfCpf.setColumns(10);
		
		add(tfCpf, "cell 2 4 6 1,grow");
		
		JLabel lblTextCadastro = new JLabel("Não possui cadastro?");
		lblTextCadastro.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblTextCadastro, "flowx,cell 4 5,alignx center,aligny center");
		btnEntrar.setBorderPainted(false);
		btnEntrar.setEnabled(false);
		btnEntrar.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/Entrar.png")));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(234, 253, 255));
		
		add(btnEntrar, "cell 4 6,grow");
		
		lblCadastro = new JLabel("Cadastrar");
		lblCadastro.setBackground(new Color(0, 128, 255));
		lblCadastro.setForeground(new Color(0, 128, 255));
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 15));
		add(lblCadastro, "cell 4 5,alignx center,aligny center");
		
				
				
				JLabel lblMercado = new JLabel("REDE MAIK");
				lblMercado.setForeground(new Color(255, 0, 0));
				lblMercado.setFont(new Font("Tahoma", Font.BOLD, 18));
				add(lblMercado, "cell 0 0,alignx left,aligny top");
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
