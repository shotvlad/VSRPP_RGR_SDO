package org.sdo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_students_tasks")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class StudentTask extends AbstractEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StudentNum", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdTask", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Task task;

    @Column(name = "Status", nullable = false, length = 15)
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    private Date statusDate;

    public StudentTask() {
    }

    public StudentTask(Student student, Task task, String status, Date statusDate) {
        this.student = student;
        this.task = task;
        this.status = status;
        this.statusDate = statusDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "Статус: " + this.getStatus();
    }
}
