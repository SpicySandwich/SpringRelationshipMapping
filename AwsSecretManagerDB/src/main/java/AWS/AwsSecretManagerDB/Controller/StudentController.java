package AWS.AwsSecretManagerDB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AWS.AwsSecretManagerDB.Model.Student;
import AWS.AwsSecretManagerDB.Service.StudentService;

@RestController
@RequestMapping("/secretdbtest")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/find/{id}")
	public Student findStudent(@PathVariable Integer id) {
		return service.findStudent(id);
	}
	
	@GetMapping("getall")
	public List<Student> getAll() {
		return service.getAllStudent();
	}
	
	@PostMapping("/addStudent")
	public Student saveStudent(@RequestBody Student student) {
	return	service.saveStudent(student);
	}

}
