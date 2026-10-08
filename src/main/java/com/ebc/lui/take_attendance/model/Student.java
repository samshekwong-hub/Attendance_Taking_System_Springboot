package com.ebc.lui.take_attendance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("student_record")
public class Student {

    @Id
    private Integer id;


    private String name;
    private String student_class;
    private Integer attendance_count = 0;
    private Integer ask_leave_count = 0;

    public Student() {
    }

    public Student(String name, String student_class) {
        this.name = name;
        this.student_class = student_class;
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

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public Integer getAttendance_count() {
        return attendance_count;
    }

    public void setAttendance_count(Integer attendance_count) {
        this.attendance_count = attendance_count;
    }

    public Integer getAsk_leave_count() {
        return ask_leave_count;
    }

    public void setAsk_leave_count(Integer ask_leave_count) {
        this.ask_leave_count = ask_leave_count;
    }
}
