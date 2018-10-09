package lab2;

/**
 * @author Patrick Nogaj
 * CSC-236
 * Lab 2
 */

public class Tags {
	
	static ArrayBoundedStack<String> tags = new ArrayBoundedStack<String>();
	
	/**
	 * Adds any tags into the stack, and if the tag is an invalid tag, it will pop off stack.
	 * Invalid - tags that do not require an end tag [does not matter in regards to validity].
	 */
	public static String split(String line) throws StackOverflowException, StackUnderflowException {
		int start = 0, end = 0;
		String output = null;
		
		for(int index = 0; index < line.length(); index++) {
			char c = line.charAt(index);
			if(c == '<') {
				start = index;
			} else if(c == '>') {
				end = index;
				output = line.substring(start + 1, end);
				
				if(Validator.containsWhitespace(output) == true) {
					output = output.substring(0, output.indexOf(' '));
				}
				
				if(!output.contains("/")) {
					tags.push(output);
					Validator.removeInvalid(output);
				} else {
					Validator.validity(output);
				}
			} 
		} 
		return output; 
	}

}
