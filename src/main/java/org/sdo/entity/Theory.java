package org.sdo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_theories")
@AttributeOverride(name = "id", column = @Column(name = "IdTheories"))
public class Theory extends AbstractEntity{
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Info", nullable = false, length = 500)
    private String info;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CourseCipher", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;

    @OneToOne(mappedBy = "theory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Task task;

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    private Date statusDate;

    public Theory() {
    }

    public Theory(String name, String info, Course course, Task task, Date statusDate) {
        this.name = name;
        this.info = info;
        this.course = course;
        this.task = task;
        this.statusDate = statusDate;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
