package com.atguigu.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao extends JdbcDaoSupport{
	
	@Autowired
	public void setDataSource2(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public Department getDepartment(Integer id) {
		String sql = "select id, dept_name deptName from departments where id = ?";
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper, 1);
	}

}
