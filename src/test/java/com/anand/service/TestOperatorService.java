package com.anand.service;
import org.junit.Assert;
import org.junit.Test;

public class TestOperatorService {
    @Test
    public void testAdd(){
        Assert.assertEquals(4,new OperatorService().add(2,2));
    }
    @Test
    public void testSubtract(){
        Assert.assertEquals(2,new OperatorService().subtract(4,2));
    }
    @Test
    public void testMultiply(){
        Assert.assertEquals(4,new OperatorService().multiply(2,2));
    }
    @Test
    public void testDivide(){
        Assert.assertEquals(2,new OperatorService().divide(4,2));
    }
}
