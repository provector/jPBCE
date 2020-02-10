import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
   
public class JSpinnerTableExample extends JFrame {
  
  public JSpinnerTableExample(){
   // super();
     
    SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(10.0, -500.0, 500.0, .5);
    SpinnerDateModel spinnerModel2 = new SpinnerDateModel();
  
    DefaultTableModel dtm = new DefaultTableModel();
    //dtm.setDataVector(new Object[][]{{ spinnerModel1, "JSpinner1"},
     //                                { spinnerModel2,"JSpinner2" }},
     //                 new Object[]{"JSpinner","String"});
    dtm.addRow(new Object[][]{{ spinnerModel1, "JSpinner1"},
                                     { spinnerModel2,"JSpinner2" }});
                      
    JTable table = new JTable(dtm);
    table.getColumn("JSpinner").setCellRenderer(new SpinnerRenderer());
    table.getColumn("JSpinner").setCellEditor(new SpinnerEditor());
  
    table.setRowHeight(20);
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
  
    setSize( 400, 100 );
    setVisible(true);
  }
  
  public static void main(String[] args) {
    JSpinnerTableExample frame = new JSpinnerTableExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
  
class SpinnerRenderer extends JSpinner implements TableCellRenderer {
   public SpinnerRenderer() {
      setOpaque(true);
   }
   
   public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
      setModel((SpinnerModel) value);
   
      return this;
   }
}
   
class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
   protected JSpinner spinner;
   
   public SpinnerEditor() {
      spinner = new JSpinner();
   }
  
   public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {
      spinner.setModel((SpinnerModel) value);
  
      return spinner;
   }
  
   public Object getCellEditorValue() {
      SpinnerModel sm = spinner.getModel();
      return sm;
   }
}
