package Utils;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import Vista.frmPrincipal;

import java.awt.Font;
import java.awt.Color;

public class editCells extends DefaultTableCellRenderer {

	private String tipo = "texto";
	private Font normal = new Font("Verdana", Font.PLAIN, 10);
	private Font bold = new Font("Verdana", Font.BOLD, 10);
	private ImageIcon iconIr_A = new ImageIcon(getClass().getResource("/IMG/ir_a.png"));
	JLabel label = new JLabel();
	JCheckBox check = new JCheckBox();

	public editCells() {

	}

	public editCells(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Color colorBackground = null;
		Color colorDefaultBackground = new Color(150, 255, 159);
		Color colorBackgroundSelection = new Color(58, 188, 69);

		if (isSelected) {
			this.setBackground(colorDefaultBackground);
		} else {
			this.setBackground(Color.WHITE);
		}

		if (tipo.equals("texto")) {
			if (hasFocus) {
				colorBackground = colorBackgroundSelection;
			} else {
				colorBackground = colorDefaultBackground;
			}

			this.setHorizontalAlignment(JLabel.LEFT);
			this.setText((String) value);
			this.setBackground((isSelected) ? colorBackground : Color.WHITE);
			this.setFont(normal);
			this.setToolTipText((String) value);
			return this;
		}

		if (tipo.equals("numerico")) {
			if (hasFocus) {
				colorBackground = colorBackgroundSelection;
			} else {
				colorBackground = colorDefaultBackground;
			}

			this.setHorizontalAlignment(JLabel.CENTER);
			this.setText(value + "");
			// this.setForeground((isSelected)? Color.WHITE: Color.BLACK);
			this.setBackground((isSelected) ? colorBackground : Color.WHITE);
			this.setFont(bold);
			this.setToolTipText(value + "");
			return this;
		}

		if (tipo.equals("stock")) {
			if (hasFocus) {
				colorBackground = colorBackgroundSelection;
			} else {
				colorBackground = colorDefaultBackground;
			}

			this.setHorizontalAlignment(JLabel.CENTER);
			this.setText(value + "");
			this.setBackground((isSelected) ? colorBackground : Color.WHITE);
			this.setFont(bold);
			this.setToolTipText(value + "");
			try {
				frmPrincipal.stockEdit = Integer.parseInt(value + "");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return this;
		}

		if (tipo.equals("cantidad")) {
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setText(value + "");
			this.setBackground(Color.WHITE);
			this.setFont(bold);
			this.setToolTipText(value + "");
			try {
				int Cant = Integer.parseInt(value + "");
				this.setForeground((Cant > frmPrincipal.stockEdit || Cant < 1) ? Color.RED : new Color(0,209,33));
				
			} catch (Exception e) {
				// TODO: handle exception
			}

			return this;
		}

		if (tipo.equals("icono")) {
			if (String.valueOf(value).equals("IR_A")) {
				label.setIcon(iconIr_A);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setToolTipText("Ir a empleado");
			}
			return label;
		}

		if (tipo.equals("check")) {
			check = new JCheckBox("", (boolean) value);
			check.setHorizontalAlignment(JLabel.CENTER);
			check.setOpaque(false);
			check.setHorizontalAlignment(SwingConstants.CENTER);
			check.setContentAreaFilled(false);
			return check;
		}

		return this;
	}

}
