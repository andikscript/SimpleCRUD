package com.andikscript.springcrud.config;

import com.andikscript.springcrud.dao.StudentDao;
import com.andikscript.springcrud.dao.StudentImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.andikscript.springcrud")
@PropertySource("classpath:jdbc.properties")
public class BeanConfiguration {

    @Value("${database.driverclass}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Value("${database.user}")
    private String username;

    @Value("${database.pass}")
    private String password;

    // make bean annotation for connection database
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    // make bean jdbcTemplate for use inject when call
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());

        return jdbcTemplate;
    }

    @Bean(name = "studentDao")
    public StudentDao studentDao() {
        StudentImpl student = new StudentImpl();
        student.setJdbcTemplate(jdbcTemplate());

        return student;
    }
}
