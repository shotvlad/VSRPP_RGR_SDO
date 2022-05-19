package org.sdo.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_students")
@AttributeOverride(name = "id", column = @Column(name = "StudentNum"))
public class Student extends AbstractEntity{
    @Column(name = "Surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "Patronymic", nullable = false, length = 30)
    private String patronymic;

    @Column(name = "Phone", nullable = false, length = 30)
    private String phone;

    @Column(name = "Email", nullable = false, length = 30)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    private Date statusDate;

    @ManyToMany
    @JoinTable (name="t_students_courses",
            joinColumns=@JoinColumn (name="student_StudentNum"),
            inverseJoinColumns=@JoinColumn(name="course_CourseNum"))
    private List<Course> course;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<StudentTask> studentTask;

    public Student() {
    }

    public Student(String surname, String name, String patronymic, String phone, String email, Date statusDate, List<Course> course, List<StudentTask> studentTask) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.statusDate = statusDate;
        this.course = course;
        this.studentTask = studentTask;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<StudentTask> getStudentTask() {
        return studentTask;
    }

    public void setStudentTask(List<StudentTask> studentTask) {
        this.studentTask = studentTask;
    }

    @JsonGetter("course")
    public int getCourseSize() {
        return course.size();
    }

    @Override
    public String toString(){
        return "ФИО: " + this.getSurname()+ " " + this.getName() + " " + this.getPatronymic() + "\n" +
                "Номер ID: " + this.getId();
    }
}
