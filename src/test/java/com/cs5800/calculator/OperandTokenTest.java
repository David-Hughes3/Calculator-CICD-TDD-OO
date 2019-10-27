package com.cs5800.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperandTokenTest {

    @Test
    public void operandConstructorShouldHandleStrings(){
        OperandToken t = new OperandToken("700");
        assertEquals((double)(700), t.getOperand(), 0.01);
    }

    @Test
    public void operandConstructorShouldHandleDoubles(){
        OperandToken t = new OperandToken(70.0);
        assertEquals((double)(70.0), t.getOperand(), 0.01);
    }

    @Test
    public void checkNegativeSignWorks(){
        OperandToken t = new OperandToken("-7");
        assertEquals((double)(-7.0), t.getOperand(), 0.01);

        t = new OperandToken("-4.0");
        assertEquals((double)(-4.0), t.getOperand(), 0.01);
    }
}