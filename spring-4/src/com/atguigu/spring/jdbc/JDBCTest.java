package com.atguigu.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

class JDBCTest {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
		departmentDao = ctx.getBean(DepartmentDao.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	
	@Test
	public void testNamedParameterJdbcTemplate2() {
		String sql = "insert into employees (last_name, email, dept_id) values (:lastName, :email, :deptId)";
		Employee employee = new Employee();
		employee.setLastName("GG");
		employee.setEmail("gg@sina.com");
		employee.setDeptId(3);
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
//	@Test
//	public void testDelete() {
//		String sql = "delete from employees where id = ?";
//		jdbcTemplate.update(sql, 37);
//	}
	
//	@Test
//	public void testNamedParameterJdbcTemplate() {
//		String sql = "insert into employees (last_name, email, dept_id) values (:ln, :email, :deptId)";
//		Map<String, Object> parmMap = new HashMap<String, Object>();
//		parmMap.put("ln", "FF");
//		parmMap.put("email", "ff@163.com");
//		parmMap.put("deptId", 2);
//		namedParameterJdbcTemplate.update(sql, parmMap);
//	}
//	
//	@Test
//	public void testDepartmentDao() {
//		System.out.println(departmentDao.getDepartment(1));
//	}
//	
//	@Test
//	public void testEmployeeDao() {
//		Employee employee = employeeDao.getEmployee(1);
//		System.out.println(employee);
//	}
	
//	@Test
//	public void testQueryForObject2() {
//		String sql = "select count(id) from employees";
//		long count = jdbcTemplate.queryForObject(sql, Long.class);
//		System.out.println(count);
//	}
//	
//	@Test
//	public void testQueryForList() {
//		String sql = "select id, last_name lastName, email, dept_id from employees where id > ?";
//		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
//		List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 5);
//		System.out.println(employees);
//	}
//	
//	@Test
//	public void testQueryForObject() {
//		String sql = "select id, last_name lastName, email, dept_id from employees where id = ?";
//		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
//		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
//		System.out.println(employee);
//	}
//	
//	@Test
//	public void testBatchUupdate() {
//		String sql = "insert into employees (last_name, email, dept_id) values(?, ?, ?)";
//		List<Object[]> args = new ArrayList<Object[]>();
//		args.add(new Object[] {"AA", "aa@163.com", 1});
//		args.add(new Object[] {"BB", "bb@163.com", 2});
//		args.add(new Object[] {"CC", "cc@163.com", 3});
//		args.add(new Object[] {"DD", "dd@163.com", 3});
//		args.add(new Object[] {"EE", "ee@163.com", 2});
//		jdbcTemplate.batchUpdate(sql, args);
//	} 
//	
//	@Test
//	public void testUpdate() {
//		String sql = "update employees set last_name = ? where id = ?";
//		jdbcTemplate.update(sql, "Jack", 5);
//	}
//	
//	@Test
//	void testDataSource() throws SQLException {
//		DataSource dataSource = ctx.getBean(DataSource.class);
//		System.out.println(dataSource.getConnection());
//	}
}
