package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.event.Event;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.function.Consumer;
import java.util.function.Function;
import java.awt.Component;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

public class JanelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private String tipoUser;
	private ButtonGroup grupo;
	private JRadioButton rdbtnCliente, rdbtnAdm;
	private JLabel lblLogin;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public JanelaCadastro() {
		
		
		setBounds(100, 100, 820, 568);
		
		setBackground(new Color(234, 253, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[90px,grow][90px,grow][90px,grow][90px,grow][100px,grow][90px,grow 90][90px,grow 90][90px,grow 90][90px,grow 90]", "[71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow][71px,grow]"));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(JanelaLogin.class.getResource("/images/LogoSuperMercado.png")));
		add(lblIcon, "flowx,cell 0 0,alignx right,aligny center");
		
		grupo = new ButtonGroup();
		
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNome, "cell 0 2,alignx right,growy");
		
		tfNome = new JTextField();
		tfNome.setName("Nome");
		tfNome.setToolTipText("Nome");
		
			  
		add(tfNome, "cell 1 2 6 1,grow");
		tfNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setHorizontalTextPosition(SwingConstants.LEADING);
		lblCPF.setHorizontalAlignment(SwingConstants.LEFT);
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblCPF, "cell 0 3,alignx right,growy");
		
		tfCpf = new JTextField();
		tfCpf.setEnabled(false);
		tfCpf.setToolTipText("CPF");
		tfCpf.setDragEnabled(true);
		tfCpf.setColumns(10);
		
		add(tfCpf, "cell 1 3 6 1,grow");
		
		JLabel lblNomaInc = new JLabel("REDE MAIK");
		lblNomaInc.setForeground(new Color(255, 0, 0));
		lblNomaInc.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNomaInc, "cell 0 0,alignx left,aligny center");
		
		btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		rdbtnAdm = new JRadioButton("Administrador");
		rdbtnAdm.setEnabled(false);
		rdbtnAdm.setBackground(new Color(234, 253, 255));
		rdbtnAdm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(rdbtnAdm, "flowx,cell 4 4,alignx center,growy");
		grupo.add(rdbtnAdm);
		
		rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setEnabled(false);
		rdbtnCliente.setBackground(new Color(234, 253, 255));
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(rdbtnCliente, "cell 4 4,alignx right,growy");
		grupo.add(rdbtnCliente);
		
		JLabel lblTextLogin = new JLabel("Voltar para");
		lblTextLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTextLogin.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblTextLogin, "flowx,cell 4 5,alignx center,growy");
		
		lblLogin = new JLabel("login!");
		lblLogin.setForeground(new Color(0, 128, 255));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblLogin, "cell 4 5,alignx left,growy");
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setIcon(new ImageIcon(JanelaCadastro.class.getResource("/images/Cadastrar.png")));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setEnabled(false);
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(255, 0, 0));
		btnCadastrar.setBounds(289, 324, 264, 50);
		
		add(btnCadastrar, "cell 4 6");
		
		JLabel lblEmpresa = new JLabel("Maker by Cybernooste Technologies Solutions");
		lblEmpresa.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmpresa.setBounds(226, 471, 389, 37);
		add(lblEmpresa, "cell 4 8,growx,aligny center");
	}
	public void cadastrar(ActionListener actionListener) {
		this.btnCadastrar.addActionListener(actionListener);
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
	public JTextField getTfNome() {
		return tfNome;
	}
	public JTextField getTfCpf() {
		return tfCpf;
	}
	public JRadioButton getRAdmin() {
		return rdbtnAdm;
	}
	public JRadioButton getRCliente() {
		return rdbtnCliente;
	}
	
	public JButton getBtnCadastro() {
		return btnCadastrar;
	}
	
	public String getTipoUser() {
		if(rdbtnAdm.isSelected()) {
			return "ADMINISTRADOR";
		}else if (rdbtnCliente.isSelected()) {
			return "CLIENTE";
		}else {
			return null;
		}
		
	}
	public void setTipoUser(String text) {
		this.tipoUser = text;
	}
	public void ativaCpf(KeyListener kLis) {
		this.tfNome.addKeyListener(kLis);
	}
	
	public void ativaRButtons(KeyListener kLis) {
		this.tfCpf.addKeyListener(kLis);
	}
	
	public void limparFormulario() {
		this.tfNome.setText("");
		this.tfCpf.setText("");
		rdbtnAdm.setSelected(false);
		rdbtnCliente.setSelected(false);
	}
	public void irParaLogin(MouseListener mouseListener) {
		this.lblLogin.addMouseListener(mouseListener);
	}
}
