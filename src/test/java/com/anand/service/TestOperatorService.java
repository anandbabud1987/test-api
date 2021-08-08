package com.anand.service;
import org.junit.Assert;
import org.junit.Test;

public class TestOperatorService {
    @Test
    public void testAdd(){

        Assert.assertEquals("2+2=4",new OperatorService().add(2,2));
    }
    @Test
    public void testSubtract(){
        Assert.assertEquals("4-2=2",new OperatorService().subtract(4,2));
    }
    @Test
    public void testMultiply(){
        Assert.assertEquals("2*2=4",new OperatorService().multiply(2,2));
    }
    @Test
    public void testDivide(){
        Assert.assertEquals("4/2=2",new OperatorService().divide(4,2));
    }

    @Test
    public void testBuildResponse(){
        Assert.assertEquals("4+2=6",new OperatorService().buildResponse(4,2,"plus",6));
        Assert.assertEquals("4-2=6",new OperatorService().buildResponse(4,2,"minus",6));
        Assert.assertEquals("4*2=6",new OperatorService().buildResponse(4,2,"multiply",6));
        Assert.assertEquals("4/2=6",new OperatorService().buildResponse(4,2,"divide",6));
    }
}
