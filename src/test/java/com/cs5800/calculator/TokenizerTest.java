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
        Token[] tokensFromTokenizer = t.getTokens();

        Token[] tokens = {TokenFactory.getInstanceToken("7"), TokenFactory.getInstanceToken("+"), TokenFactory.getInstanceToken("3")};
        for(int i = 0; i<tokens.length ; i++){
            if(tokens[i] instanceof OperandToken)
                assertEquals(((OperandToken)tokensFromTokenizer[i]).getOperand(), ((OperandToken)tokens[i]).getOperand(), 0.01);
            else if(tokens[i] instanceof OperatorToken)
                assertEquals(((OperatorToken)tokensFromTokenizer[i]).getOperator(), ((OperatorToken)tokens[i]).getOperator());
        }
    }

    

}
