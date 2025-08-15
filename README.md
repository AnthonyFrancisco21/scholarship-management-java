Bucot Scholarship Management System
==========================

## Requirements
- Java JDK 8+
- NetBeans IDE
- MySQL Connector/J (add to your project’s libraries)
- XAMPP (for MySQL server)

**Features**

 - Student
    - Create an account and upload scholarship requirements (stored as BLOB in the database).
    - View submitted requirements.
    - See announcements from Super Admin and Admin.
    - Check application status: Pending, Accepted, or Rejected.

 - Admin / SK Councilor

    - View all student submissions and accept/reject applications.
    - Post announcements.
      
 -  Super Admin / SK Chairman

    - All Admin capabilities.
    - Create new Admin accounts.
    - Generate printable reports of all student accounts, their statuses, and submission dates.
  
**Folder Structure**
```
├── docs
│  ├── (...System screenshot)
├── LICENSE
├── composer.phar
├── manifest.mf
├── nbproject
    ├── build-impl.xml
    ├── genfiles.properties
    ├── private
    │   ├── config.properties
    │   ├── private.properties
    │   └── private.xml
    ├── project.properties
    └── project.xml
├── src
    └── scholarshipmanagement
    │   ├── SQLException.java
    │   ├── addAdmin.form
    │   ├── addAdmin.java
    │   ├── addAnnouncement.form
    │   ├── addAnnouncement.java
    │   ├── adminDash.form
    │   ├── adminDash.java
    │   ├── councilorDash.form
    │   ├── councilorDash.java
    │   ├── images
    │       ├── 2x2.jpg
    │       ├── bbss-logo.jpg
    │       ├── birth certificate (1).jpg
    │       ├── cor-img.jpg
    │       ├── form137.png
    │       ├── letter-img.png
    │       ├── logout (1).png
    │       └── refresh (1) (1).png
    │   ├── login.form
    │   ├── login.java
    │   ├── readStudentSubmission.form
    │   ├── readStudentSubmission.java
    │   ├── signup.form
    │   ├── signup.java
    │   ├── splashscreen.form
    │   ├── splashscreen.java
    │   ├── studentDashboard.form
    │   ├── studentDashboard.java
    │   ├── studentSubmitForm.form
    │   ├── studentSubmitForm.java
    │   ├── updateAdd.form
    │   └── updateAdd.java
└── student.sql
```

**Installation & Setup**

  - Clone or Download the Project
    >git clone https://github.com/YourUsername/ScholarshipManagementSystem.git
    Or download as ZIP and extract.

  - Open in NetBeans
    
    - Open NetBeans IDE.
    - Go to File → Open Project.
    - Select the extracted project folder.
   
  - Set Up the Database

    - Start XAMPP and run Apache & MySQL.
    - Open phpMyAdmin in your browser (http://localhost/phpmyadmin).
    - Create a new database (example: scholarship_db).
    - Import the included SQL file from the project folder.
      
  - Add MySQL Connector/J

    - In NetBeans, right-click your project → Properties.
    - Go to Libraries → Add JAR/Folder.
    - Select your downloaded MySQL Connector/J .jar file.
    - Click OK.

  - Configure Database Connection
    - Open evvery file in the src/ folder (e.g., login.java, signin.java).
    - Update the database name, username, and password to match your local setup. Example:

```
    public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bucot_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Database connection failed: " + ex.getMessage());
            return null;
        }
    }
}
```

  - Run the Project
    - In NetBeans, click the green Run button.
    - The application will start, and you can log in with the default credentials provided in the README.

**Project Overview/Prototype**

  <img width="554" height="299" alt="image" src="https://github.com/user-attachments/assets/6882d288-ad03-4e0d-963e-af06515823f7" />

- Log in
  
  <img width="586" height="444" alt="image" src="https://github.com/user-attachments/assets/b9ec07bd-b185-4a82-af1e-f1d07d7d8d35" />

---

- Student dashboard
  
  <img width="561" height="544" alt="image" src="https://github.com/user-attachments/assets/d42cd757-c657-4345-85be-41bab87f2b36" />
  
  > Create/Sign in account for student.
  
  <img width="957" height="541" alt="image" src="https://github.com/user-attachments/assets/7a1dcdcc-d188-4624-975c-2a37996b2cec" />
  
  > Requirements
  
  <img width="961" height="540" alt="image" src="https://github.com/user-attachments/assets/1fe720d9-2ddc-4219-a6f8-39532775e4b8" />
  
  > Status section
  
  <img width="957" height="540" alt="image" src="https://github.com/user-attachments/assets/9af8a871-0240-409a-89b3-87da23a015b7" />
  
  > Announcements from admin/super admin

---

- Admin  / SK Councilor Dashbord
  
  <img width="958" height="536" alt="image" src="https://github.com/user-attachments/assets/09b661f9-01ae-4d5e-abf4-ec5fcf636d6c" />
  
  > Table of students with submitted scholarship requirements
  
  <img width="959" height="541" alt="image" src="https://github.com/user-attachments/assets/b4ebfb25-9905-443a-bc86-e89353e585e6" />
  
  > Manage announcements – add, update, or remove posts
  
---
  
- Super Admin / SK Chairman
  
  - Inherits all features from the Admin dashboard (student submission table and announcements section) with additional capabilities:
 
    <img width="1200" height="672" alt="image" src="https://github.com/user-attachments/assets/7404cc94-945a-400e-8fd2-c78ec897df1b" />
    
    > Admin account management - add, update or delete admin account
    
    <img width="1198" height="669" alt="image" src="https://github.com/user-attachments/assets/14d250d5-5acf-45fd-a6cb-d86fdd40bff2" />
    <img width="1195" height="669" alt="image" src="https://github.com/user-attachments/assets/37ec76b3-2cdd-46ed-8027-263dda243ff8" />

    > Super Admin can generate a complete report of all student accounts, including their details, application status, and submission dates. The report opens in the system’s print dialog, making it ready for immediate printing.
    
    ---

- Data Flow Diagram (DFD)

  <img width="892" height="1387" alt="image" src="https://github.com/user-attachments/assets/2b5b2088-f3d7-4107-ac91-1c2b54f77106" />

    ---

 ## Future Features

  Planned improvements and upcoming functionalities:
  
 - Multi-language support (English, Filipino, etc.)
 - Improve Authentication and Authorization
 - Improve User Interface
 - “Remember Me” feature
 - Forgot Password functionality
 - Gmail confirmation for creating student account
   
This project is a work in progress and will continue to improve over time. Feedback and contributions are always welcome!

 ## License
This project is licensed under the MIT License - see the LICENSE file for details.

## 📬 Contact
- **Email:** [franciscoanthony82@gmail.com](mailto:franciscoanthony82@gmail.com)
- **GitHub:** [AnthonyFrancisco21](https://github.com/AnthonyFrancisco21)










