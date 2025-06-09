package com.java.career.models;

public class JobSeeker {
    private int id;
    private int userId;
    private String education;
    private String experience;
    private String skills;

    public JobSeeker() {}

    public JobSeeker(int id, int userId, String education, String experience, String skills) {
        this.id = id;
        this.userId = userId;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
}
