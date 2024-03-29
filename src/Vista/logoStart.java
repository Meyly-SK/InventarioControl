package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

public class logoStart extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblProgress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logoStart frame = new logoStart();
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
	public logoStart() {
		setUndecorated(true);
		setBackground(new Color(255, 0, 255,0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 255,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProgress = new JLabel("0%");
		lblProgress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgress.setBounds(114, 232, 93, 48);
		contentPane.add(lblProgress);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(logoStart.class.getResource("/IMG/logoBanner.png")));
		lblNewLabel.setBounds(20, 78, 284, 167);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(logoStart.class.getResource("/IMG/circle.png")));
		lblNewLabel_1.setBounds(1, 1, 329, 329);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);
		chargeBar();
	}
	
	private void chargeBar() {
		Utils.chargeBar c = new Utils.chargeBar(lblProgress, this);
		Thread t = new Thread(c);
		t.start();
	}
}
