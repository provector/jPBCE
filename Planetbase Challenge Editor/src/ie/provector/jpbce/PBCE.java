package ie.provector.jpbce;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;

import ie.provector.jpbce.ui.EditorWindow;
import ie.provector.jpbce.ui.SplashScreen;

/*
 * 1.0.a initial version
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
 * 
 * After:
 * TODO:	[X] UI Values Validation
 * TODO: 	[X] Reset Values/New button

 * Maybe:
 * TODO:	[X] JSpinner in table cell
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
 * TODO:	[X] ReachWelfare has now max value of 100 as per docs
 * TODO:	[X] Fixed bug where empty character objective field would throw a silent Exception and no error dialog
 * TODO:	[X] Replaced Integer field in Tables with a Spinner
 * 
 * 1.0.g dev update
 * TODO:	[X] Added button to remove specific row from objectives table
 * 
 * 1.0.h dev update
 * TODO:	[X] Fixed bug where new objective tables couldn't be loaded from editor file
 * TODO:	[X] Fixed bug where new objective tables remove button wasn't properly loaded upon loading editor file
 * 
 * 1.0.i dev update
 * TODO: 	[ ] Add checkbox for Starting Specialization and resources to distinguish settings from default values
 * 
 * 1.0.j Release
 * TODO:	[ ] Basic Workshop Uploading
 * TODO:	[ ] Company Support
 * TODO: 	[ ] Game days to real time indicator
 * 
 * 1.1.a dev
 * TODO:	[ ] CleanUp and Re-factor the code for translations
 * 			[ ] Fix UI Refresh BUG
 * 
 * 1.1.0 Release
 * TODO:	[ ] Translation File Suppport
 * --------------------------------------------------
 * 
 * Known Bugs:
 * 
 * TODO: 	[ ] UI Refresh Issue
 * TODO: 	[X] SaveFile name extension suffix
 *
 * 
 * 
 * Future Features:
 * 			[ ] Storing editor settings, 
 * 			[ ] Advanced workshop support with uploading jpbce file for later modification and storing item id's
 * 			[ ] Advanced Campaign support
 * 			[?] Detect language if game installed
 * 			[ ] Proper infoField messages
 * 			[ ] Package into exe
 * 			[ ] Debug/Unhandled Errors Handling/Custom output Stream
 * 			[ ] Re-do the UI from crappy swing
 */

public class PBCE {
	
	public final static String _EDITOR_EXTENSION = ".jpbce"; 
	public final static String _VERSION_STRING = "jPBCE ver 1.Beta.g (GPL) _provector";
	
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
