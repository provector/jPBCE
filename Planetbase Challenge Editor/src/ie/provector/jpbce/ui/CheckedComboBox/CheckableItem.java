package ie.provector.jpbce.ui.CheckedComboBox;

public class CheckableItem {
	 
	  public final String text;
	  boolean selected;
	  
	  public CheckableItem(String text) {
		this.text = text;  
		this.selected = false;  
	  }

	  public CheckableItem(String text, boolean selected) {
		  this.text = text;  
			this.selected = selected;  
	  }	 

	  public boolean isSelected() {
	    return selected;
	  }

	  public void setSelected(boolean selected) {
	    this.selected = selected;
	  }
	  
	  public String getText() {
		  return this.text;
	  }

	  @Override public String toString() {
	    return text;
	  }
	}

	