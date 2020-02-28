package com.example.crud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
/* @Table(name="tbldepartment", catalog = "test") */
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
  /*  private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String head) {
        this.location = location;
    }*/

    @OneToMany(mappedBy = "category",  fetch = FetchType.LAZY ,  orphanRemoval = true)
   public List<Car> cars;

    public Category() {
        cars = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
