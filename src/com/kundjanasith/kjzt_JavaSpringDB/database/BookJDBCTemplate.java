package com.kundjanasith.kjzt_JavaSpringDB.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookJDBCTemplate implements BookDAO{

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(String name, String description, Float price, String author) {
		String SQL = "insert into bookstore (name, description, price, author) values (?, ?, ?, ?)";
		jdbcTemplateObject.update( SQL, name, description, price, author);
		System.out.println("Created Record Name = " + name + " Description = " + description + " Price = " + price + " Author = " + author );
		return;
	}

	@Override
	public Book getBook(Integer id) {
		String SQL = "select * from bookstore where id = ?";
		Book book = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new BookMapper());
		return book;
	}

	@Override
	public List<Book> listBooks() {
		String SQL = "select * from bookstore";
		List<Book> books = jdbcTemplateObject.query(SQL, new BookMapper());
 		return books;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from bookstore where id = ?";
		jdbcTemplateObject.update(SQL, id);
		return;
	}

	@Override
	public void update(Integer id, String name, String description, Float price, String author) {
		String SQL = "update bookstore set name = ?, description = ?, price = ?, author = ? where id = ?";
		jdbcTemplateObject.update(SQL, name, description, price, author, id);
		return;
	}

}
