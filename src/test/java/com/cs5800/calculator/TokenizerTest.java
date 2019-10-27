package com.cs5800.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for tokenizer.
 */
public class TokenizerTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testHello(){
        Calculator.hello();
        assertEquals("hello" + System.getProperty("line.separator"), outContent.toString());
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
