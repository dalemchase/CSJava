/*
Assignment:     Example using Divide By Zero
Programmer:		Mitch Williams
Class:			POS406
Date:           September 3, 2006: revised, catches the runtime =error
Revision:		Moved the first try above the readLine() statements
File Name:      ZeroDivideErrorExample
Purpose:    	A demonstration of using DivideByZero described in =chapter 4, page
*/
import java.io.*;

public class ZeroDivideErrorExample	{

	public static void main(String[] args) throws ArithmeticException, DivideByZeroException
	{
		// variable declaration
		String numberString;
		int firstValue, secondValue;
		float division = 0;

		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			// prompt for the first number
			System.out.print("Enter the first Number: ");
			numberString = dataIn.readLine();
			firstValue = Integer.parseInt(numberString);

			// prompt for the second number
			System.out.print("Enter the second Number: ");
			numberString = dataIn.readLine();
			secondValue = Integer.parseInt(numberString);

			// Using zero in division
			try
			{
				if ( secondValue == 0) throw new DivideByZeroException();
				/* Even without the above line, the actual division would throw
				   an ArithmeticException, and that would throw a
				   DivideByZeroException, which is NOT part of standard Java,
				   but was created by the programmer. */
				division = (float) firstValue / (float) secondValue;
			}
			catch(ArithmeticException  e)
			{
				throw new DivideByZeroException();
			}

			System.out.println("The Numbers Divided = " + division);
		}
		catch (Exception  e) {
			/* Add a return here if you want to exit now */
			/* otherwise, some programs may want to continue in spite of divide =by 0 */
			return;
		}
		System.out.println("And the program is successful");
	} // end main

	public static class DivideByZeroException extends Exception {
		public DivideByZeroException() {
			System.out.println("Error: Divide by zero caught by DivideByZeroException");
			System.out.println();
		}
	}
}