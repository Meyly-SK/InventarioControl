package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JSeparator;

public class mensajeReport extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitulo;
	private JTextArea txtErrorMessage;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			mensajeReport dialog = new mensajeReport();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public mensajeReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mensajeReport.class.getResource("/IMG/Logo_Icon2.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(13, 38, 1, 212);
		contentPanel.add(separator_1);

		lblTitulo = new JLabel("");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 414, 14);
		contentPanel.add(lblTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(18, 55, 398, 170);
		contentPanel.add(scrollPane);

		txtErrorMessage = new JTextArea();
		txtErrorMessage.setEditable(false);
		txtErrorMessage.setWrapStyleWord(true);
		txtErrorMessage.setBackground(Color.WHITE);
		scrollPane.setViewportView(txtErrorMessage);
		txtErrorMessage.setLineWrap(true);

		separator = new JSeparator();
		separator.setBounds(114, 26, 206, 2);
		contentPanel.add(separator);

		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(420, 36, 1, 214);
		contentPanel.add(separator_2);
	}

	public void setMessaje(String title, String Message) {
		this.setTitle(title);
		lblTitulo.setText(title);
		txtErrorMessage.setText(Message);
	}
}
