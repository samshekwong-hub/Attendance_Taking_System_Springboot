package com.ebc.lui.take_attendance.repository;

import com.ebc.lui.take_attendance.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface AttendRepository extends CrudRepository<Student, Integer> {
}
