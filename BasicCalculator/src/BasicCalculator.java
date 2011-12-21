/* Mr. Williams
 * BasicCalculator.java
 * January 9, 2008
 * Program is a template of a Calculator program with just the Addition function.
 * Students will add the other functions
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasicCalculator {
	private static final int FRAME_WIDTH = 150;
	private static final int FRAME_HEIGHT = 120;

	// Keeps track of the current operation (subtract, add, etc)
	private static final int NO_OPERATION = 0;
	private static final int ADDITION = 1;
	private static final int SUBTRACTION = 2;	// Define subtract op
	public static int operation = NO_OPERATION;

	public static JTextField textFieldDisplay;
	public static double Value1 = 0; // holds the value before the operation

	public static void main(String[] args) {
		// Set up the user interface
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();
		frame.add(buttonPanel);

		// create two buttons, plus and equal and a text box for answers
		textFieldDisplay = new JTextField(10);
		buttonPanel.add(textFieldDisplay);
		JButton buttonPlus = new JButton(" + ");
		buttonPanel.add(buttonPlus);
		JButton buttonEqual = new JButton(" = ");
		buttonPanel.add(buttonEqual);
		// create subtract button
		JButton buttonMinus = new JButton(" - ");
		buttonPanel.add(buttonMinus);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Basic Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		// called when the equal sign '=' is pressed
		class EqualSignListener implements ActionListener {

			public void actionPerformed(ActionEvent event)
			{
				double Value2 = Double.parseDouble(textFieldDisplay.getText());
				if (operation == ADDITION) {
					// plus sign pressed before the equal sign
					Value2 += Value1;
				}
				else if (operation == SUBTRACTION) {
					// plus sign pressed before the equal sign
					Value2 = Value1 - Value2;
				}
				// Convert from a answer to a string
				Double answer = new Double(Value2);
				textFieldDisplay.setText( answer.toString() );
				// Reset the operation to show no current operation
				operation = NO_OPERATION;
			}
		}

		// called when a plus sign '+' is pressed
		class PlusSignListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = Double.parseDouble(textFieldDisplay.getText());
				operation = ADDITION;
			}
		}

		// called when a minus sign '-' is pressed
		class MinusSignListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = Double.parseDouble(textFieldDisplay.getText());
				operation = SUBTRACTION;
			}
		}

		// Add the methods that will be called when these buttons are pressed
		ActionListener plusSignListener = new PlusSignListener();
		buttonPlus.addActionListener(plusSignListener);

		ActionListener minusSignListener = new MinusSignListener();
		buttonMinus.addActionListener(minusSignListener);

		ActionListener equalSignListener = new EqualSignListener();
		buttonEqual.addActionListener(equalSignListener);

	}
}
