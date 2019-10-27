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
        operatorStack = new TokenStack();
        operandStack = new TokenStack();
    }



    public double evaluate(String input) {
        double result;
        
        Token[] inputTokens = new Tokenizer(input).getTokens();
        handleAllInputTokens(inputTokens);
        finishOperatorStack();

        result = operandStack.pop().getOperand();
        if(!operatorStack.isEmpty() || !operandStack.isEmpty()){
            throw new IllegalArgumentException("Invalid input string (unbalanced number of operands/operators): " + input);
        } 

        return result;
    }

    private void handleAllInputTokens(Token[] inputTokens){
        for(int i = 0; i < inputTokens.length; i++){
            Token currentToken = inputTokens[i];

            if(currentToken.getTYPE() == Token.TYPE.OPERAND){
                operandStack.push(currentToken);
            }
            else if(currentToken.getTYPE() == Token.TYPE.OPERATOR){
                handlePushingOperand(currentToken);
            }
        }
    }

    private void handlePushingOperand(Token newOperatorToken){
        if(operatorStack.isEmpty() || newOperatorToken.comparePrecedenceTo(operatorStack.peek()) == -1 ) {
            operatorStack.push(newOperatorToken);
        }
        else{
            while(!operatorStack.isEmpty() && newOperatorToken.comparePrecedenceTo(operatorStack.peek()) >= 0){
                computeWithTopOperator();
            }
            operatorStack.push(newOperatorToken);
        }
    }

    private void computeWithTopOperator(){
        Token op = operatorStack.pop();
        Token rightOperand = operandStack.pop();
        Token leftOperand = operandStack.pop();
        

        Token result = op.operate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    private void finishOperatorStack(){
        while(!operatorStack.isEmpty()){
            computeWithTopOperator();
        }
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        double result;

        if(args.length == 0){
            System.out.println("Enter expression with components seperated by spaces: ");
            String input = inputScanner.nextLine();
    
            result = calculator.evaluate(input);
            System.out.println(result);
        }
        else{
            for(String arg: args){
                result = calculator.evaluate(arg);
                System.out.println(result);
            }
        }
    }

}
