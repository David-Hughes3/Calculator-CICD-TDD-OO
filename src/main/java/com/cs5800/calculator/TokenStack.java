package com.cs5800.calculator;

import java.util.ArrayDeque;

/**
 * TokenStack
 */
public class TokenStack
{
    private ArrayDeque<Token> tokens;

    public TokenStack(){
        tokens = new ArrayDeque<Token>();
    }

    public boolean isEmpty(){
        return tokens.isEmpty();
    }

    public Token peek() {
        return tokens.peek();
    }

    public void push(Token token){
        tokens.push(token);
    }

    public Token pop(){
        return tokens.pop();
    }
}