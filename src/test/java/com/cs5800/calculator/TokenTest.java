package com.cs5800.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for tokenizer.
 */
public class TokenTest
{

    @Test
    public void tokenShouldBeOfTypeOPERAND(){
        Token t = new Token("7");
        assertEquals(t.getTYPE(), Token.TYPE.OPERAND);

        t = new Token("4.0");
        assertEquals(t.getTYPE(), Token.TYPE.OPERAND);
    }

    @Test
    public void tokenShouldBeOfTypeOPERATOR(){
        Token t = new Token("+");
        assertEquals(t.getTYPE(), Token.TYPE.OPERATOR);

        t = new Token("-");
        assertEquals(t.getTYPE(), Token.TYPE.OPERATOR);

        t = new Token("/");
        assertEquals(t.getTYPE(), Token.TYPE.OPERATOR);

        t = new Token("%");
        assertEquals(t.getTYPE(), Token.TYPE.OPERATOR);

        t = new Token("*");
        assertEquals(t.getTYPE(), Token.TYPE.OPERATOR);
    }

    @Test(expected = ExceptionInInitializerError.class)
    public void checkTokenConstructorInitError(){
        Token t = new Token("|");
    }

    @Test
    public void checkNegativeSignWorks(){
        Token t = new Token("-7");
        assertEquals((double)(-7.0), t.getOperand(), 0.01);

        t = new Token("-4.0");
        assertEquals((double)(-4.0), t.getOperand(), 0.01);
    }

}