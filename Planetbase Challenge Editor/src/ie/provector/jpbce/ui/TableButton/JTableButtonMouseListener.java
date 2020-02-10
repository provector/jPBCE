package ie.provector.jpbce.ui.TableButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableButtonMouseListener extends MouseAdapter {
	private final JTable table;

	public JTableButtonMouseListener(JTable table) {
		this.table = table;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 1)
			return;
		int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
		int row = e.getY() / table.getRowHeight(); // get the row of the button

		//System.out.println("DEBUG: Click at [" + row + "," + column + "]");

		if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
			Object value = table.getValueAt(row, column);
			if (value instanceof JButton) {
				/* perform a click event */
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(row);
			}
		}

	}
}