package ie.provector.jpbce;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;

/*
 * 1.0
 * --------------------------------------------------
 * TODO:	[X] Variables Renaming
 * TODO: 	[X] UI Functionality (Sliders, interactions)
 * TODO:	[X] UI Value Constraints
 * TODO:	[X] Color Picker
 * TODO:	[X] Saving state to editor file
 * TODO:	[X] Reading state from editor file
 * TODO:	[X] Saving XML
 * TODO: 	[X] Menu Items
 * TODO: 	[X] Tool-tips
 * TODO:	[X] Basic Error Handling
 * TODO: 	[X] Splash Screen
 * TODO:	[X] About
 * TODO: 	[X] move main logic to separate class
 * TODO:	[X] Re-do hsl Transform and Tint Texture
 * TODO: 	[ ] Package into exe
 * 
 * After:
 * TODO:	[X] UI Values Validation
 * TODO: 	[X] Reset Values/New button
 * TODO:	[ ] infoField messages
 * TODO:	[ ] Unhandled Errors Handling/Custom output Stream
 * 
 * Maybe:
 * TODO:	[] JSpinner in table cell
 * TODO:	[] Workshop Uploading
 * TODO:	[] Campaign Support/Groups Support
 * TODO: 	[] Game days to real time indicator
 * TODO:	[] CleanUp and Re-factor the code
 * --------------------------------------------------
 * 
 * Known Bugs:
 * 
 * TODO: 	[] UI Refresh Issue
 * TODO: 	[] SaveFile name extension suffix
 *
 */

public class PBCE {
	
	final static String _EDITOR_EXTENSION = ".jpbce"; 
	public final static String _VERSION_STRING = "jPBCE ver 1.Beta.a matthew.piekarski@gmail.com";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen dialog = new SplashScreen();
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					EditorWindow window = new EditorWindow();
					window.editorFrame.setVisible(true);
					
					dialog.setLocationRelativeTo(window.editorFrame);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
