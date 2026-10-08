package com.ebc.lui.take_attendance.service;

import com.ebc.lui.take_attendance.model.Student;
import com.ebc.lui.take_attendance.repository.AttendRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class AttendService {
    private final AttendRepository attendRepository;

    public AttendService(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    public Student save (String studentName, String studentClass) {
        Student student = new Student();
        student.setName(studentName);
        student.setStudent_class(studentClass);
        attendRepository.save(student);
        return student;
    }

    public void remove(Integer id){
        attendRepository.deleteById(id);
    }

    public Iterable<Student> find(){
        return attendRepository.findAll();
    }
}
