/**
 * Converts postfix notation to infix notation, infix  notation to postfix notation, and calculates the value of a postfix expression.
 * @author Rose Griffin
 *
 */
public class Notation {
	
	public Notation() {
		
	}
	
	/**
	 * Calculates the value of the postfix expression
	 * @param 	postfixExpr expression to be calculated
	 * @return 	calculation
	 * @throws 	InvalidNotationFormatException if format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		NotationStack<String> solution = new NotationStack<String>(postfixExpr.length());
		double eval = 0;
		
		for (int i = 0; i < postfixExpr.length(); i++) {
			char currentChar = postfixExpr.charAt(i);
			
			if (isDigit(currentChar)) {
				try {
					solution.push(currentChar + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else if (isOperator(currentChar)) {
				if (solution.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				double firstVal = 0, secondVal = 0, result = 0;
				try {
					firstVal = Double.parseDouble(solution.pop());					
					secondVal = Double.parseDouble(solution.pop());
				} catch (NumberFormatException | StackUnderflowException e) {
					e.printStackTrace();
				}

				switch (currentChar) {
					case '*':
						result = secondVal * firstVal;
						break;
					case '/':
						result = secondVal / firstVal;
						break;
					case '+':
						result = secondVal + firstVal;
						break;
					case '-':
						result = secondVal - firstVal;
						break;
				}
				try {
					solution.push(result + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}
			
		if (solution.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		
		try {
			eval = Double.parseDouble(solution.top());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
		
		return eval;
	}
	
	/**
	 * Converts postfix notation to infix notation
	 * @param postfix	expression to be converted
	 * @return infix	new notation
	 * @throws InvalidNotationFormatException	if format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> solution = new NotationStack<String>(postfix.length());
		
		for (int i = 0; i < postfix.length(); i++) {
			char currentChar = postfix.charAt(i);
			
			if (isDigit(currentChar)) {
				try {
					solution.push(currentChar + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else if (isOperator(currentChar)) {
				if (solution.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				String firstVal = "", secondVal = "";
				try {
					firstVal = solution.pop();
					secondVal = solution.pop();		
					solution.push("(" + secondVal + "" + currentChar + "" + firstVal + ")" );
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}

			}
		}
		if (solution.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return solution.toString();
	}
	
	/**
	 * Converse infix notation to postfix notation
	 * @param infix 	Expression to be converted
	 * @return postfix	new notation
	 * @throws InvalidNotationFormatException	if format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		NotationQueue<String> solution = new NotationQueue<String>(infix.length());
		NotationStack<String> temp = new NotationStack<String>(infix.length());

			for (int i = 0; i < infix.length(); i++ ) {
				char currentChar = infix.charAt(i);
				
				if (isDigit(currentChar)) {
					try {
						solution.enqueue(currentChar + "");
					} catch (QueueOverflowException e) {
						e.printStackTrace();
					}
				} else if (currentChar == '(') {
					try {
						temp.push(currentChar + "");
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				} else if (isOperator(currentChar)) {
					try {
						while (!temp.isEmpty() && precedence(temp.top().charAt(0)) >= precedence(currentChar)) {
							solution.enqueue(temp.pop());
						}
					} catch (StackUnderflowException | QueueOverflowException e) {
						e.printStackTrace();
					}
					try {
						temp.push(currentChar + "");
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				} else if (currentChar == ')') {
					try {
						while (!temp.isEmpty() && temp.top().charAt(0) != '(') {
							solution.enqueue(temp.pop());
						}
					} catch (StackUnderflowException e) {
						e.printStackTrace();
					} catch (QueueOverflowException e) {
						e.printStackTrace();
					}
					if (temp.isEmpty()) {
						throw new InvalidNotationFormatException();
					} else {
						try {
							temp.pop();
						} catch (StackUnderflowException e) {
							e.printStackTrace();
						}
					}
				}
			}				
		
		while (!temp.isEmpty()) {
			try {
				solution.enqueue(temp.pop());
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		}
		
		return solution.toString();
	}
	
	/**
	 * Determines if a char is one of the following operators: +, -, *, or -
	 * @param c character
	 * @return true if an operator, false if otherwise
	 */
	public static boolean isOperator(char c) {
		return (c == '+') || (c == '-') || (c == '*') || (c == '/');
	}
	
	/**
	 * Determines if a char is a digit
	 * @param c character
	 * @return true if a digit, false if not
	 */
	public static boolean isDigit(char c) {
		return c >= 48 && c <= 57;
	}
	
	/**
	 * Determines the precedence of an operator
	 * @param c operator
	 * @return returns 1 if the operator is multiplication or division, returns 0 if the operator is addition or subtraction, returns -1 if none
	 */
	public static int precedence(char c) {
		if (c == '*' || c == '/') {
			return 1;
		} else if (c == '+' || c == '-') {
			return 0;
		} else
			return -1;
	}

	
}
