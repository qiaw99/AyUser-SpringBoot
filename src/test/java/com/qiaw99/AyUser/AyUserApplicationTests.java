package com.qiaw99.AyUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qiaw99.AyUser.model.AyUser;

@SpringBootTest
class AyUserApplicationTests {

	@Test
	void contextLoads() {
	}

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void mysqlTest() {
		String sqlString = "SELECT * FROM ay_user";
		List<AyUser> userList = jdbcTemplate.query(sqlString, new RowMapper<AyUser>() {

			@Override
			public AyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				AyUser user = new AyUser();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		});
		
		System.out.println("Query success!");
		for(AyUser user: userList) {
			System.out.println(user);
		}
	}
}
