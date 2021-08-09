package com.anand.model;


import com.anand.enums.OperatorEnum;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;


@Validated
public class OperatorRequest {
    @NotNull(message = "operator is required")
    private OperatorEnum operator;
    @NotNull(message = "left is required")
    private BigInteger left;
    @NotNull(message = "right is required")
    private BigInteger right;

    public OperatorEnum getOperator() {
        return operator;
    }

    public void setOperator(OperatorEnum operator) {
        this.operator = operator;
    }

    public BigInteger getLeft() {
        return left;
    }

    public void setLeft(BigInteger left) {
        this.left = left;
    }

    public BigInteger getRight() {
        return right;
    }

    public void setRight(BigInteger right) {
        this.right = right;
    }
}
