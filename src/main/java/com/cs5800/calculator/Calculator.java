package com.cs5800.calculator;

import java.util.Scanner;

/**
 * Calculator
 */
public class Calculator
{
    private TokenStack operatorStack;
    private TokenStack operandStack;
    private static Scanner inputScanner = new Scanner(System.in);

    Calculator() {
        operatorStack = new TokenStack();
        operandStack = new TokenStack();
    }

    public double evaluate(String input){
        double result = 10.0;
        
        return result;
    }


    
    public static void main(String[] args) {
        System.out.println("Enter expression with components seperated by spaces: ");
        String input = inputScanner.nextLine();

        Calculator calculator = new Calculator();
        double result = calculator.evaluate(input);
        System.out.println(result);
    }
}
