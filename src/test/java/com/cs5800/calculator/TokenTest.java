package com.cs5800.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for tokenizer.
 */
public class TokenTest
{
    @Test
    public void operandTokenShouldBeTypeTokenAndOperandToken(){
        OperandToken t = new OperandToken("7");
        assertTrue(t instanceof OperandToken);
        assertTrue(t instanceof Token);
    }

    @Test
    public void operatorTokenShouldBeTypeTokenAndOperatorToken(){
        OperatorToken t = new OperatorToken("+");
        assertTrue(t instanceof OperatorToken);
        assertTrue(t instanceof Token);
    }
}