package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program Started!" );
        ApplicationContext con=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate template=con.getBean("jdbcTemplate",JdbcTemplate.class);
        
        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        
        //fire query
        int result=template.update(query,458,"Pooja Upadhyay","Bangalore");
        System.out.println("Number of rows inserted..:"+result);
    }
}
