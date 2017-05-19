package com.kundjanasith.kjzt_JavaSpringDB.database;

import java.util.List;

import javax.sql.DataSource;

public interface BookDAO {
	 public void setDataSource(DataSource ds);
	 public void create(String name, String description, Float price, String author);
	 public Book getBook(Integer id);
	 public List<Book> listBooks();
	 public void delete(Integer id);
	 public void update(Integer id, String name, String description, Float price, String author);
}
