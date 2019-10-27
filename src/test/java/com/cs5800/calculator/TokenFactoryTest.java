package com.cs5800.calculator;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 * Unit test for tokenizer.
 */
public class TokenFactoryTest
{

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void tokenShouldBeOfTypeOPERAND(){
        Token t = TokenFactory.getInstanceToken("7");
        assertEquals(t.getClass(), OperandToken.class);

        t = TokenFactory.getInstanceToken("4.0");
        assertEquals(t.getClass(), OperandToken.class);
    }

    @Test
    public void tokenShouldBeOfTypeOPERATOR(){
        Token t = TokenFactory.getInstanceToken("+");
        assertEquals(t.getClass(), OperatorToken.class);

        t = TokenFactory.getInstanceToken("-");
        assertEquals(t.getClass(), OperatorToken.class);

        t = TokenFactory.getInstanceToken("/");
        assertEquals(t.getClass(), OperatorToken.class);

        t = TokenFactory.getInstanceToken("%");
        assertEquals(t.getClass(), OperatorToken.class);

        t = TokenFactory.getInstanceToken("*");
        assertEquals(t.getClass(), OperatorToken.class);
    }

    @Test
    public void checkTokenConstructorInitError(){
        thrown.expect(IllegalArgumentException.class);
        TokenFactory.getInstanceToken("|");
    }

    @Test
    public void checkTokenConstructionOnEmptyString(){
        thrown.expect(IllegalArgumentException.class);
        TokenFactory.getInstanceToken("");
    }

    @Test
    public void checkOperatorValue(){
        Token t = TokenFactory.getInstanceToken("+");
        assertEquals(((OperatorToken)t).getOperator(), '+');
        t = TokenFactory.getInstanceToken("-");
        assertEquals(((OperatorToken)t).getOperator(), '-');
        t = TokenFactory.getInstanceToken("/");
        assertEquals(((OperatorToken)t).getOperator(), '/');
        t = TokenFactory.getInstanceToken("%");
        assertEquals(((OperatorToken)t).getOperator(), '%');
        t = TokenFactory.getInstanceToken("*");
        assertEquals(((OperatorToken)t).getOperator(), '*');
    }

}