package com.andikscript.springcrud;

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

        System.out.println(studentService.getAllStudent());
        System.out.println(studentService.getStudentById(1));
    }
}
