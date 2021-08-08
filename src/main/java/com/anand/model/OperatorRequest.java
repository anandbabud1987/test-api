package com.anand.model;


import com.anand.enums.OperatorEnum;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;



@Validated
public class OperatorRequest {
    @NotNull(message = "operator is required")
    private OperatorEnum operator;
    @NotNull(message = "left is required")
    private int left;
    @NotNull(message = "right is required")
    private int right;

    public OperatorEnum getOperator() {
        return operator;
    }

    public void setOperator(OperatorEnum operator) {
        this.operator = operator;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
