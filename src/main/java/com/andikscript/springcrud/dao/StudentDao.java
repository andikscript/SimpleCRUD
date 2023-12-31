package com.andikscript.springcrud.dao;

import com.andikscript.springcrud.dto.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudent();

    Student getStudentById(Integer id);

    boolean addStudent(Student student);

    boolean updateStudent(Student student);
}
