package ie.provector.jpbce.CheckedComboBox;

import java.awt.Component;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

class CheckBoxCellRenderer<E extends CheckableItem> implements ListCellRenderer<E> {
	
	/*
	 * Credit: https://java-swing-tips.blogspot.com/2016/07/select-multiple-jcheckbox-in-jcombobox.html
	 * Author: aterai (TERAI Atsuhiro)
	 * Used Under Public Domain 
	 */
	
	  private final JLabel label = new JLabel(" ");
	  
	  private final JCheckBox check = new JCheckBox(" ");

	  @Override public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected, boolean cellHasFocus) {
	    if (index < 0) {
	      String txt = getCheckedItemString(list.getModel());
	      label.setText(txt.isEmpty() ? " " : txt);
	      return label;
	    } else {
	      check.setText(Objects.toString(value, ""));
	      check.setSelected(value.isSelected());
	      if (isSelected) {
	        check.setBackground(list.getSelectionBackground());
	        check.setForeground(list.getSelectionForeground());
	      } else {
	        check.setBackground(list.getBackground());
	        check.setForeground(list.getForeground());
	      }
	      return check;
	    }
	  }

	  public static <E extends CheckableItem> String getCheckedItemString(ListModel<E> model) {
	    return IntStream.range(0, model.getSize())
	      .mapToObj(model::getElementAt)
	      .filter(CheckableItem::isSelected)
	      .map(Objects::toString)
	      .sorted()
	      .collect(Collectors.joining(", "));	    
	  }
	}