package com.qiaw99.AyUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import com.qiaw99.AyUser.model.AyUser;
import com.qiaw99.AyUser.service.AyUserService;

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
	
	@Resource
	private AyUserService ayUserService;
	
	@Test
	public void testRepository() {
		List<AyUser> userList = ayUserService.findAll();
		System.out.println("findAll():" + userList.size());
		
		PageRequest pageRequest = PageRequest.of(0, 10);
		Page<AyUser> userList2 = ayUserService.findAll(pageRequest);
		System.out.println("findAll(Pageable):" + userList2.getTotalPages() + "/" + userList2.getSize());
		
		List<AyUser> userList3 = ayUserService.findByName("a");
		Assert.isTrue(userList3.get(0).getName().equals("a"), "[ERROR] data error");
	}
}
