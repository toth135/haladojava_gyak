package hu.me.student_university.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_university", joinColumns = @JoinColumn(name = "student_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "university_id", referencedColumnName = "id"))
    private Set<UniversityEntity> universityEntities;


    public StudentEntity() {

    }

    public StudentEntity(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
