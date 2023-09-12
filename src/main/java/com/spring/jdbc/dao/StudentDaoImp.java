package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImp implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//insert
	@Override
	public int insert(Student student) {
		String query="insert into student(id,name,city) values(?,?,?)";
		int r=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	//update
	@Override
	public int change(Student student) {
		String query="update student set name=?, city=?  where Id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	//delete
	@Override
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}

	//selecting single
	@Override
	public Student getStudent(int StudentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImp();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,222);
		return student;
	}

	//selecting multiple
	@Override
	public List<Student> getAllStudents() {
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query, new RowMapperImp());
		return students;
	}
	

	
	
}
