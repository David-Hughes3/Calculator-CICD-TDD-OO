package com.cs5800.calculator;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 * Unit test for tokenizer.
 */
public class TokenTest
{

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void checkTokenConstructorInitError(){
        thrown.expect(IllegalArgumentException.class);
        new Token("|");
    }

    @Test
    public void checkTokenConstructionOnEmptyString(){
        thrown.expect(IllegalArgumentException.class);
        new Token("");
    }

    @Test
    public void checkNegativeSignWorks(){
        Token t = new Token("-7");
        assertEquals((double)(-7.0), t.getOperand(), 0.01);

        t = new Token("-4.0");
        assertEquals((double)(-4.0), t.getOperand(), 0.01);
    }

    @Test
    public void checkOperatorValue(){
        Token t = new Token("+");
        assertEquals(t.getOperator(), '+');
        t = new Token("-");
        assertEquals(t.getOperator(), '-');
        t = new Token("/");
        assertEquals(t.getOperator(), '/');
        t = new Token("%");
        assertEquals(t.getOperator(), '%');
        t = new Token("*");
        assertEquals(t.getOperator(), '*');
    }

    @Test
    public void operateOverTokensShouldReturnCorrectValue(){
        Token a = new Token("5");
        Token b = new Token("4");
        Token op = new Token("+");
        Token result = op.operate(a, b);

        assertEquals(result.getOperand(), (double)(9.0), 0.01);
    }

    @Test
    public void checkPrecendenceLevels(){
        Token op_add = new Token("+");
        Token op_mult = new Token("*");
        Token op_divide = new Token("/");
        Token op_mod = new Token("%");
        Token op_sub = new Token("-");

        assertEquals(4,op_add.getPrecedenceLevel());
        assertEquals(4,op_sub.getPrecedenceLevel());

        assertEquals(3,op_mult.getPrecedenceLevel());
        assertEquals(3,op_divide.getPrecedenceLevel());
        assertEquals(3,op_mod.getPrecedenceLevel());
    }

    @Test
    public void comparePrecedenceLevels(){
        Token op_add = new Token("+");
        Token op_mult = new Token("*");
        Token op_divide = new Token("/");
        Token op_mod = new Token("%");
        Token op_sub = new Token("-");

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
        Token a = new Token("5.0");
        Token b = new Token("64");
        Token op = new Token("+");
        Token result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(69.0), 0.01);

        result = op.operate(new Token(-5), new Token(-6));
        assertEquals(result.getOperand(), (double)(-11), 0.01);

        result = op.operate(new Token(6), new Token(-5));
        assertEquals(result.getOperand(), (double)(1), 0.01);

        result = op.operate(new Token(-6), new Token(5));
        assertEquals(result.getOperand(), (double)(-1), 0.01);
    }

    @Test
    public void checkMult(){
        Token a = new Token("5");
        Token b = new Token("4");
        Token op = new Token("*");
        Token result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(20), 0.01);

        result = op.operate(new Token(6), new Token(5));
        assertEquals(result.getOperand(), (double)(30), 0.01);

        result = op.operate(new Token(-6), new Token(5));
        assertEquals(result.getOperand(), (double)(-30), 0.01);

        result = op.operate(new Token(6), new Token(-5));
        assertEquals(result.getOperand(), (double)(-30), 0.01);
    }

    @Test 
    public void multiplyByZeroShouldEqualZero(){
        Token op = new Token("*");

        Token result = op.operate(new Token(0), new Token(5));
        assertEquals(result.getOperand(), (double)(0), 0.000001);

        result = op.operate(new Token(5), new Token(0));
        assertEquals(result.getOperand(), (double)(0), 0.000001);

        result = op.operate(new Token(0), new Token(0));
        assertEquals(result.getOperand(), (double)(0), 0.000001);
    }

    @Test
    public void checkDivision(){
        Token a = new Token("20");
        Token b = new Token("5");
        Token op = new Token("/");
        Token result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(4.0), 0.01);

        result = op.operate(new Token(-6), new Token(5));
        assertEquals(result.getOperand(), (double)(-1.2), 0.01); 
        
        result = op.operate(new Token(6), new Token(-5));
        assertEquals(result.getOperand(), (double)(-1.2), 0.01);   
    }

    @Test
    public void checkHandlingOfZeroInDivision(){
        Token op = new Token("/");

        Token result = op.operate(new Token(0), new Token(5));
        assertEquals(result.getOperand(), (double)(0), 0.000001);

        thrown.expect(ArithmeticException.class);
        result = op.operate(new Token(5), new Token(0));

        thrown.expect(ArithmeticException.class);
        result = op.operate(new Token(0), new Token(0));
    }

    @Test
    public void checkSubtraction(){
        Token a = new Token("5");
        Token b = new Token("4");
        Token op = new Token("-");
        Token result = op.operate(a, b);
        assertEquals(result.getOperand(), (double)(1.0), 0.01);

        result = op.operate(new Token(6), new Token(5));
        assertEquals(result.getOperand(), (double)(1), 0.01);   

        result = op.operate(new Token(-6), new Token(5));
        assertEquals(result.getOperand(), (double)(-11), 0.01);  
        
        result = op.operate(new Token(-6), new Token(-5));
        assertEquals(result.getOperand(), (double)(-1), 0.01);   
    }

    @Test
    public void checkModulus(){
        Token a = new Token("5");
        Token b = new Token("4");
        Token op = new Token("%");
        Token result = op.operate(a, b);

        assertEquals(result.getOperand(), (double)(1), 0.01);

        result = op.operate(new Token(20), new Token(5));
        assertEquals(result.getOperand(), (double)(0), 0.01); 
        
        result = op.operate(new Token(60), new Token(7));
        assertEquals(result.getOperand(), (double)(4), 0.01);   
    }

}