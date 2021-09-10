package trabalhos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;



public class BebidasGUI {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JTextPane txtpnInserirBebida;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextPane txtpnId;
	private JTextField textField;
	private JTextPane txtpnNome;
	private JTextField textField_1;
	private JTextPane txtpnTeorAlcoolico;
	private JTextField textField_2;
	private JPanel panel_5;
	private JTextPane txtpnTipo;
	private JTextField textField_3;
	private JPanel panel_6;
	private JTextPane txtpnPreo;
	private JTextField textField_4;
	private JPanel panel_7;
	private JTextPane txtpnEstoque;
	private JTextField textField_5;
	private JButton btnInserir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BebidasGUI window = new BebidasGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BebidasGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		txtpnInserirBebida = new JTextPane();
		panel.add(txtpnInserirBebida);
		txtpnInserirBebida.setText("Inserir Bebida ");
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		
		txtpnId = new JTextPane();
		txtpnId.setText("ID");
		panel_2.add(txtpnId);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		
		txtpnNome = new JTextPane();
		txtpnNome.setText("Nome");
		panel_3.add(txtpnNome);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		
		txtpnTeorAlcoolico = new JTextPane();
		txtpnTeorAlcoolico.setText("Teor Alcoolico");
		panel_4.add(txtpnTeorAlcoolico);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		
		txtpnTipo = new JTextPane();
		txtpnTipo.setText("Tipo");
		panel_5.add(txtpnTipo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_5.add(textField_3);
		
		panel_6 = new JPanel();
		panel.add(panel_6);
		
		txtpnPreo = new JTextPane();
		txtpnPreo.setText("Pre\u00E7o");
		panel_6.add(txtpnPreo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_6.add(textField_4);
		
		panel_7 = new JPanel();
		panel.add(panel_7);
		
		txtpnEstoque = new JTextPane();
		panel_7.add(txtpnEstoque);
		txtpnEstoque.setText("Estoque");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_7.add(textField_5);
		
		btnInserir = new JButton("Inserir");
		panel.add(btnInserir);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
	}

}
