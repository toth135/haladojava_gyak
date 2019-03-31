package hu.me.SpringCalculator.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class InputValues {

    @NotEmpty
    @NotNull
    private String operator;

    @NotNull
    private Double operand1;

    @NotNull
    private Double operand2;

    public InputValues(@NotEmpty @NotNull String operator, @NotNull Double operand1, @NotNull Double operand2) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }
}
