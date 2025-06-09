package com.java.career.models;

import java.sql.Timestamp;

public class Job {
    private int id;
    private int employerId;
    private String title;
    private String description;
    private String location;
    private String qualifications;
    private Timestamp createdAt;

    public Job() {}

    public Job(int id, int employerId, String title, String description, String location, String qualifications, Timestamp createdAt) {
        this.id = id;
        this.employerId = employerId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.qualifications = qualifications;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getEmployerId() {
        return employerId;
    }
    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getQualifications() {
        return qualifications;
    }
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
