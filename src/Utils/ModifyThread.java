package Utils;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Vista.frmPrincipal;
import Vista.registrarCliente;
import Vista.registrarEmpleado;

public class ModifyThread implements Runnable {
	private JLabel img;
	private String ruta;
	private JTextField UserField;
	private JPasswordField passField;
	private JButton btnIngresar;
	private JButton button;
	private JPanel largo;
	private String name;
	private JLabel label;
	private JPanel panel;
	private registrarEmpleado reg;
	private registrarCliente cli;
	
	JComponent j1;
	JComponent j2;
	JComponent j3;

	public ModifyThread() {
	}
	
	public ModifyThread(JTextField UserField, JPasswordField passField, JButton btnIngresar, String name) {
		this.UserField = UserField;
		this.passField = passField;
		this.btnIngresar = btnIngresar;
		this.name = name;
	}

	public ModifyThread(JLabel img, String ruta, String name) {
		this.img = img;
		this.ruta = ruta;
		this.name = name;
	}
	
	public ModifyThread(JComponent j1, JComponent j2, JComponent j3, String name) {
		this.j1 = j1;
		this.j2 = j2;
		this.j3 = j3;
		this.name = name;
	}
	
	public ModifyThread(JLabel label, String name, JPanel panel) {
		this.label = label;
		this.name = name;
		this.panel = panel;
	}
	
	public ModifyThread(registrarEmpleado reg, String name) {
		this.reg = reg;
		this.name = name;

	}
	
	public ModifyThread(registrarCliente cli, String name) {
		this.cli = cli;
		this.name = name;

	}

	@Override
	public void run() {
		if (name.equals("lblLogoHome")) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			label.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		}else if (name.equals("txtPass")) {
			readPass(UserField, passField, btnIngresar, name);
			
		}else if (name.equals("allComponetResize")) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((JPanel)j1).setPreferredSize(new Dimension(((JPanel)j3).getWidth(), 30));
			((JPanel)j1).setSize(new Dimension(((JPanel)j3).getWidth(), 30));
			((JPanel)j2).setPreferredSize(new Dimension(((JPanel)j3).getWidth(), 30));
			((JPanel)j2).setSize(new Dimension(((JPanel)j3).getWidth(), 30));
			((JPanel)j3).updateUI();
		}else if (name.equals("registroEmpleado")) {
			reg.validarRegistro();
			
		}else if (name.equals("registroCliente")) {
			cli.validarRegistro();
			
		}else if (name.equals("buscarPorCodigoEmp")) {
			reg.validarRegistro();
			
		}else if (name.equals("buscarPorCodigoCli")) {
			cli.validarRegistro();
			
		}else if (name.equals("construirtablaEmp")) {
			reg.construirTabla(200);
			
		}else if (name.equals("construirtablaCli")) {
			cli.construirTabla(200);
			cli.rematizarBordes();
			
		}
		
		
	}
	
	private void readPass(JTextField JTF, JPasswordField JPF, JButton btn, String name) {
		char[] pass = JPF.getPassword();
		String user = JTF.getText();

		if (pass.length >=5 && user.length() != 0 && frmPrincipal.serverStatusMessage == 0) {
			btn.setEnabled(true);
		}

		if (pass.length < 5 || user.length() == 0 || frmPrincipal.serverStatusMessage == 1) {
			btn.setEnabled(false);
		}

	}

	private void addImgLabel(JLabel lbl, String img) {
		ImageIcon image = new ImageIcon(getClass().getResource(img));
		Icon IconImg = new ImageIcon(
				image.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));// Calidad de
																											// escalado
		lbl.setIcon(IconImg);
	}

}
