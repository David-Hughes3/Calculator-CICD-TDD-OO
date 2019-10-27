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
    private int precedenceLevel;

    Token(String input) {

        if(input == "" || input.trim() == ""){
            throw new IllegalArgumentException("Empty string passed to be Token");
        }

        if(isDouble(input)){
            type = TYPE.OPERAND;
            operand = Double.parseDouble(input);
        }
        else if(input.length() == 1 && input.charAt(0) =='+' || input.charAt(0) =='-' || input.charAt(0) =='/' || input.charAt(0) =='*' || input.charAt(0) =='%'){
            type = TYPE.OPERATOR;
            operator = input.charAt(0);
            
            //https://en.wikipedia.org/wiki/Order_of_operations#Programming_languages
            if(operator == '+' || operator == '-'){
                precedenceLevel = 4;
            }
            else if (operator == '*' || operator == '/' || operator == '%'){
                precedenceLevel = 3;
            }
        }
        else{
            throw new IllegalArgumentException("Unknown String Passed to Be Token: " + input);
        }
        
    }

    Token(double input){
        type = TYPE.OPERAND;
        operand = input;
    }


    private boolean isDouble(String str){
        try{
            Double.parseDouble(str);
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

    public int getPrecedenceLevel(){
        if(type != TYPE.OPERATOR){
            throw new UnsupportedOperationException();
        }
        return precedenceLevel;
    }

    public int comparePrecedenceTo(Token rightOperand){
        if(this.getPrecedenceLevel() > rightOperand.getPrecedenceLevel())
            return 1;
        else if(this.getPrecedenceLevel() < rightOperand.getPrecedenceLevel())
            return -1;
        else
            return 0;
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
                if(rightOperand.getOperand() == 0.0){throw new ArithmeticException("Divide By Zero");}
                result = leftOperand.getOperand() / rightOperand.getOperand();
                break;
            case '%':
                result = leftOperand.getOperand() % rightOperand.getOperand();
                break;
        }

        return new Token(result);
    }
}