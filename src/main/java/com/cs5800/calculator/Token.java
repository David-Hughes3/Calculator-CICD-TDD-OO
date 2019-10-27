package com.cs5800.calculator;

/**
 * Token
 */
public class Token
{
    public enum TYPE{
        OPERAND;
    }

    TYPE type;

    Token(String input){
        type = TYPE.OPERAND;
    }
}