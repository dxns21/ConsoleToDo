package com.dxns.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int Id;

    @Column(name = "name")
    public String Name;

    @Column(name = "status")
    public String Status;

    @Column(name = "place")
    public String Place;


    public TaskEntity(int id, String name, String status, String place)
    {
        this.Id = id;
        this.Name = name;
        this.Status = status;
        this.Place = place;
    }

    public TaskEntity()
    {

    }


    public Integer getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus()
    {
        return Status;
    }

    public void setStatus(String status)
    {
        Status = status;
    }

    public String getPlace()
    {
        return Place;
    }

    public void setPlace(String place)
    {
        Place = place;
    }

    @Override
    public String toString() {
        return "Zadanie nr: " + this.Id + ", Nazwa: " + this.Name + ", Status: " + this.Status + ", Lista: " + this.Place;
    }
}
