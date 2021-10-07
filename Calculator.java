package calculator;

import java.util.*;

public class Calculator {

    final static String ADDITION = "+";
    final static String SUBTRACTION = "-";
    final static String MULTIPLICATION = "*";
    final static String DIVISION = "/";
    final static String EXPONENT = "^";

    public static void main(String[] args) {
        char answer = 'y';

        System.out.println("""
                This program is a calculator
                """);

        while (answer == 'y') {

            double result = compute();
            System.out.println("""
                    \nThe result is:
                    """ + result + "\n\n");
            answer = run();
        }

        System.exit(0);

    }

    public static char run() {
        System.out.println("""
                Would you like to use the calculator again?

                Yes or No
                """);
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String littleInput = input.toLowerCase();
        char firstLetter = littleInput.charAt(0);
        return firstLetter;
    }

    public static double compute() {
        double result[] = numberOneAndTwo();
        double answer = 0, var1 = result[0], var2 = result[1];
        String operation = operand();
        
        answer = switch (operation) {
            case ADDITION -> {
                yield addition(var1, var2);
            }
            case SUBTRACTION -> {
                yield subtraction(var1, var2);
            }
            case MULTIPLICATION -> {
                yield multiplication(var1, var2);
            }
            case DIVISION -> {
                while (var2 == 0) {
                    System.out.println("""
                            \nDivision by Zero is undefined
                                Please pick a new numbers to divide by
                            """);
                    double retryResult[] = numberOneAndTwo();
                    var1 = retryResult[0];
                    var2 = retryResult[1];
                }
                yield division(var1, var2);
            }
            case EXPONENT -> {
                while (var1 < 0 && var2 > -1 && var2 < 1) {
                    System.out.println("""
                            \nThis calculator cannot root a negative number
                                Please pick new numbers
                            """);
                    double retryResult[] = numberOneAndTwo();
                    var1 = retryResult[0];
                    var2 = retryResult[1];
                    
                }
                yield exponent(var1, var2);
            }
            default -> 0;
        };

        return answer;
    }

    public static double[] numberOneAndTwo() {
        double var1 = 1;
        double var2 = 2;
        System.out.println("""
                Enter in a number.
                """);
        Scanner keyboard = new Scanner(System.in);
        var1 = keyboard.nextDouble();
        System.out.println("""
                \nEnter the second number...

                Use this number to
                    add, subtract, multiply, divide, raise by
                the first number.
                """);
        var2 = keyboard.nextDouble();
        return new double[] {var1, var2};
        
    }

    public static double retryNumberTwo() {
        System.out.println("""
                \nEnter the second number...

                Use this number to
                    add, subtract, multiply, divide, raise by
                the first number.
                """);
        Scanner keyboard = new Scanner(System.in);
        double var2 = keyboard.nextDouble();
        return var2;
        
    }

    public static String operand() {
        System.out.println("""
                \nEnter the operator to perform:
                '+' '-' '*' '/' '^'
                """);

        Scanner keyboard = new Scanner(System.in);
        String operation = keyboard.nextLine();
        return operation;
    }

    public static double addition(double var1, double var2) {
        double answer = var1 + var2;
        return answer;
    }

    public static double subtraction(double var1, double var2) {
        double answer = var1 - var2;
        return answer;
    }

    public static double multiplication(double var1, double var2) {
        double answer = var1 * var2;
        return answer;
    }

    public static double division(double var1, double var2) {
        double answer = var1 / var2;
        return answer;
    }

    public static double exponent(double var1, double var2) {
        double answer = Math.pow(var1, var2);
        return answer;
    }
}
 