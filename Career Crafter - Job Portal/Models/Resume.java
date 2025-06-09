package com.java.career.models;

import java.sql.Timestamp;

public class Resume {
    private int id;
    private int jobSeekerId;
    private String filePath;
    private Timestamp uploadedAt;

    public Resume() {}

    public Resume(int id, int jobSeekerId, String filePath, Timestamp uploadedAt) {
        this.id = id;
        this.jobSeekerId = jobSeekerId;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getJobSeekerId() {
        return jobSeekerId;
    }
    public void setJobSeekerId(int jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Timestamp getUploadedAt() {
        return uploadedAt;
    }
    public void setUploadedAt(Timestamp uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
