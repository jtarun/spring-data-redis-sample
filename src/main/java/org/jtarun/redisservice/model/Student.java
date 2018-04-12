package org.jtarun.redisservice.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "STUDENT")
public class Student  implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;

    public Student(){}

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
