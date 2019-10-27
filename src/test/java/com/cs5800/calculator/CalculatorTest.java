package com.cs5800.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for calculator.
 */
public class CalculatorTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void checkEvaluationOfComplexExpressions(){
        Calculator c = new Calculator();
        double result = c.evaluate("-7 % 3 + 5 * -3 - 15 + 5 / -5");
        assertEquals((double)(-32), result, 0.01);
    }

    @Test
    public void checkEvaluationOfEmptyExpressions(){
        Calculator c = new Calculator();
        thrown.expect(IllegalArgumentException.class);
        double result = c.evaluate("");
    }

    @Test
    public void InvalidExpressionTooManyOps(){
        Calculator c = new Calculator();
        thrown.expect(NoSuchElementException.class);
        double result = c.evaluate("--7");
    }

    @Test
    public void InvalidExpressionBadSpacing(){
        Calculator c = new Calculator();
        thrown.expect(IllegalArgumentException.class);
        double result = c.evaluate("7 +3");
    }

    @Test
    public void checkForCorrectPrecedence(){
        Calculator c = new Calculator();
        double result = c.evaluate("7 * 3 + 12 / 4");
        assertEquals((double)(24), result, 0.01);

        result = c.evaluate("7 + 3 / 3 - 3 * 3");
        assertEquals((double)(-1), result, 0.01);
    }

    @Test
    public void checkManyAdds(){
        Calculator c = new Calculator();
        double result = c.evaluate("7 + 3 + 4");
        assertEquals((double)(14), result, 0.01);

        result = c.evaluate("7 + 3 + 4 + 10 + 30 + 40000");
        assertEquals((double)(40054), result, 0.01);
    }

    @Test
    public void checkManySubs(){
        Calculator c = new Calculator();
        double result = c.evaluate("7 - 3 - 4");
        assertEquals((double)(0), result, 0.01);

        result = c.evaluate("0 - 7 - 3 - 12 - 15");
        assertEquals((double)(-37), result, 0.01);
    }

    @Test
    public void checkManyDivides(){
        Calculator c = new Calculator();
        double result = c.evaluate("20 / 5 / 2");
        assertEquals((double)(2), result, 0.01);

        result = c.evaluate("4 / 6 / 2 / 2");
        assertEquals((double)(0.16), result, 0.01);
    }

    @Test
    public void checkManyMultiplies(){
        Calculator c = new Calculator();
        double result = c.evaluate("5 * 4 * 2");
        assertEquals((double)(40), result, 0.01);

        result = c.evaluate("69 * 210 * 2 * 2 * 4");
        assertEquals((double)(231840), result, 0.01);
    }

    @Test
    public void checkManyModulus(){
        Calculator c = new Calculator();
        double result = c.evaluate("20 % 3 % 3");
        assertEquals((double)(2), result, 0.01);

        result = c.evaluate("100 % 9 % 1");
        assertEquals((double)(0), result, 0.01);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
