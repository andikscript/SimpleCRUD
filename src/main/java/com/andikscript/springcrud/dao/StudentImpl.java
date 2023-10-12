package com.andikscript.springcrud.dao;

import com.andikscript.springcrud.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
                (rs, rowNum) -> new StudentDto(
                        rs.getInt("id"),
                        rs.getString("name")
                )
        );

        return studentDtoList;
    }
}
