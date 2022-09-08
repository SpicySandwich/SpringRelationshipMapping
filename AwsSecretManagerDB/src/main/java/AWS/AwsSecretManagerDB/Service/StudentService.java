package AWS.AwsSecretManagerDB.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import AWS.AwsSecretManagerDB.Model.Student;
@Service
public interface StudentService {
	
	public Student saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student findStudent(Integer id);
}
