package mdmjava.util;

import java.io.PrintWriter;
import lotus.domino.NotesException;

/**
 * @author mdm-adph
 *
 */
public class JSONWriter {

	/**
	 * 
	 */
	private static PrintWriter printOutput = null;
	
	/**
	 * 
	 */
	private static boolean firstParam = true;
	
	/**
	 * Default constrctor.
	 * @constructor
	 */
	private JSONWriter() throws NotesException {
	}
	
	/**
	 * Initializes the JSONWriter singleton with the desired PrintWriter
	 * @param pOutput {PrintWriter}
	 * The PrintWriter object to associate with JSONWriter,
	 * usually the result of getAgentOutput()
	 */
	public static synchronized void start(PrintWriter pOutput) {
		if (printOutput == null) {
			printOutput = pOutput;
			
			printOutput.println("Content-type: application/json");
			// printOutput.println("Content-type: text/html");
			printOutput.println("{");
		}
	}
	
	/**
	 * Internal function that prints the actual JSON information
	 * @param param {String}
	 * The string value of the JSON parameter name.
	 * @param value {String}
	 * The value of the JSON parameter.
	 */
	private static synchronized void printLine(String param, String value) {
		if (firstParam) {
			firstParam = false;
		}
		else {
			printOutput.println(",");
		}
		
		printOutput.println("\"" + param + "\":" + value);
	}
	
	/**
	 * Public interface for printLine() for string params
	 * @param param {String}
	 * The string value of the JSON parameter name.
	 * @param value {String}
	 * The value of the JSON parameter.
	 */
	public static void print(String param, String value) {
		printLine(param, "\"" + value + "\"");
	}
	
	/**
	 * Public interface for printLine for integer params
	 * @param param {String}
	 * The string value of the JSON parameter name.
	 * @param value {int}
	 * The value of the JSON parameter.
	 */
	public static void print(String param, int value) {
		printLine(param, Integer.toString(value));
	}
	
	/**
	 * Public interface for printLine for Boolean params
	 * @param param {String}
	 * The string value of the JSON parameter name.
	 * @param value {Boolean}
	 * The value of the JSON parameter.
	 */
	public static void print(String param, Boolean value) {
		printLine(param, Boolean.toString(value));
	}
	
	public static void print(String param, String[] value) {
		
	}
	
	/**
	 * Closes the JSON stream
	 */
	public static synchronized void end() {
		printOutput.println("}");
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException { 
		throw new CloneNotSupportedException(); // that'll teach 'em 
	}
}