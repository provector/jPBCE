package ie.provector.jpbce.CheckedComboBox;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import javax.accessibility.Accessible;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicComboPopup;

public class CheckedComboBox<E extends CheckableItem> extends JComboBox<E> {
	
	  private static final long serialVersionUID = 6506107759583200993L;
	  private boolean keepOpen;
	  private transient ActionListener listener;

	  public CheckedComboBox() {
	    super();
	  }
	 
	  protected CheckedComboBox(ComboBoxModel<E> aModel) {
	    super(aModel);
	  }
	  
	  protected CheckedComboBox(E[] m) {
	    super(m);
	  }
	  
	  @Override public Dimension getPreferredSize() {
	    return new Dimension(200, 20);
	  }
	  
	  @Override public void updateUI() {
	    setRenderer(null);
	    removeActionListener(listener);
	    super.updateUI();
	    listener = e -> {
	      if ((e.getModifiers() & InputEvent.MOUSE_EVENT_MASK) != 0) {
	        updateItem(getSelectedIndex());
	        keepOpen = true;
	      }
	    };
	    setRenderer(new CheckBoxCellRenderer<CheckableItem>());
	    addActionListener(listener);
	    getInputMap(JComponent.WHEN_FOCUSED).put(
	        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "checkbox-select");
	    getActionMap().put("checkbox-select", new AbstractAction() {
	     
			private static final long serialVersionUID = -5074926571624769018L;

		@Override public void actionPerformed(ActionEvent e) {
	        Accessible a = getAccessibleContext().getAccessibleChild(0);
	        if (a instanceof BasicComboPopup) {
	          BasicComboPopup pop = (BasicComboPopup) a;
	          updateItem(pop.getList().getSelectedIndex());
	        }
	      }
	    });
	  }
	  
	  public void updateItem(int index) {
	    if (isPopupVisible()) {
	      E item = getItemAt(index);
	      item.selected ^= true;
	      removeItemAt(index);
	      insertItemAt(item, index);
	      setSelectedItem(item);
	    }
	  }
	  
	  @Override public void setPopupVisible(boolean v) {
	    if (keepOpen) {
	      keepOpen = false;
	    } else {
	      super.setPopupVisible(v);
	    }
	  }
	  
	  public int getSelectedItemsCount() {
		  ComboBoxModel<?> model = this.getModel();
		  int counter = 0;
		  for(int i=0;i<model.getSize();i++) {
				CheckableItem item = (CheckableItem) model.getElementAt(i);
				if(item.isSelected()) counter++; 
		  }	
		  return counter;
	  }
	  
	  public void uncheckAllItems() {
		  ComboBoxModel<E> model = this.getModel();
		  for(int i=0;i<model.getSize();i++) {
				CheckableItem item = (CheckableItem) model.getElementAt(i);
				item.setSelected(false);
		  }
		  this.setModel(model);
		  this.updateUI();
	  }
	  
	  public void setSelectedItemsInModel(String[] items) {
		  this.uncheckAllItems();
		  List<String> helperList = Arrays.asList(items);
		  ComboBoxModel<E> model = this.getModel();
		  for(int i=0;i<model.getSize();i++) {
				CheckableItem item = (CheckableItem) model.getElementAt(i);
				if(helperList.contains(item.getText())) item.setSelected(true);
		  }
		  this.setModel(model);
		  this.updateUI();
	  }
	  
	  public String getSelectedItemsString(char separator) {
		  
		ComboBoxModel<?> model = this.getModel();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<model.getSize();i++) {
			CheckableItem item = (CheckableItem) model.getElementAt(i);
			if(item.isSelected()) {
				sb.append(item.getText()+separator);
			}
		}	
		if(!sb.toString().isEmpty()) {
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}else {
			return null;
		}
		
	  }
	  
	
}