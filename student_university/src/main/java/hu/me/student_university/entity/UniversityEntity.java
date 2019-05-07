package hu.me.student_university.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String universityName;
    private String faculty;
    private String specialization;

    @ManyToMany(mappedBy = "universityEntities")
    private Set<StudentEntity> studentEntities;

    public  UniversityEntity() {

    }

    public UniversityEntity(Long id, String universityName, String faculty, String specialization) {
        this.id = id;
        this.universityName = universityName;
        this.faculty = faculty;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
