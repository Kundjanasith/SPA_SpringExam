package com.kundjanasith.kjzt_JavaSpringDB.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PatternJDBCTemplate implements PatternDAO{

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(String name, String group, String implementation) {
		String SQL = "insert into pattern (pname, pgroup, implementation) values (?, ?, ?)";
		jdbcTemplateObject.update( SQL, name, group, implementation);
		System.out.println("Created Record Name = " + name + " Group = " + group + " Implementation = " + implementation  );
		return;
	}

	@Override
	public Pattern getPattern(Integer id) {
		String SQL = "select * from pattern where id = ?";
		Pattern pattern = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new PatternMapper());
		return pattern;
	}

	@Override
	public List<Pattern> listPatterns() {
		String SQL = "select * from pattern";
		List<Pattern> patterns = jdbcTemplateObject.query(SQL, new PatternMapper());
 		return patterns;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from pattern where id = ?";
		jdbcTemplateObject.update(SQL, id);
		return;
	}

	@Override
	public void update(Integer id, String name, String group, String implementation) {
		String SQL = "update pattern set pname = ?, pgroup = ?, implementation = ? where id = ?";
		jdbcTemplateObject.update(SQL, name, group, implementation, id);
		return;
	}


}
