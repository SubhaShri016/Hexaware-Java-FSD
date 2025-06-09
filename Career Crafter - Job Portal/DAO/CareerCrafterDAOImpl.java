package com.java.career.dao;

import com.java.career.models.*;
import com.java.career.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CareerCrafterDAOImpl implements CareerCrafterDAO {

    private Connection conn = DBConnection.getConnection();

    // USERS
    public void insertUser(User user) {
        try {
            String sql = "INSERT INTO users (id, name, email, password, role, created_at) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setTimestamp(6, user.getCreatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public void insertEmployer(Employer employer) {
        try {
            String sql = "INSERT INTO employers (id, user_id, company_name, location, website) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employer.getId());
            ps.setInt(2, employer.getUserId());
            ps.setString(3, employer.getCompanyName());
            ps.setString(4, employer.getLocation());
            ps.setString(5, employer.getWebsite());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employer> getAllEmployers() {
        List<Employer> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employers");
            while (rs.next()) {
                Employer e = new Employer();
                e.setId(rs.getInt("id"));
                e.setUserId(rs.getInt("user_id"));
                e.setCompanyName(rs.getString("company_name"));
                e.setLocation(rs.getString("location"));
                e.setWebsite(rs.getString("website"));
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public void insertJobSeeker(JobSeeker js) {
        try {
            String sql = "INSERT INTO job_seekers (id, user_id, education, experience, skills) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, js.getId());
            ps.setInt(2, js.getUserId());
            ps.setString(3, js.getEducation());
            ps.setString(4, js.getExperience());
            ps.setString(5, js.getSkills());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<JobSeeker> getAllJobSeekers() {
        List<JobSeeker> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM job_seekers");
            while (rs.next()) {
                JobSeeker js = new JobSeeker();
                js.setId(rs.getInt("id"));
                js.setUserId(rs.getInt("user_id"));
                js.setEducation(rs.getString("education"));
                js.setExperience(rs.getString("experience"));
                js.setSkills(rs.getString("skills"));
                list.add(js);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

   
    public void insertJob(Job job) {
        try {
            String sql = "INSERT INTO jobs (id, employer_id, title, description, location, qualifications, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, job.getId());
            ps.setInt(2, job.getEmployerId());
            ps.setString(3, job.getTitle());
            ps.setString(4, job.getDescription());
            ps.setString(5, job.getLocation());
            ps.setString(6, job.getQualifications());
            ps.setTimestamp(7, job.getCreatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Job> getAllJobs() {
        List<Job> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM jobs");
            while (rs.next()) {
                Job j = new Job();
                j.setId(rs.getInt("id"));
                j.setEmployerId(rs.getInt("employer_id"));
                j.setTitle(rs.getString("title"));
                j.setDescription(rs.getString("description"));
                j.setLocation(rs.getString("location"));
                j.setQualifications(rs.getString("qualifications"));
                j.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public void insertApplication(Application app) {
        try {
            String sql = "INSERT INTO applications (id, job_id, job_seeker_id, resume_path, status, applied_at) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, app.getId());
            ps.setInt(2, app.getJobId());
            ps.setInt(3, app.getJobSeekerId());
            ps.setString(4, app.getResumePath());
            ps.setString(5, app.getStatus());
            ps.setTimestamp(6, app.getAppliedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Application> getAllApplications() {
        List<Application> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM applications");
            while (rs.next()) {
                Application a = new Application();
                a.setId(rs.getInt("id"));
                a.setJobId(rs.getInt("job_id"));
                a.setJobSeekerId(rs.getInt("job_seeker_id"));
                a.setResumePath(rs.getString("resume_path"));
                a.setStatus(rs.getString("status"));
                a.setAppliedAt(rs.getTimestamp("applied_at"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public void insertResume(Resume resume) {
        try {
            String sql = "INSERT INTO resumes (id, job_seeker_id, file_path, uploaded_at) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, resume.getId());
            ps.setInt(2, resume.getJobSeekerId());
            ps.setString(3, resume.getFilePath());
            ps.setTimestamp(4, resume.getUploadedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Resume> getAllResumes() {
        List<Resume> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM resumes");
            while (rs.next()) {
                Resume r = new Resume();
                r.setId(rs.getInt("id"));
                r.setJobSeekerId(rs.getInt("job_seeker_id"));
                r.setFilePath(rs.getString("file_path"));
                r.setUploadedAt(rs.getTimestamp("uploaded_at"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
