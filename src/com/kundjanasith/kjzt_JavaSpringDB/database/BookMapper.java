package com.kundjanasith.kjzt_JavaSpringDB.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setName(rs.getString("name"));
		book.setDescription(rs.getString("description"));
		book.setPrice(rs.getFloat("price"));
		book.setAuthor(rs.getString("author"));
		return book;
	}
}
