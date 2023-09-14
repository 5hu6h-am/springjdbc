package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program Started!" );
        ApplicationContext con=new AnnotationConfigApplicationContext(JdbcConfig.class);
        //ApplicationContext con=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        StudentDao studentDao=con.getBean("studentDao",StudentDao.class);
        Student student=new Student();
        
        
        //1)INSERT
//        student.setId(666);
//        student.setName("Shreya");
//        student.setCity("Haridwar");
//        int result=studentDao.insert(student);
//        System.out.println("Student added "+result);
        //-----------------------------------------
        //-----------------------------------------
        
        //2)Update
//        student.setId(222);
//        student.setName("Shivam Upadhyay");
//        student.setCity("Varanasi");
//        int result=studentDao.change(student);
//        System.out.println("Change made in "+result+" row.");
        
        //----------------------------------------
        //----------------------------------------
        
        //3)Delete
//        int result=studentDao.delete(666);
//        System.out.println("Deleted "+result+" record");
        
        //----------------------------------------
        //----------------------------------------
        
        //4)Select
//        Student student1 = studentDao.getStudent(222);
//        System.out.println(student1);
        
        //----------------------------------------
        //----------------------------------------
        
        //5)Seleccting multiple
        List<Student> students=studentDao.getAllStudents();
        for(Student s:students) {
        	System.out.println(s);
        }
    }
}
