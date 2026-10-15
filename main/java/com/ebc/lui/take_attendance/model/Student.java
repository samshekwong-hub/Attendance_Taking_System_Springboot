package com.ebc.lui.take_attendance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("student_record")
public class Student {

    @Id
    private Integer id;

    @Column("name")
    private String name;

    @Column("student_class")
    private String studentClass;


    @Column("attendance_count")
    private Integer attendanceCount;

    @Column("ask_leave_count")
    private Integer askLeaveCount;

    public Student() {
    }

    public Student(String name, String studentClass) {
        this.name = name;
        this.studentClass = studentClass;
        this.attendanceCount = 0;
        this.askLeaveCount = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Integer getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(Integer attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public Integer getAskLeaveCount() {
        return askLeaveCount;
    }

    public void setAskLeaveCount(Integer askLeaveCount) {
        this.askLeaveCount = askLeaveCount;
    }
}
