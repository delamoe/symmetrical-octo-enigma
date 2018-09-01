/* Class     : D_SimpleMessageGUI
 * Purpose   : To demonstrate using a simple Swing graphical component.
 * Programmer: F D'Angelo
 * Created   : 5/29/2013
 */

import javax.swing.JOptionPane; // Needed to bring a graphical element into the class.

public class D_SimpleMessageGUI  
{
	public static void main(String[] args) // Header of main method followed by its body.
	{
		// showMessageDialog is a static method of the JOptionPane class.
		// JOptionPane.PLAIN_MESSAGE refers to the icon, in this case none, the 
		// JOptionPane will display in its body.
 
		JOptionPane.showMessageDialog(null, 				// parent object, here none
						"My message to the world.", 	// Message
						"My Title", 			// Title
						JOptionPane.PLAIN_MESSAGE);	// Icon to display, here none

	}
}
