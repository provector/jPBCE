package ie.provector.jpbce.ui.SpinnerEditor;

import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellRenderer;

public class SpinnerRenderer extends JSpinner implements TableCellRenderer {
	
	private static final long serialVersionUID = 292657839562629186L;

	public SpinnerRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setModel((SpinnerNumberModel) value);

		return this;
	}
}