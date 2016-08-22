package hiring.developer.challenge;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by Mayank on 8/21/16.
 */

public class Calculator {

    private static final String[] PRECEDENCE = {"/","*","+","-"};

    private static Stack<String> operatorArray = new Stack<>();
    private static Stack<String> operandArray = new Stack<>();

    //to check if the incoming operator has higher priority than the one at the top of the operatorArray stack
    public static boolean isHigherPriority(char c) {
        if(operatorArray.empty() == true || Arrays.asList(PRECEDENCE).indexOf(String.valueOf(c)) <  Arrays.asList(PRECEDENCE).indexOf(operatorArray.peek())) {
            return true;
        }
        return false;
    }

    //to pop two operands and one operator and perform calculation
    public static void pushAndPop() throws EmptyStackException, CalculatorException {
        int operand1 = Integer.parseInt(operandArray.pop());
        int operand2 = Integer.parseInt(operandArray.pop());
        switch (operatorArray.pop()) {
            case "+":
                operandArray.push(String.valueOf(operand1 + operand2));
                break;
            case "-":
                operandArray.push(String.valueOf(operand2 - operand1));
                break;
            case "*":
                operandArray.push(String.valueOf(operand1 * operand2));
                break;
            case "/":
                operandArray.push(String.valueOf(operand1 / operand2));
                break;
            default:
                throw new CalculatorException("This calculator supports only basic arithmetic operations like +, -, *, /");
        }
    }

    public static Integer eval(String expression) throws CalculatorException{
        int begin = 0;
        for(int i =0;i<expression.length();i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                operandArray.push(expression.substring(begin,i));
                if(i<expression.length()) begin = i+1;
                if(isHigherPriority(expression.charAt(i))) {
                    operatorArray.push(String.valueOf(expression.charAt(i)));
                } else {
                    pushAndPop();
                    operatorArray.push(String.valueOf(expression.charAt(i)));
                }
            }
        }

        operandArray.push(expression.substring(begin,expression.length()));

        if(operatorArray.empty() == false && operandArray.empty() == false) {
            while(operatorArray.empty() != true) {
                pushAndPop();
            }
        }
        return Integer.parseInt(operandArray.pop());
    }

    public void run(InputStream inputStream, PrintStream outputStream) {
        Boolean hasNext;
        String pattern = "([-+]?[0-9]*\\.?[0-9]+[\\/\\+\\-\\*])+([-+]?[0-9]*\\.?[0-9]+)";
        String pattern2 = "[0-9]+";
        Scanner scanner = new Scanner(inputStream);

        while((hasNext = scanner.hasNext()) != false ) {
            String expression = trimWhiteSpaces(scanner.nextLine());
            if(Pattern.matches(pattern, expression) || Pattern.matches(pattern2, expression)) {
                try {
                    outputStream.println(eval(expression));
                } catch(EmptyStackException es) {
                    System.out.println("Invalid Expression");
                } catch (CalculatorException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid Expression");
            }
        }
    }

    //to trim whitespaces from input string
    private String trimWhiteSpaces(String expression) {
        return expression.replaceAll("\\s+","");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run(System.in, System.out);
    }
}
