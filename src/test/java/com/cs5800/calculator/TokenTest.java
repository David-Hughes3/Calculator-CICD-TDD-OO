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
        assertEquals(t.type, Token.TYPE.OPERAND);
    }

}