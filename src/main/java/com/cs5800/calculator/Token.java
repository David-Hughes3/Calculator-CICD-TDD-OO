package com.cs5800.calculator;

import java.util.regex.Pattern;

/**
 * Token
 */
public class Token
{
    public enum TYPE{
        OPERAND, OPERATOR;
    }

    TYPE type;
    private double operand;
    private char operator;

    Token(String input) throws ExceptionInInitializerError {

        if(isDouble(input)){
            type = TYPE.OPERAND;
        }
        else if(input=="+" || input=="-" || input=="/" || input=="*" || input=="%"){
            type = TYPE.OPERATOR;
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
}