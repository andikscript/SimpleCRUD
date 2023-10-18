package com.andikscript.springcrud.service;

import com.andikscript.springcrud.dao.StudentDao;
import com.andikscript.springcrud.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

}
