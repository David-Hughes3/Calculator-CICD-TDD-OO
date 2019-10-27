package com.cs5800.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for calculator.
 */
public class CalculatorTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void checkSimpleEvaluation(){
        Calculator c = new Calculator();
        double result = c.evaluate("7 + 3");
        assertEquals((double)(10), result, 0.01);

        result = c.evaluate("7 - 3");
        assertEquals((double)(4), result, 0.01);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
