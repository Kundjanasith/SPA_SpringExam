package com.kundjanasith.kjzt_JavaSpringDB.database;

public class Book {
	private Integer id;
	private String name;
	private String description;
	private Float price;
	private String author;
	public Book(){
		super();
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [id=" + getId() + ", name=" + name + ", description=" + description + ", price=" + price + ", author=" + author + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
