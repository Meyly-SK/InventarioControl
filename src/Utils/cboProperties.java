package Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class cboProperties extends BasicComboBoxUI {

	public static ComboBoxUI createUI(JComponent com) {
		return new cboProperties();
	}

	@Override
	protected JButton createArrowButton() {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon(getClass().getResource("/IMG/arrow_Down.png")));
		btn.setContentAreaFilled(false);
		btn.setBorder(null);
		return btn;
	}
	
	

	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		// TODO Auto-generated method stub
		g.setColor(new Color(0,0,0,0));
		g.fillRect(bounds.x,bounds.y, bounds.width, bounds.height);
	}

	@Override
	protected ListCellRenderer<Object> createRenderer() {
		return new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				
				list.setSelectionBackground(new Color(180,230,255));
				
				return this;
			}
		};
	}
}
