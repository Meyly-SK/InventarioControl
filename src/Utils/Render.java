package Utils;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Render implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		
		if (value instanceof JLabel) {
			JLabel labelIcon = (JLabel)value;
			return labelIcon;
		}
		
		
		return null;
	}

	
	
}
