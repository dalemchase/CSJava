/* Ryan Chase
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasicCalculator {
	private static final int FRAME_WIDTH = 250;
	private static final int FRAME_HEIGHT = 200;

	// Keeps track of the current operation (subtract, add, etc)
	private static final int NO_OPERATION = 0;
	private static final int ADDITION = 1;

	private static final int SUBTRACTION = 2;	// Define subtract op
	private static final int MULTIPLICATION = 3;	// Define multiply op
	private static final int DIVISION = 4;	// Define divide op
	private static final int POWER = 5;	// Define power op
	public static int operation = NO_OPERATION;

	public static JTextField textFieldDisplay;
	public static double Value1 = 0; // holds the value before the operation
	public static double Save = 0;	// holds Saved Memory value

	// Read the text field with exception catching
	public static double getNumber() {
		double value = 0;
		try {
			value = Double.parseDouble(textFieldDisplay.getText());
		}
		catch (Exception e) {
			System.out.println( "Bad value entered" );
			textFieldDisplay.setText( "0.0" );
		}
		return value;
	}

	public static void main(String[] args) {
		// Set up the user interface
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();
		frame.add(buttonPanel);

		// create two buttons, plus and equal and a text box for answers
		textFieldDisplay = new JTextField(14);
		buttonPanel.add(textFieldDisplay);
		JButton buttonEqual = new JButton(" = ");
		buttonPanel.add(buttonEqual);
	
	JButton buttonPlus = new JButton(" + ");
		buttonPanel.add(buttonPlus);
		// create subtract button
		JButton buttonMinus = new JButton(" - ");
		buttonPanel.add(buttonMinus);
		// create multiply button
		JButton buttonMultiply = new JButton(" * ");
		buttonPanel.add(buttonMultiply);
		// create divide button
		JButton buttonDivide = new JButton(" / ");
		buttonPanel.add(buttonDivide);
		// create power button
		JButton buttonPower = new JButton("a^b");
		buttonPanel.add(buttonPower);
		// create root button
		JButton buttonRoot = new JButton(" sqr ");
		buttonPanel.add(buttonRoot);
		// create sine button
		JButton buttonSine = new JButton("sin");
		buttonPanel.add(buttonSine);
		// create cosine button
		JButton buttonCosine = new JButton("cos");
		buttonPanel.add(buttonCosine);
		// create tangent button
		JButton buttonTangent = new JButton("tan");
		buttonPanel.add(buttonTangent);
		// create negative button
		JButton buttonNeg = new JButton("-x ");
	
	buttonPanel.add(buttonNeg);
		// create invert button
		JButton buttonInv = new JButton("1/x");
		buttonPanel.add(buttonInv);
		// create save button
		JButton buttonSave = new JButton("MS");
		buttonPanel.add(buttonSave);
		// create mem button
		JButton buttonMem = new JButton("MR");
		buttonPanel.add(buttonMem);
		// create mem clear button
		JButton buttonClr = new JButton("MC");
		buttonPanel.add(buttonClr);
		// create PI button
		JButton buttonPi = new JButton("PI");
		buttonPanel.add(buttonPi);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Basic Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		// called when the equal sign '=' is pressed
		class EqualSignListener implements ActionListener {

			public void actionPerformed(ActionEvent event)
			{
				double Value2 = getNumber();
				if (operation == ADDITION) {
					// plus sign pressed before the equal sign
					Value2 += Value1;
				}
				else if (operation == SUBTRACTION) {
					// minus sign pressed before the equal sign
					Value2 = Value1 - Value2;
			
	}
				else if (operation == MULTIPLICATION) {
					 // multiply sign pressed before the equal sign
					Value2 = Value1 * Value2;
				}
				else if (operation == DIVISION) {
					 // divide sign pressed before the equal sign
					if (Value2 == 0) {
						System.out.println("Divide by zero error");
					} else
							Value2 = Value1 / Value2;
				}
				else if (operation == POWER) {
					 // POWER sign pressed before the equal sign
					Value2 = Math.pow(Value1, Value2);
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
				Value1 = getNumber();
				operation = ADDITION;
			}
		}

		// called when a minus sign '-' is pressed
		class MinusSignListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				operation = SUBTRACTION;
			}
		}

		// called when a multiply sign '*' is pressed
	
	class MultiplySignListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				operation = MULTIPLICATION;
			}
		}
		
		// called when a divide sign '/' is pressed
		class DivideSignListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				operation = DIVISION;
			}
		}

		// called when a power sign 'a^b' is pressed
		class PowerSignListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				operation = POWER;
			}
	
	}

		// called when the 'sqr' sign is pressed
		class SquareRootListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				if (Value1 < 0){
					Value1 = Math.abs(Value1);
				double Value2 = Math.sqrt(Value1);
				Double answer = new Double(Value2);
				textFieldDisplay.setText( answer.toString() + "i" );
				}
				else{
				double Value2 = Double.parseDouble(textFieldDisplay.getText());
				Value2 = Math.sqrt(Value1);
				Double answer = new Double(Value2);
				textFieldDisplay.setText( answer.toString() );
				}
			}
		}

		// called when the 'sin' sign is pressed
		class SinListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				//Value1 = Math.sin(Math.toRadians(Value1));
				Double answer = new Double(Math.sin(Math.toRadians(Value1)));
				textFieldDisplay.setText( answer.toString() );
			}
		}
		
		// called when the 'cos' sign is pressed
		class CosListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				//Value1 = Math.sin(Math.toRadians(Value1));
			
	Double answer = new Double(Math.cos(Math.toRadians(Value1)));
				textFieldDisplay.setText( answer.toString() );
			}
		}

		// called when the 'tan' sign is pressed
	
	class TanListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				//Value1 = Math.sin(Math.toRadians(Value1));
				if (Value1 == 90 || Value1 == 270) {
					System.out.println("Undefined");
				}
				Double answer = new Double(Math.tan(Math.toRadians(Value1)));
			
	textFieldDisplay.setText( answer.toString() );
			}
		}

		// called when the '-x' sign is pressed
		class NegListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
				//Value1 = Math.sin(Math.toRadians(Value1));
				Double answer = new Double(-Value1);
				textFieldDisplay.setText( answer.toString() );
			}
		}

		// called when the '1/x' sign is pressed
		class InvListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Double answer = new Double(0);
				Value1 = getNumber();
				//Value1 = Math.sin(Math.toRadians(Value1));
				try {
					answer = new Double(1/Value1);
				}
				catch (Exception e) {
					System.out.println( "Division error" );
				}
				textFieldDisplay.setText( answer.toString() );
			}
		}

		// called when the 'pi' sign is pressed
		class PiListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				Double answer = new Double(Math.PI);
				textFieldDisplay.setText( answer.toString() );
			}
	
	}

		class SaveListener implements ActionListener {

			public void actionPerformed(ActionEvent event)
			{
				Value1 = getNumber();
			
	Save = Value1;
			}
		}

		class MemListener implements ActionListener {

			public void actionPerformed(ActionEvent event)
	
	
	{
				Double answer = new Double(Save);
				textFieldDisplay.setText( answer.toString() );
			}
		}
		class ClrListener implements ActionListener {

			public void actionPerformed(ActionEvent event)
			{
//				Value1 = 0;
				Save = 0;
				//Double answer = new Double(Value1);

			
	//textFieldDisplay.setText( answer.toString() );


			}
		}

		// Add the methods that will be called when these buttons are pressed
		ActionListener invListener = new InvListener();
		buttonInv.addActionListener(invListener);
	
	
		ActionListener plusSignListener = new PlusSignListener();
		buttonPlus.addActionListener(plusSignListener);

		ActionListener minusSignListener = new MinusSignListener();
		buttonMinus.addActionListener(minusSignListener);

		ActionListener equalSignListener = new EqualSignListener();
		buttonEqual.addActionListener(equalSignListener);
		
		ActionListener multiplySignListener = new MultiplySignListener();
		buttonMultiply.addActionListener(multiplySignListener);

		ActionListener divideSignListener = new DivideSignListener();
		buttonDivide.addActionListener(divideSignListener);

		ActionListener powerSignListener = new PowerSignListener();
		buttonPower.addActionListener(powerSignListener);

		ActionListener squareRootListener = new SquareRootListener();
	
	buttonRoot.addActionListener(squareRootListener);

		ActionListener sinListener = new SinListener();
		buttonSine.addActionListener(sinListener);

		ActionListener cosListener = new CosListener();
		buttonCosine.addActionListener(cosListener);
		
		ActionListener tanListener = new TanListener();
		buttonTangent.addActionListener(tanListener);

	
	ActionListener negListener = new NegListener();
		buttonNeg.addActionListener(negListener);
		
		ActionListener saveListener = new SaveListener();
		buttonSave.addActionListener(saveListener);
		
		ActionListener memListener = new MemListener();
		buttonMem.addActionListener(memListener);
		
		ActionListener clrListener = new ClrListener();
		buttonClr.addActionListener(clrListener);
		
		ActionListener piListener = new PiListener();
		buttonPi.addActionListener(piListener);
	}
}
