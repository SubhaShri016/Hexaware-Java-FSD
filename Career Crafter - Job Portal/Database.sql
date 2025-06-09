CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role ENUM('job_seeker', 'employer') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE employers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    company_name VARCHAR(150) NOT NULL,
    location VARCHAR(100),
    website VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE job_seekers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    education VARCHAR(255),
    experience VARCHAR(255),
    skills VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employer_id INT NOT NULL,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    location VARCHAR(100),
    qualifications VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (employer_id) REFERENCES employers(id) ON DELETE CASCADE
);

CREATE TABLE applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT NOT NULL,
    job_seeker_id INT NOT NULL,
    resume_path VARCHAR(255),
    status VARCHAR(50) DEFAULT 'pending',
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE,
    FOREIGN KEY (job_seeker_id) REFERENCES job_seekers(id) ON DELETE CASCADE
);

CREATE TABLE resumes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_seeker_id INT NOT NULL,
    file_path VARCHAR(255),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (job_seeker_id) REFERENCES job_seekers(id) ON DELETE CASCADE
);


INSERT INTO users (name, email, password, role, created_at) VALUES
('Alice Johnson', 'alice@example.com', 'alice123', 'job_seeker', NOW()),
('Bob Smith', 'bob@example.com', 'bob123', 'employer', NOW()),
('Carol White', 'carol@example.com', 'carol123', 'job_seeker', NOW()),
('David Brown', 'david@example.com', 'david123', 'employer', NOW()),
('Eva Green', 'eva@example.com', 'eva123', 'job_seeker', NOW());

INSERT INTO employers (user_id, company_name, location, website) VALUES
(2, 'Tech Corp', 'New York', 'https://techcorp.com'),
(4, 'Innovate Ltd', 'San Francisco', 'https://innovate.com'),
(2, 'Web Solutions', 'Los Angeles', 'https://websolutions.com'),
(4, 'Design Hub', 'Chicago', 'https://designhub.com'),
(2, 'CloudWorks', 'Seattle', 'https://cloudworks.com');

INSERT INTO job_seekers (user_id, education, experience, skills) VALUES
(1, 'B.Sc Computer Science', '2 years', 'Java, SQL'),
(3, 'M.Sc IT', '3 years', 'Python, React'),
(5, 'B.Tech ECE', '1 year', 'C++, Embedded Systems'),
(1, 'MBA', '4 years', 'Management, Marketing'),
(3, 'BCA', '2 years', 'JavaScript, Node.js');

INSERT INTO jobs (employer_id, title, description, location, qualifications, created_at) VALUES
(1, 'Java Developer', 'Develop enterprise applications', 'New York', 'B.Sc Computer Science', NOW()),
(2, 'Frontend Developer', 'Build UI with React', 'San Francisco', 'M.Sc IT', NOW()),
(3, 'Embedded Engineer', 'Work on embedded systems', 'Los Angeles', 'B.Tech ECE', NOW()),
(4, 'Marketing Manager', 'Manage marketing campaigns', 'Chicago', 'MBA', NOW()),
(5, 'Full Stack Developer', 'Develop full stack web apps', 'Seattle', 'BCA', NOW());

INSERT INTO applications (job_id, job_seeker_id, resume_path, status, applied_at) VALUES
(1, 1, '/resumes/alice_johnson.pdf', 'pending', NOW()),
(2, 2, '/resumes/carol_white.pdf', 'pending', NOW()),
(3, 3, '/resumes/eva_green.pdf', 'pending', NOW()),
(4, 4, '/resumes/alice_johnson.pdf', 'pending', NOW()),
(5, 5, '/resumes/carol_white.pdf', 'pending', NOW());

INSERT INTO resumes (job_seeker_id, file_path, uploaded_at) VALUES
(1, '/resumes/alice_johnson.pdf', NOW()),
(2, '/resumes/bob_smith.pdf', NOW()),
(3, '/resumes/carol_white.pdf', NOW()),
(4, '/resumes/david_brown.pdf', NOW()),
(5, '/resumes/eva_green.pdf', NOW());


DELIMITER //

CREATE PROCEDURE InsertUser(
    IN p_name VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_password VARCHAR(100),
    IN p_role ENUM('job_seeker', 'employer')
)
BEGIN
    INSERT INTO users (name, email, password, role)
    VALUES (p_name, p_email, p_password, p_role);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertEmployer(
    IN p_user_id INT,
    IN p_company_name VARCHAR(150),
    IN p_location VARCHAR(100),
    IN p_website VARCHAR(100)
)
BEGIN
    INSERT INTO employers (user_id, company_name, location, website)
    VALUES (p_user_id, p_company_name, p_location, p_website);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertJobSeeker(
    IN p_user_id INT,
    IN p_education VARCHAR(255),
    IN p_experience VARCHAR(255),
    IN p_skills VARCHAR(255)
)
BEGIN
    INSERT INTO job_seekers (user_id, education, experience, skills)
    VALUES (p_user_id, p_education, p_experience, p_skills);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertJob(
    IN p_employer_id INT,
    IN p_title VARCHAR(150),
    IN p_description TEXT,
    IN p_location VARCHAR(100),
    IN p_qualifications VARCHAR(255)
)
BEGIN
    INSERT INTO jobs (employer_id, title, description, location, qualifications)
    VALUES (p_employer_id, p_title, p_description, p_location, p_qualifications);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertApplication(
    IN p_job_id INT,
    IN p_job_seeker_id INT,
    IN p_resume_path VARCHAR(255),
    IN p_status VARCHAR(50)
)
BEGIN
    INSERT INTO applications (job_id, job_seeker_id, resume_path, status)
    VALUES (p_job_id, p_job_seeker_id, p_resume_path, p_status);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertResume(
    IN p_job_seeker_id INT,
    IN p_file_path VARCHAR(255)
)
BEGIN
    INSERT INTO resumes (job_seeker_id, file_path)
    VALUES (p_job_seeker_id, p_file_path);
END //

DELIMITER ;


