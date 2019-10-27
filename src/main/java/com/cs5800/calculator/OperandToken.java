package com.cs5800.calculator;



/**
 * OperandToken
 */
public class OperandToken extends Token
{
    private double operand;

    OperandToken(String input){
        operand = Double.parseDouble(input);
    }

    OperandToken(double input){
        operand = input;
    }

    public double getOperand(){
        return operand;
    }
}
