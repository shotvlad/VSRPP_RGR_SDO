package org.sdo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_tasks")
@AttributeOverride(name = "id", column = @Column(name = "IdTask"))
public class Task extends AbstractEntity {
    @Column(name = "InfoTask", nullable = false, length = 500)
    private String infoTask;

    @OneToOne
    @MapsId
    @JoinColumn(name = "IdTask")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Theory theory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task")
    private List<StudentTask> studentTask;

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    private Date statusDate;

    public Task() {
    }

    public Task(String infoTask, Theory theory, List<StudentTask> studentTask, Date statusDate) {
        this.infoTask = infoTask;
        this.theory = theory;
        this.studentTask = studentTask;
        this.statusDate = statusDate;
    }

    public String getInfoTask() {
        return infoTask;
    }

    public void setInfoTask(String infoTask) {
        this.infoTask = infoTask;
    }

    public Theory getTheory() {
        return theory;
    }

    public void setTheory(Theory theory) {
        this.theory = theory;
    }

    public List<StudentTask> getStudentTask() {
        return studentTask;
    }

    public void setStudentTask(List<StudentTask> studentTask) {
        this.studentTask = studentTask;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
