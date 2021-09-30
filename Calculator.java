package calculator;

import java.util.*;

public class Calculator {

    final String ADDITION = "+";
    final String SUBTRACTION = "-";
    final String MULTIPLICATION = "*";
    final String DIVISION = "/";

    public static void main(String[] args) {
        char answer = 'y';
        double result;
        
        System.out.println("""
                           This program is a calculator""");
        

        while (answer == 'y')
        {
            
            result = compute();
            System.out.print("""
                         The result is:
                         """ + result);
            answer = run();
        }
        
        System.exit(0);

    }

    public static char run() {
        System.out.print("""
                         
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

        System.out.println("""
                           Enter in two numbers you want to
                               add, subtract, multiply, or divide
                           
                           Those two numbers are?
                           """);
        Scanner keyboard = new Scanner(System.in);
        var1 = keyboard.nextDouble();
        System.out.println("and");
        var2 = keyboard.nextDouble();
        System.out.println("""
                           
                           Enter the operator to perform:                           
                           '+' '-' '*' '/'
                           
                           """);
        
        keyboard.nextLine();

        operation = keyboard.nextLine();
        switch (operation) {
            case "+" ->
                answer = addition(var1, var2);
            case "-" ->
                answer = subtraction(var1, var2);
            case "*" ->
                answer = multiplication(var1, var2);
            case "/" ->
                answer = division(var1, var2);
        }
        
    return answer;
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
}
