package com.cs5800.calculator;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 * Unit test for tokenizer.
 */
public class OperatorTokenTest
{

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void operateOverTokensShouldReturnCorrectValue(){
        OperandToken a = new OperandToken("5");
        OperandToken b = new OperandToken("4");
        OperatorToken op = new OperatorToken("+");
        OperandToken result = op.operate(a, b);

        assertEquals((double)(9.0), result.getOperand(),  0.01);
    }

    @Test
    public void checkPrecendenceLevels(){
        OperatorToken op_add = new OperatorToken("+");
        OperatorToken op_mult = new OperatorToken("*");
        OperatorToken op_divide = new OperatorToken("/");
        OperatorToken op_mod = new OperatorToken("%");
        OperatorToken op_sub = new OperatorToken("-");

        assertEquals(4, op_add.getPrecedenceLevel());
        assertEquals(4, op_sub.getPrecedenceLevel());

        assertEquals(3, op_mult.getPrecedenceLevel());
        assertEquals(3, op_divide.getPrecedenceLevel());
        assertEquals(3, op_mod.getPrecedenceLevel());
    }

    @Test
    public void comparePrecedenceLevels(){
        OperatorToken op_add = new OperatorToken('+');
        OperatorToken op_mult = new OperatorToken("*");
        OperatorToken op_divide = new OperatorToken("/");
        OperatorToken op_mod = new OperatorToken("%");
        OperatorToken op_sub = new OperatorToken("-");

        assertEquals(op_add.getPrecedenceLevel(), op_sub.getPrecedenceLevel());
        assertEquals(op_add.comparePrecedenceTo(op_sub), 0);

        assertEquals(op_mult.getPrecedenceLevel(), op_divide.getPrecedenceLevel());
        assertEquals(op_mod.getPrecedenceLevel(), op_mult.getPrecedenceLevel());

        assertTrue(op_add.getPrecedenceLevel()>op_mult.getPrecedenceLevel());
        assertEquals(op_add.comparePrecedenceTo(op_mult), 1);
        assertTrue(op_sub.getPrecedenceLevel()>op_mod.getPrecedenceLevel());

        assertEquals(op_mult.comparePrecedenceTo(op_add), -1);
    }



    @Test
    public void checkAddition(){
        OperandToken a = new OperandToken("5.0");
        OperandToken b = new OperandToken("64");
        OperatorToken op = new OperatorToken("+");
        OperandToken result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(69.0), 0.01);

        result = op.operate(new OperandToken(-5), new OperandToken(-6));
        assertEquals(result.getOperand(), (double)(-11), 0.01);

        result = op.operate(new OperandToken(6), new OperandToken(-5));
        assertEquals(result.getOperand(), (double)(1), 0.01);

        result = op.operate(new OperandToken(-6), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(-1), 0.01);
    }

    @Test
    public void checkMult(){
        OperandToken a = new OperandToken("5");
        OperandToken b = new OperandToken("4");
        OperatorToken op = new OperatorToken("*");
        OperandToken result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(20), 0.01);

        result = op.operate(new OperandToken(6), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(30), 0.01);

        result = op.operate(new OperandToken(-6), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(-30), 0.01);

        result = op.operate(new OperandToken(6), new OperandToken(-5));
        assertEquals(result.getOperand(), (double)(-30), 0.01);
    }

    @Test 
    public void multiplyByZeroShouldEqualZero(){
        OperatorToken op = new OperatorToken("*");

        OperandToken result = op.operate(new OperandToken(0), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(0), 0.000001);

        result = op.operate(new OperandToken(5), new OperandToken(0));
        assertEquals(result.getOperand(), (double)(0), 0.000001);

        result = op.operate(new OperandToken(0), new OperandToken(0));
        assertEquals(result.getOperand(), (double)(0), 0.000001);
    }

    @Test
    public void checkDivision(){
        OperandToken a = new OperandToken("20");
        OperandToken b = new OperandToken("5");
        OperatorToken op = new OperatorToken("/");
        OperandToken result = op.operate(a, b);
        assertEquals((double)(4.0), result.getOperand(),  0.01);

        result = op.operate(new OperandToken(-6), new OperandToken(5));
        assertEquals((double)(-1.2), result.getOperand(),  0.01); 
        
        result = op.operate(new OperandToken(6), new OperandToken(-5));
        assertEquals((double)(-1.2), result.getOperand(),  0.01);   
    }

    @Test
    public void checkHandlingOfZeroInDivision(){
        OperatorToken op = new OperatorToken("/");

        OperandToken result = op.operate(new OperandToken(0), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(0), 0.000001);

        thrown.expect(ArithmeticException.class);
        result = op.operate(new OperandToken(5), new OperandToken(0));

        thrown.expect(ArithmeticException.class);
        result = op.operate(new OperandToken(0), new OperandToken(0));
    }

    @Test
    public void checkSubtraction(){
        OperandToken a = new OperandToken("5");
        OperandToken b = new OperandToken("4");
        OperatorToken op = new OperatorToken("-");
        OperandToken result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(1.0), 0.01);

        result = op.operate(new OperandToken(6), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(1), 0.01);   

        result = op.operate(new OperandToken(-6), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(-11), 0.01);  
        
        result = op.operate(new OperandToken(-6), new OperandToken(-5));
        assertEquals(result.getOperand(), (double)(-1), 0.01);   
    }

    @Test
    public void checkModulus(){
        OperandToken a = new OperandToken("5");
        OperandToken b = new OperandToken("4");
        OperatorToken op = new OperatorToken("%");
        OperandToken result = op.operate(a, b);

        assertEquals(result.getOperand(), (double)(1), 0.01);

        result = op.operate(new OperandToken(20), new OperandToken(5));
        assertEquals(result.getOperand(), (double)(0), 0.01); 
        
        result = op.operate(new OperandToken(60), new OperandToken(7));
        assertEquals(result.getOperand(), (double)(4), 0.01);   
    }

}