package com.andikscript.springcrud.dao;

import com.andikscript.springcrud.dto.StudentDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        String sql = "SELECT * FROM student ORDER BY id ASC";

        List<StudentDto> studentDtoList = jdbcTemplate.query(
                sql,
                new RowMapper<StudentDto>() {
                    @Override
                    public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return setResult(rs, rowNum);
                    }
                }
        );

        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        String sql = "SELECT * FROM student WHERE id = ?";

        StudentDto student = jdbcTemplate.queryForObject(
                sql,
                new RowMapper<StudentDto>() {
                    @Override
                    public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return setResult(rs, rowNum);
                    }
                }, new Object[] { id }
        );
        return student;
    }

    private StudentDto setResult(ResultSet rs, int numRow) throws SQLException {
        StudentDto student = new StudentDto(
                rs.getInt("id"),
                rs.getString("name")
        );

        return student;
    }
}
