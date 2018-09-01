/* Class     : E_ObtainInputFromGUI
 * Purpose   : To demonstrate:
 * 
 *  			- Using a simple Swing graphical component to both capture input & display output.
 *  			- Appending text to a StringBuffer
 *  			- concatenating Strings together
 *  
 * Programmer: F D'Angelo
 * Created   : 5/29/2013
 */


import javax.swing.JOptionPane;

public class E_ObtainInputFromGUI
{
	public static void main(String[] args) 
	{
		final String FIRST_NAME_PROMPT = "Enter your first name: " ; // a constant
		
		final String LAST_NAME_PROMPT = "Enter your last name: " ; // a constant
		
		final String SPACE = " " ;
			
		String firstName = new String() ;
		
		String lastName = new String() ;
		
		StringBuffer fullName = new StringBuffer() ;  // Why would we use StringBuffer instead of String?
		
		// showMessageDialog is a static method of the JOptionPane class.
		firstName = JOptionPane.showInputDialog(null, "Enter your first name: ", "Enter Data", JOptionPane.PLAIN_MESSAGE);
		
		lastName = JOptionPane.showInputDialog(null, "Enter your last name: ", "Enter Data", JOptionPane.PLAIN_MESSAGE);

		// You can connect a series of append operations together.

		fullName.append(firstName).append(" " ).append(lastName);

		/*
		If linking appends together seems confusing, you can write separate statements as follows:

		fullName.append(firstName) ;

		fullName..append(" " ) ;

		fullName.append(lastName);
		*/
		
		JOptionPane.showMessageDialog(null, "Your full name: " + fullName, "Results", JOptionPane.PLAIN_MESSAGE);
	}

}
