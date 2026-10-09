package com.ebc.lui.take_attendance.repository;

import com.ebc.lui.take_attendance.model.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendRepository extends CrudRepository<Student, Integer>{

    // Check whether student name and class already in DB --> avoiding same record
    @Query("SELECT COUNT(*) FROM student_record WHERE name=:name AND student_class =:studentClass")
    int checkSameNameClass(@Param("name") String userInputName,
                             @Param("studentClass") String userInputClass);

    // Take attendance --> add attendance record + 1
    @Modifying
    @Query("UPDATE student_record SET attendance_count = attendance_count + 1 WHERE id=:id")
    void addedAttendanceCount(@Param("id") int id);

    // Remove attendace record to recover
    @Modifying
    @Query("UPDATE student_record SET attendance_count = attendance_count - 1 WHERE id=:id AND attendance_count > 0")
    int removedAttendanceCount(@Param("id") int id);

    // Ask for leave count --> add ask for leave record + 1
    @Modifying
    @Query("UPDATE student_record SET ask_leave_count = ask_leave_count + 1 WHERE id=:id")
    void addedAskLeaveCount(@Param("id") int id);

    // Remove ask for leave record to recover
    @Modifying
    @Query("UPDATE student_record SET ask_leave_count = ask_leave_count - 1 WHERE id=:id AND ask_leave_count > 0")
    int removedAskLeaveCount(@Param("id") int id);
}
