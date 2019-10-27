package com.cs5800.calculator;

/**
 * Tokenizer
 */
public class Tokenizer
{
    Token[] tokens;

    Tokenizer(String input){
        String[] splitBySpaces = input.trim().split(" ");
        tokens = new Token[splitBySpaces .length];

        for(int i = 0; i < splitBySpaces.length; i++){
            tokens[i] = TokenFactory.getInstanceToken(splitBySpaces[i]);
        }
    }

    public Token[] getTokens(){
        return tokens;
    }
}
