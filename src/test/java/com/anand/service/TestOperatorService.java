package com.anand.service;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestOperatorService {
    @Test
    public void testAdd(){

        Assert.assertEquals("2+2=4",new OperatorService().add(BigInteger.TWO,BigInteger.TWO));
    }
    @Test
    public void testSubtract(){
        Assert.assertEquals("2-1=1",new OperatorService().subtract(BigInteger.TWO,BigInteger.ONE));
    }
    @Test
    public void testMultiply(){
        Assert.assertEquals("2*2=4",new OperatorService().multiply(BigInteger.TWO,BigInteger.TWO));
    }
    @Test
    public void testDivide(){
        Assert.assertEquals("4/2=2",new OperatorService().divide(BigInteger.valueOf(4),BigInteger.TWO));
    }

    @Test
    public void testBuildResponse(){
        Assert.assertEquals("4+2=6",new OperatorService().buildResponse(BigInteger.valueOf(4),BigInteger.TWO,"plus",BigInteger.valueOf(6)));
        Assert.assertEquals("4-2=2",new OperatorService().buildResponse(BigInteger.valueOf(4),BigInteger.TWO,"minus",BigInteger.valueOf(2)));
        Assert.assertEquals("4*2=8",new OperatorService().buildResponse(BigInteger.valueOf(4),BigInteger.TWO,"multiply",BigInteger.valueOf(8)));
        Assert.assertEquals("4/2=2",new OperatorService().buildResponse(BigInteger.valueOf(4),BigInteger.TWO,"divide",BigInteger.valueOf(2)));
    }
}
