package ie.provector.jpbce;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class About extends JDialog {

	private static final long serialVersionUID = -3452849443807629811L;
	private final JPanel contentPanel = new JPanel();

	public About() {
		setBounds(100, 100, 319, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton donateButton = new JButton("");
		donateButton.setToolTipText("Cup of cofee for a coder");
		donateButton.setHorizontalAlignment(SwingConstants.CENTER);
		donateButton.setVerticalAlignment(SwingConstants.CENTER);
		donateButton.setHorizontalTextPosition(SwingConstants.CENTER);
		donateButton.setIcon(new ImageIcon(About.class.getResource("/ie/provector/jpbce/icons/donate.png")));
		donateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
						Desktop.getDesktop().browse(new URI("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=FFPA8FHTYZDBN&item_name=Cup+of+coffee+for+a+coder&currency_code=EUR&source=url"));
					} catch (IOException | URISyntaxException e) {
						//silent error...
					}
				}
			}
		});
		donateButton.setBounds(112, 180, 82, 45);
		contentPanel.add(donateButton);
		
		JLabel lblthankYouFor = new JLabel("<html>Thank you for using this editor. If you find the editor useful please consider donating a cup of coffee :) It will definitely keep me going and motivated in making more open source apps.</html>");
		lblthankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblthankYouFor.setBounds(36, 75, 238, 105);
		contentPanel.add(lblthankYouFor);
		
		JLabel lblprovector = new JLabel("<html>_provector &emsp;&emsp;&emsp;&emsp;&emsp; contact:<br> <font color=\"blue\">matthew.piekarski@gmail.com</font></html>");
		lblprovector.setIcon(new ImageIcon(About.class.getResource("/ie/provector/jpbce/icons/avatar.png")));
		lblprovector.setBounds(36, 23, 238, 55);
		contentPanel.add(lblprovector);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Close");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
