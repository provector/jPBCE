package ie.provector.jpbce.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPicker extends JDialog {

	private static final long serialVersionUID = -1777759638278557773L;
	private final JPanel contentPanel = new JPanel();
	private Color originalColor;
	private ColorPicker me = this;
	
	public ColorPicker(JFrame parent,JTextField source,String type) {
		
		super(parent);
		originalColor = source.getBackground();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("jPBCE Color Picker");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 657, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JColorChooser colorChooser = new JColorChooser(source.getBackground());
			final AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
			for(final AbstractColorChooserPanel accp: panels) {
				if(!accp.getDisplayName().equals(type)) {
					colorChooser.removeChooserPanel(accp);
				}
			}
			MyPreviewPanel customPanel = new MyPreviewPanel(colorChooser);
			colorChooser.setPreviewPanel(customPanel);
			 ColorSelectionModel model = colorChooser.getSelectionModel();
			    model.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent evt) {
			        ColorSelectionModel model = (ColorSelectionModel) evt.getSource();
			        customPanel.curColor = model.getSelectedColor();
			        source.setBackground(model.getSelectedColor());
			      }
			    });
			contentPanel.add(colorChooser);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						me.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						source.setBackground(originalColor);
						me.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	class MyPreviewPanel extends JComponent {
		private static final long serialVersionUID = 1L;
		Color curColor;
		  public MyPreviewPanel(JColorChooser chooser) {
		    curColor = chooser.getColor();
		    this.setSize(20,50);
		    setPreferredSize(new Dimension(600, 50));
		  }
		  public void paint(Graphics g) {
		    g.setColor(curColor);
		    g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
		  }
		}

}
