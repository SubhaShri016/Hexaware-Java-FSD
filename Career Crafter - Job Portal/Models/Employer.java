package com.java.career.models;

public class Employer {
    private int id;
    private int userId;
    private String companyName;
    private String location;
    private String website;

    public Employer() {}

    public Employer(int id, int userId, String companyName, String location, String website) {
        this.id = id;
        this.userId = userId;
        this.companyName = companyName;
        this.location = location;
        this.website = website;
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

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
}
