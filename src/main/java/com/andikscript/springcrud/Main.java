package com.andikscript.springcrud;

import com.andikscript.springcrud.dto.Student;
import com.andikscript.springcrud.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");

        // get all
        System.out.println(studentService.getAllStudent());

        // get by id
        System.out.println(studentService.getStudentById(1));

        // add student
        System.out.println(studentService.addStudent(new Student(5, "Mindai")));
        System.out.println(studentService.getAllStudent());

        // update student
        System.out.println(studentService.updateStudent(new Student(5, "Mindain")));
        System.out.println(studentService.getAllStudent());
    }
}
