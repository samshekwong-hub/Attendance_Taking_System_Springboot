package com.ebc.lui.take_attendance.service;

import com.ebc.lui.take_attendance.model.Student;
import com.ebc.lui.take_attendance.repository.AttendRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.naming.Name;

@Service
public class AttendService {
    private final AttendRepository attendRepository;

    public AttendService(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    public String save (String studentName, String studentClass) {

        /*
        1. Check whether user input the student name or student class
        2. Check whether student name or class already existed in database
        3. Save the student data to database if both are false
         */

        // If user did not input student name or student class --> return a null student object
        if (studentName == null || studentName.trim().isEmpty() || studentClass == null || studentClass.trim().isEmpty()) {
            return "EMPTY";
        }

        boolean foundSameNameClass = attendRepository.checkSameNameClass(studentName, studentClass) > 0;

        if (foundSameNameClass == true) {
            return "DUPLICATE";
        }

        // Else --> store the student value to DB
        Student student = new Student(studentName, studentClass);
        attendRepository.save(student);

        return "SUCCESS:" + studentName + ": " + studentClass;
    }

    public void remove(Integer id){
        attendRepository.deleteById(id);
    }

    public Iterable<Student> find(){
        return attendRepository.findAll();
    }

    // Add attend count +1 (if the student attend to class)
    public void addAttendRecord(Integer id){ attendRepository.addedAttendanceCount(id);
    }

    // Remove attend count -1 (make sure to recover from wrong decisions)
    public boolean removeAttendRecord(Integer id){
        int updatedRows = attendRepository.removedAttendanceCount(id);
        return updatedRows > 0;
    }

    // Add attend count +1 (if the student already applied for absent in advance)
    public void addAskLeaveRecord(Integer id) {
        attendRepository.addedAskLeaveCount(id);
    }

    // Remove attend count -1 (make sure to recover from wrong decisions)
    public boolean removeAskLeaveRecord(Integer id) {
        int updatedRows = attendRepository.removedAskLeaveCount(id);
        return updatedRows > 0;
    }
}
