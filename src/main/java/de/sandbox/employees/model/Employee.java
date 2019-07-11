package de.sandbox.employees.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Calendar creationDate;

    @OneToOne
    private Position position;

    @ManyToOne
    @JoinTable(name = "SUPERVISOR_RELATIONSHIP",
            joinColumns = {
                    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
            }
    )
    private Employee supervisor;


    @PrePersist
    void createdAt() {
        this.creationDate = Calendar.getInstance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

