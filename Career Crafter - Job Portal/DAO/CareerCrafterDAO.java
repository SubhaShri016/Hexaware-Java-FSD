package com.java.career.dao;

import com.java.career.models.*;
import java.util.List;

public interface CareerCrafterDAO {

    
    void insertUser(User user);
    List<User> getAllUsers();

    
    void insertEmployer(Employer employer);
    List<Employer> getAllEmployers();

    
    void insertJobSeeker(JobSeeker jobSeeker);
    List<JobSeeker> getAllJobSeekers();

    
    void insertJob(Job job);
    List<Job> getAllJobs();

    
    void insertApplication(Application application);
    List<Application> getAllApplications();

    
    void insertResume(Resume resume);
    List<Resume> getAllResumes();
}
