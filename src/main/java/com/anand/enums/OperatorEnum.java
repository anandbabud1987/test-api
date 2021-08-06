package com.anand.enums;

public enum OperatorEnum {
    plus("plus"),
    minus("minus"),
    multiply("multiply"),
    divide("divide");

    private String oprt;

    OperatorEnum(String input) {
        this.oprt = input;
    }

    public String getOprt() {
        return oprt;
    }
}
