package com.cs5800.calculator;

/**
 * Token
 */
public class Token
{
    public enum TYPE{
        OPERAND, OPERATOR;
    }

    private TYPE type;
    private double operand;
    private char operator;

    Token(String input) throws ExceptionInInitializerError {

        if(isDouble(input)){
            type = TYPE.OPERAND;
            operand = Double.parseDouble(input);
        }
        else if(input.length() == 1 && input.charAt(0) =='+' || input.charAt(0) =='-' || input.charAt(0) =='/' || input.charAt(0) =='*' || input.charAt(0) =='%'){
            type = TYPE.OPERATOR;
            operator = input.charAt(0);
        }
        else{
            throw new ExceptionInInitializerError("Unknown String Passed to Be Token");
        }
        
    }

    Token(double input){
        type = TYPE.OPERAND;
        operand = input;
    }



    private boolean isDouble(String str){
        try{
            double x = Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public TYPE getTYPE(){
        return type;
    }

    public double getOperand(){
        if(type != TYPE.OPERAND){
            throw new UnsupportedOperationException();
        }
        return operand;
    }

    public char getOperator(){
        if(type != TYPE.OPERATOR){
            throw new UnsupportedOperationException();
        }
        return operator;
    }

    public Token operate(Token leftOperand, Token rightOperand){
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
                result = leftOperand.getOperand() / rightOperand.getOperand();
                break;
            case '%':
                result = leftOperand.getOperand() % rightOperand.getOperand();
                break;
        }

        return new Token(result);
    }
}