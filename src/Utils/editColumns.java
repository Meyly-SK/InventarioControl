package Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.TableCellRenderer;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class editColumns implements TableCellRenderer {

	JComponent jcomponent;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		jcomponent = null;

		if (value instanceof String) {
			jcomponent = new JButton(((String) value).toUpperCase());
			((JButton) jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
			((JButton) jcomponent).setSize(30, jcomponent.getWidth());
			((JButton) jcomponent).setPreferredSize(new DimensionUIResource(6, jcomponent.getWidth()));
			((JButton) jcomponent).setFont(new Font("Tahoma", Font.PLAIN, 10));
			((JButton) jcomponent).setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		}

		jcomponent.setOpaque(true);
		jcomponent.setBackground(new Color(48, 48, 48));
		jcomponent.setForeground(Color.WHITE);

		return jcomponent;
	}

}
