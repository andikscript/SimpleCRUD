package com.andikscript.springcrud;

import com.andikscript.springcrud.config.BeanConfiguration;
import com.andikscript.springcrud.dto.Student;
import com.andikscript.springcrud.service.StudentService;
import com.andikscript.springcrud.transport.SocketServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        SocketServer socketServer = context1.getBean(SocketServer.class);
        socketServer.run(5001);
    }
}
