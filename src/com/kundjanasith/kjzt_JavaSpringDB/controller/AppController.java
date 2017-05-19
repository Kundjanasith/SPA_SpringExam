package com.kundjanasith.kjzt_JavaSpringDB.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kundjanasith.kjzt_JavaSpringDB.database.Pattern;
import com.kundjanasith.kjzt_JavaSpringDB.database.PatternJDBCTemplate;


@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private PatternJDBCTemplate patternJDBCTemplate;

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@GetMapping(value = { "/addNewPattern"})
	public ModelAndView addNewPatternForm() {
//		Student student = new Student();
		Pattern pattern = new Pattern();
		return new ModelAndView("addNewPattern", "pattern", pattern);
	}
	
	@PostMapping(value = { "/addNewPattern"})
	public ModelAndView addNewPatternSubmit(@ModelAttribute("pattern") Pattern pattern) {
		boolean isValid = ( !pattern.getName().isEmpty() && !pattern.getGroup().isEmpty() && !pattern.getImplementation().isEmpty() );
		if( isValid ){
			pattern.setId(patternJDBCTemplate.listPatterns().size() + 1);
			System.out.println(pattern.toString());
			patternJDBCTemplate.create(pattern.getName(), pattern.getGroup(), pattern.getImplementation());
			return new ModelAndView("home", "message", "Successfully Add New Pattern");
		}
		return new ModelAndView("addNewPattern", "message", "Invalid inputs!");
//		boolean isValid = ( !book.getName().isEmpty() && !book.getDescription().isEmpty() && !book.getPrice().isNaN() && !book.getAuthor().isEmpty() );
//		if( isValid ){
//			book.setId(bookJDBCTemplate.listBooks().size() + 1);
//			System.out.println(book.toString());
//			bookJDBCTemplate.create(book.getName(), book.getDescription(), book.getPrice(), book.getAuthor());
//			return new ModelAndView("home", "message", "Successfully Add New Book");
//		}
//		return new ModelAndView("addNewBook", "message", "Invalid inputs!");
//		boolean isValid = ( !student.getName().isEmpty() && !student.getGpax().isNaN() && !student.getAmbition().isEmpty() ) ? true : false;
//		if( isValid ) {
//			student.setId(studentJDBCTemplate.listStudents().size() + 1);
//			System.out.println(student.toString());
//			studentJDBCTemplate.create(student.getName(), student.getGpax(), student.getAmbition());
//			return new ModelAndView("home", "message", "Succesfully Add New Student");
//		}
//		return new ModelAndView("addNewStudent", "message", "Invalid inputs!");
	}
	
	@GetMapping(value = { "/viewPatterns"})
	public ModelAndView patternsListPage(ModelMap model) {
		Map<String, List<Pattern>> patterns = new HashMap<String, List<Pattern>>();
		patterns.put("patterns", patternJDBCTemplate.listPatterns());
		for( Pattern pattern : patternJDBCTemplate.listPatterns()){
			System.out.println(pattern);
		}
		return new ModelAndView("viewPatterns", patterns);
//		Map<String, List<Student>> students = new HashMap<String, List<Student>>();
//		students.put("students", studentJDBCTemplate.listStudents());
//		for ( Student student : studentJDBCTemplate.listStudents()) {
//			System.out.println(student);
//		}
//		return new ModelAndView("viewStudents", students);
	}
	
	@GetMapping("/editPattern/{id}")
	public ModelAndView editPatternPage(@PathVariable Integer id) {
		Pattern pattern = patternJDBCTemplate.getPattern(id);
		return new ModelAndView("editPattern", "pattern", pattern);
//		Student student = studentJDBCTemplate.getStudent(id);
//		return new ModelAndView("editStudent", "student", student);
	}
	
	@PostMapping("/editPattern/{id}")
	public ModelAndView editPatternSubmit(@ModelAttribute Pattern pattern, ModelMap model) {
		System.out.println("Updating: " + pattern);
		patternJDBCTemplate.update(pattern.getId(), pattern.getName(), pattern.getGroup(), pattern.getImplementation());
		return patternsListPage(model.addAttribute("message",  "Successfully edited pattern"));
//		System.out.println("Updating: " + student);
//		studentJDBCTemplate.update(student.getId(), student.getName(), student.getGpax(), student.getAmbition());
//		return studentsListPage(model.addAttribute("message", "Successfully edited student"));
	}
	
	@PostMapping("deletePattern/{id}")
	public ModelAndView deletePattern(@PathVariable Integer id, ModelMap model) {
		System.err.println("[REMOVE] Pattern @ID " + id);
		patternJDBCTemplate.delete(id);
		return patternsListPage(model);
//		System.err.println("[REMOVE] Student @ID " + id);
//		studentJDBCTemplate.delete(id);
//		return studentsListPage(model);
	}
	
}




