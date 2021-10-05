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
        double answer = 0, var1, var2;
        String operation;

        var1 = numberOne();
        var2 = numberTwo();
        operation = operand();
        
        answer = switch (operation) {
            case ADDITION -> addition(var1, var2);
            case SUBTRACTION -> subtraction(var1, var2);
            case MULTIPLICATION -> multiplication(var1, var2);
            case DIVISION -> {
                while (var2 == 0) {
                    System.out.println("""
                            \nDivision by Zero is undefined
                                Please pick a new number to divide by
                            """);
                    var2 = numberTwo();
                }
                yield division(var1, var2);
            }
            case EXPONENT -> {
                while (var1 < 0 && var2 > -1 && var2 < 1) {
                    System.out.println("""
                            \nThis calculator cannot root a negative number
                                Please pick new numbers
                            """);
                    var1 = numberOne();
                    var2 = numberTwo();
                }
                yield exponent(var1, var2);
            }
            
        };

        return answer;
    }

    public static double numberOne() {
        double var1;
        System.out.println("""
                Enter in a number.
                """);
        Scanner keyboard = new Scanner(System.in);
        var1 = keyboard.nextDouble();
        return var1;
    }

    public static double numberTwo() {
        double var2;
        System.out.println("""
                \nEnter the second number...

                Use this number to
                    add, subtract, multiply, divide, raise by
                the first number.
                """);
        Scanner keyboard = new Scanner(System.in);
        var2 = keyboard.nextDouble();
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
 