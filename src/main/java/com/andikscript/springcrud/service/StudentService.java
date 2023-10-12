package com.andikscript.springcrud.service;

import com.andikscript.springcrud.dao.StudentDao;
import com.andikscript.springcrud.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<StudentDto> getAllStudent() {
        return studentDao.getAllStudent();
    }

    public StudentDto getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }
}
