package lab2;

/**
 * @author Patrick Nogaj
 * CSC-236
 * Lab 2
 */

public class Validator {
	
	static String[] invalidTags = {"area", "base", "br", "col", 
			"command", "embed", "hr", "image", "input", "keygen", 
			"link", "meta", "param", "source", "track", "wbr"};
	
	static int mistakes = 0;
	
	/**
	 * Returns value of true | false varying if line contains white space.
	 * @param - line input
	 */
	public static boolean containsWhitespace(String line) {
		return line.contains(" ");
	}
	
	/**
	 * Checks tags by verifying it with array of invalid tags.
	 * >> If invalid, it will pop from the stack as it does not need to be verified.
	 * >> If valid, will stay on the stack.
	 * @param - line [tag] to verify with invalidTags
	 */
 	public static void removeInvalid(String line) throws StackUnderflowException {
 		for(int index = 0; index < invalidTags.length; index++) {
 			if(line.startsWith(invalidTags[index]) || line.equalsIgnoreCase(invalidTags[index])) {
 				System.out.println("No match needed: <" + line + ">.");
 				Tags.tags.pop();
 			}
 		}
 	}
 	
 	/**
 	 * @param line - checks to see if /tag is equal to top
 	 * >> if true: pop from stack as a match
 	 * >> if false: figure out if missing a fwd or end tag
 	 * @throws StackOverflowException 
 	 */
 	public static void validity(String line) throws StackUnderflowException, StackOverflowException {
 		
 		if(Tags.tags.isEmpty() == false) {
 			if(line.substring(1, line.length()).equalsIgnoreCase(Tags.tags.top())) {
 				System.out.println("Matched: <" + Tags.tags.top() + "> and <" + line + ">.");
 				Tags.tags.pop();
 			} else if(!Tags.tags.top().equalsIgnoreCase("html")) {
 				System.out.println("Missing end tag for: <" + Tags.tags.top() + ">.");
 				Tags.tags.pop();
 				validity(line);
 				mistakes++;
 			} else {
 				System.out.println("Missing front tag for: <" + line + ">.");
 				mistakes++;
 			}
 		}
 	}
 	
 	/**
 	 * @return if file is valid/invalid by determing mistakes == 0;
 	 */
 	public static boolean isFileValid() {
 		return (mistakes == 0);
 	}

}
