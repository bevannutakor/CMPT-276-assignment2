package com.assignment.assignmenttwo.models;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    
    private String name;
    private float weight;
    private float height;
    private String hairColor;
    private float gpa;
    private int gradClassYear;
    private int lates;

    public Student(){
        //empty default constructor
    }

    public Student(String name, float weight, float height, String hairColor, float gpa, int gradClassYear, int lates){
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
        this.gradClassYear = gradClassYear;
        this.lates = lates;
    }

    public int getUid(){
        return uid;
    }

    public void setUid(int uid){
        this.uid = uid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getGradClassYear() {
        return gradClassYear;
    }

    public void setGradClassYear(int gradClassYear) {
        this.gradClassYear = gradClassYear;
    }

    public int getLates() {
        return lates;
    }

    public void setLates(int lates) {
        this.lates = lates;
    }

    
}
