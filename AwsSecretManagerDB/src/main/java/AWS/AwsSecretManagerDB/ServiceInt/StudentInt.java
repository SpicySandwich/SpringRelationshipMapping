package AWS.AwsSecretManagerDB.ServiceInt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AWS.AwsSecretManagerDB.DAO.StudentRepo;
import AWS.AwsSecretManagerDB.Model.Student;
import AWS.AwsSecretManagerDB.Service.StudentService;

@Service
public class StudentInt implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student findStudent(Integer id) {
		return studentRepo.findById(id).get();
	}

}
