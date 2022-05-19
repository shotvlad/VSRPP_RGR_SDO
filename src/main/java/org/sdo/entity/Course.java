package org.sdo.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_courses")
@AttributeOverride(name = "id", column = @Column(name = "CourseNum"))
public class Course extends AbstractEntity {
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Info", nullable = false, length = 500)
    private String info;

    @Column(name = "Price", nullable = false, length = 10)
    private double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    private Date statusDate;

    @ManyToMany
    @JoinTable(name = "t_students_courses",
            joinColumns = @JoinColumn(name = "course_CourseNum"),
            inverseJoinColumns = @JoinColumn(name = "student_StudentNum"))
    private List<Student> students;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<Theory> theories;

    public Course() {
    }

    public Course(String name, String info, double price, Date statusDate, List<Student> students, List<Theory> theories) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.statusDate = statusDate;
        this.students = students;
        this.theories = theories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Theory> getTheories() {
        return theories;
    }

    public void setTheories(List<Theory> theories) {
        this.theories = theories;
    }

    @JsonGetter("theories")
    public int getTheoriesSize() {
        return theories.size();
    }

    @JsonGetter("students")
    public int getStudentsSize() {
        return students.size();
    }

    @Override
    public String toString(){
        return "Название курса: " + this.getName() + "\n" +
                "Информация: " + this.getInfo() + "\n" +
                "Стоимость: " + this.getPrice();
    }
}
