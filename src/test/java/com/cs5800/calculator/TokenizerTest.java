package com.cs5800.calculator;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for tokenizer.
 */
public class TokenizerTest
{

    @Test
    public void checkTokenizerProducesCorrectTokens(){
        Tokenizer t = new Tokenizer("   7 + 3");

        Token[] tokens = {new Token("7"), new Token("+"), new Token("3")};
        for(int i = 0; i<tokens.length ; i++){
            if(tokens[i].getTYPE() == Token.TYPE.OPERAND)
                assertEquals(tokens[i].getOperand(), tokens[i].getOperand(), 0.01);
            else if(tokens[i].getTYPE() == Token.TYPE.OPERATOR)
                assertEquals(tokens[i].getOperator(), tokens[i].getOperator());
        }
    }

    

}
