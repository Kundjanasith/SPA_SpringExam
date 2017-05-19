package com.kundjanasith.kjzt_JavaSpringDB.database;

public class Pattern {
	private Integer id;
	private String name;
	private String group;
	private String implementation;
	public Pattern(){
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + getId() + ", name=" + getName() + ", group=" + getGroup() + ", implementation=" + getImplementation() + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getImplementation() {
		return implementation;
	}
	public void setImplementation(String implementation) {
		this.implementation = implementation;
	}
}
