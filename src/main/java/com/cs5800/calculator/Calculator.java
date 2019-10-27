package com.cs5800.calculator;

import java.util.Scanner;

/**
 * Calculator
 */
public class Calculator {
    private TokenStack operatorStack;
    private TokenStack operandStack;
    private static Scanner inputScanner = new Scanner(System.in);

    Calculator() {
        setOperatorStack(new TokenStack());
        setOperandStack(new TokenStack());
    }



    public double evaluate(String input) {
        double result = 10.0;
        
        Token[] inputTokens = new Tokenizer(input).getTokens();


        return result;
    }



    public static void main(String[] args) {
        System.out.println("Enter expression with components seperated by spaces: ");
        String input = inputScanner.nextLine();

        Calculator calculator = new Calculator();
        double result = calculator.evaluate(input);
        System.out.println(result);
    }



    //getters/setters for unit testing
    public TokenStack getOperatorStack() {
        return operatorStack;
    }
    public void setOperatorStack(TokenStack operatorStack) {
        this.operatorStack = operatorStack;
    }
    public TokenStack getOperandStack() {
        return operandStack;
    }
    public void setOperandStack(TokenStack operandStack) {
        this.operandStack = operandStack;
    }
}
