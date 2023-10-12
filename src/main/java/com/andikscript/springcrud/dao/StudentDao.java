package com.andikscript.springcrud.dao;

import com.andikscript.springcrud.dto.StudentDto;

import java.util.List;

public interface StudentDao {

    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Integer id);
}
