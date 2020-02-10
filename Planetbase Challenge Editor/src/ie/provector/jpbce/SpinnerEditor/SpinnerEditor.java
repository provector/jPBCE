package ie.provector.jpbce.SpinnerEditor;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.table.TableCellEditor;


public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
	
	private static final long serialVersionUID = -1124235286021360935L;
	
	protected JSpinner spinner;

	public SpinnerEditor() {
		spinner = new JSpinner();
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		spinner.setModel((SpinnerModel) value);

		return spinner;
	}

	public Object getCellEditorValue() {
		SpinnerModel sm = spinner.getModel();
		return sm;
	}
}