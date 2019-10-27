package com.cs5800.calculator;



/**
 * OperatorToken
 */
public class OperatorToken extends Token
{
    private char operator;
    private int precedenceLevel;



    OperatorToken(char opInput){
        operator = opInput;
            
        //https://en.wikipedia.org/wiki/Order_of_operations#Programming_languages
        if(operator == '+' || operator == '-'){
            precedenceLevel = 4;
        }
        else if (operator == '*' || operator == '/' || operator == '%'){
            precedenceLevel = 3;
        }
    }

    OperatorToken(String input){
        this(input.charAt(0));
        if(input.length() != 1) throw new IllegalArgumentException("Creating token with multiline string");
    }

    public char getOperator(){
        return operator;
    }

    public int getPrecedenceLevel(){
        return precedenceLevel;
    }

    public int comparePrecedenceTo(OperatorToken rightOperand){
        if(this.getPrecedenceLevel() > rightOperand.getPrecedenceLevel())
            return 1;
        else if(this.getPrecedenceLevel() < rightOperand.getPrecedenceLevel())
            return -1;
        else
            return 0;
    }

    public OperandToken operate(OperandToken leftOperand, OperandToken rightOperand){
        double result = 0.0;

        switch(this.operator){
            case '+':
                result = leftOperand.getOperand() + rightOperand.getOperand();
                break;
            case '-':
                result = leftOperand.getOperand() - rightOperand.getOperand();
                break;
            case '*':
                result = leftOperand.getOperand() * rightOperand.getOperand();
                break;
            case '/':
                if(rightOperand.getOperand() == 0.0){throw new ArithmeticException("Divide By Zero");}
                result = leftOperand.getOperand() / rightOperand.getOperand();
                break;
            case '%':
                result = leftOperand.getOperand() % rightOperand.getOperand();
                break;
            default:
                throw new IllegalArgumentException("Unknown Operator");

        }

        return new OperandToken(result);
    }

}
