# Spring Boot Attendance Taking System
This is a Spring Boot CRUD system for small-sized student tutoring classes to record attendance.

## Preparations
1. Install Java JDK and IDE (prefer IntelliJ IDEA)
2. Install MySQL, create a database named "student_tutor" and run the schema.sql script inside the /resources folder
3. Create a Spring Boot project by using Spring Initializr and add needed dependencies (can refer pom.xml)
4. Run TakeAttendanceApplication.java when everything goes well

## Functions
### Login
User need to login by using these two accounts (for testing purpose):
1. Username: lui, password: password
2. Username: miku, password: miku </br>

The login password is encrypted by BCryptPasswordEncoder as considered deploy in real-life environment. </br>
Can reject user if wrong username or password is entered. </br>
User can also clicked "logout" button to logout the system in other pages. </br>
<img width="1918" height="955" alt="Screenshot from 2026-10-16 02-02-22" src="https://github.com/user-attachments/assets/79a49958-680b-4d9b-a772-182ea74026d5" />

### Add Student Record
After sign-in, user can add students' record by enter their name and class. </br> 
The app can detect whether student already having record in database and prevent duplicated entries. </br>
If user forgets to enter either student's name or class, the add student record also not be processed. </br>
User can modified the attendance and ask for leave records by clicking "-". 
<img width="1913" height="948" alt="Screenshot from 2026-10-16 02-06-26" src="https://github.com/user-attachments/assets/1fb84d39-f21d-40de-a87c-34eb84f8458c" />

### Check Student Record
User can view current all student's records and take attendance in this page. </br>
To take attendance, user can click "+" button on the "Take Attendance" column. </br>
If a student has ask for leave in advance, user can click "+" button on the "Take Ask for Leave" column. </br>
<img width="1913" height="955" alt="Screenshot from 2026-10-16 02-16-35" src="https://github.com/user-attachments/assets/4e1ec008-0013-4477-9b62-107081a2ef74" />

## Database Schema
<img width="336" height="476" alt="student_tutor_diagram" src="https://github.com/user-attachments/assets/924da06f-5eb7-446d-8ab5-0f15a72a112f" /> </br>
Here are the meanings of each tables:
1. Student_record: store students' basic information (name, class, attendance counts and ask for leave counts).
2. Users: store users' name, password, encrypted password and whether the user account is enabled.
3. Authorities: store users' authorities (whether they are admin or ordinary users).
4. Roles: store users' role (name and their current role in student tutoring class).
