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
 * 
 * 1.0.b dev update
 * 
 * TODO:	[X] Error prompt on failed mkdir
 * TODO:	[X] Overwrite prompt for saving challenge
 * TODO:	[X] XML file UTF8 Encoding
 * TODO:	[X] Added Guards as start option
 * TODO:	[X] Changed exit message a bit
 * 
 * 1.0.c dev update
 * 
 * TODO: 	[X] Language prefix
 * TODO: 	[X] Error handling for lanugage prefix
 * TODO: 	[X] Fix overwrite bug
 * TODO:	[X] Save to challenge remembers last dir
 * 
 * 1.0.d dev update
 * TODO: 	[X] Overwrite prompt for saving editor file.
 * TODO:	[X] Save Editor file to... now remembers last path
 * 
 * 1.0.e beta release
 * TODO:	[X] Fixed misspelled strings issues for robotics facility and cabin
 * TODO:	[X] Removed connection option as game didn't allow it
 * 
 * 1.0.f dev update
 * TODO:	[X] Fix typo in planetbase title
 * 
 * --------------------------------------------------
 * 
 * Known Bugs:
 * 
 * TODO: 	[] UI Refresh Issue
 * TODO: 	[] SaveFile name extension suffix
 *
 * 1.0b
 * TODO: 	[X] Change to UTF8 encoding for xml file
 * TODO:	[ ] Option for additional language file
 * 			[ ] ? Detect language if game installed
 * 			[ ] Autocreate Planetbase/Challenges dir
 * 			[ ] Add guards
 */

public class PBCE {
	
	final static String _EDITOR_EXTENSION = ".jpbce"; 
	public final static String _VERSION_STRING = "jPBCE ver 1.Beta.E (GPL) _provector";
	
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
