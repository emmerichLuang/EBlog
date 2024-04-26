package com.ee.EBlog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author E.E. (liangruilin@joyy.sg)
 * @description
 * @date 2021/10/14
 */
@Component
public class MySqlUserDao {
	@Autowired
    JdbcTemplate template;

	private String createSql = "insert into user(name) values(?)";

	/**
	 * 返回id
	 * @param name
	 * @return
	 */
	public Integer create(String name){

		KeyHolder keyHolder = new GeneratedKeyHolder();;
		template.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(createSql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	public void query(){
		String sql = "select * from user where 1=1 ";
		template.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				//TODO:
			}
		});
	}

}
