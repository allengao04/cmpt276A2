package com.example.a2.models;
import jakarta.persistence.*;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String haircolour;
    private double gpa;

    public User() { 
    }
    public User(String name, int weight, int height,String haircolour, Double gpa) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.haircolour = haircolour;
        this.gpa = gpa;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getHaircolour() {
        return haircolour;
    }
    public void setHaircolour(String haircolour) {
        this.haircolour = haircolour;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
}
