package hu.me.SpringCalculator.controller.dto;

import javax.validation.constraints.Min;
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

    @Min(0)
    @NotNull
    private Long userId;

    @NotEmpty
    @NotNull
    private String username;

    @Min(1)
    @NotNull
    private Integer age;

    public InputValues() {

    }

    public InputValues(String operator, Double operand1,
                       Double operand2, Long userId, String username,
                       Integer age) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.userId = userId;
        this.username = username;
        this.age = age;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
