package hu.me.SpringCalculator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    private Long userId;

    private String username;
    private int age;

    @OneToMany(mappedBy = "user")
    private List<InputEntity> inputEntities;

    public User() {

    }

    public User(Long userId, String username, int age) {
        this.userId = userId;
        this.username = username;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<InputEntity> getInputEntities() {
        return inputEntities;
    }

    public void setInputEntities(List<InputEntity> inputEntities) {
        this.inputEntities = inputEntities;
    }
}
