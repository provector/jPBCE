package ie.provector.jpbce;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SplashScreen extends JDialog {

	private static final long serialVersionUID = 4751142584581085207L;
	public SplashScreen() {

		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 566, 176);
		getContentPane().setLayout(null);
		{
			JLabel label = new JLabel("");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			label.setBounds(0, 0, 603, 177);
			getContentPane().add(label);
			label.setIcon(new ImageIcon(SplashScreen.class.getResource("/ie/provector/jpbce/icons/logo.PNG")));
		}
	}

}
