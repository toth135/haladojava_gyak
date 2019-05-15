package hu.me.SpringCalculator.entity;

import javax.persistence.*;

@Entity
public class InputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String operator;
    private Double operand1;
    private Double operand2;
    private Double result;

    private Long userId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_userId")
    private User user;

    public InputEntity() {
    }

    public InputEntity(String operator, Double operand1, Double operand2, Double result, Long userId) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.userId = userId;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

