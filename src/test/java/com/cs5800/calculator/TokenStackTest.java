package com.cs5800.calculator;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Rule;

/**
 * Unit test for TokenStack
 */
public class TokenStackTest
{

    @Rule
    public ExpectedException thrown = ExpectedException.none();



    @Test 
    public void checkPopAndPush(){
        Token a = TokenFactory.getInstanceToken("7");
        Token b = TokenFactory.getInstanceToken("+");
        TokenStack tokenStack = new TokenStack();
        tokenStack.push(b);
        tokenStack.push(a);

        Token result = tokenStack.pop();
        assertEquals(a, result);

        result = tokenStack.pop();
        assertEquals(b, result);
    }

    @Test
    public void checkPopForNoSuchElementException(){
        Token a = TokenFactory.getInstanceToken("7");
        TokenStack tokenStack = new TokenStack();
        tokenStack.push(a);

        Token result = tokenStack.pop();
        assertEquals(a, result);

        thrown.expect(NoSuchElementException.class);
        result = tokenStack.pop();
    }

    @Test
    public void checkIsEmpty(){
        Token a = TokenFactory.getInstanceToken("7");
        TokenStack tokenStack = new TokenStack();
        tokenStack.push(a);

        boolean result = tokenStack.isEmpty();
        assertEquals(false, result);

        tokenStack.pop();
        result = tokenStack.isEmpty();
        assertEquals(true, result);
    }

    @Test 
    public void checkPeek(){
        Token a = TokenFactory.getInstanceToken("7");
        Token b = TokenFactory.getInstanceToken("+");
        TokenStack tokenStack = new TokenStack();
        tokenStack.push(b);
        tokenStack.push(a);

        Token result = tokenStack.peek();
        assertEquals(a, result);

        tokenStack.pop();
        result = tokenStack.peek();
        assertEquals(b, result);
    }

}
