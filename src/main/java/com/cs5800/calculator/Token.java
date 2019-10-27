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
    private String operator;

    Token(String input) throws ExceptionInInitializerError {

        if(isDouble(input)){
            type = TYPE.OPERAND;
            operand = Double.parseDouble(input);
        }
        else if(input=="+" || input=="-" || input=="/" || input=="*" || input=="%"){
            type = TYPE.OPERATOR;
            operator = input;
        }
        else{
            throw new ExceptionInInitializerError("Unknown String Passed to Be Token");
        }
        
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

    public String getOperator(){
        if(type != TYPE.OPERATOR){
            throw new UnsupportedOperationException();
        }
        return operator;
    }
}