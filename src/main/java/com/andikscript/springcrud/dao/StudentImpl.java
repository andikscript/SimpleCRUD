package com.andikscript.springcrud.dao;

import com.andikscript.springcrud.dto.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudent() {
        String sql = "SELECT * FROM student ORDER BY id ASC";

        List<Student> studentList = jdbcTemplate.query(
                sql,
                new RowMapper<Student>() {
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return setResult(rs, rowNum);
                    }
                }
        );

        return studentList;
    }

    @Override
    public Student getStudentById(Integer id) {
        String sql = "SELECT * FROM student WHERE id = ?";

        Student student = jdbcTemplate.queryForObject(
                sql,
                new RowMapper<Student>() {
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return setResult(rs, rowNum);
                    }
                }, new Object[] { id }
        );
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO student values (?,?)";

        int condition =jdbcTemplate.update(sql,
                new Object[]{
                        student.getId(),student.getName()
                });

        return condition > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        String sql = "UPDATE student set name = ? WHERE id = ?";

        int condition = jdbcTemplate.update(sql,
                new Object[] {
                   student.getName(), student.getId()
                });

        return condition > 0;
    }

    private Student setResult(ResultSet rs, int numRow) throws SQLException {
        Student student = new Student(
                rs.getInt("id"),
                rs.getString("name")
        );

        return student;
    }
}
