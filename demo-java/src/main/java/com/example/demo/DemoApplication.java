package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	private final List<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public List<Student> getAllStudents() {
		return List.of(
				new Student(
						1L,
						"Mariam",
						"mariam.jamal@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 5),
						21
				),
				new Student(
						2L,
						"John",
						"john.doe@gmail.com",
						LocalDate.of(1998, Month.FEBRUARY, 15),
						23
				),
				new Student(
						3L,
						"Jane",
						"jane.smith@gmail.com",
						LocalDate.of(2001, Month.MARCH, 25),
						20
				),
				new Student(
						4L,
						"Alice",
						"alice.wonderland@gmail.com",
						LocalDate.of(1999, Month.APRIL, 10),
						22
				)
		);

	}

	@GetMapping(value = "/", params = "id")
	public Student getStudentById(@RequestParam Long id) {
		// Assume that the list of students is stored in a database
		// or some other data source and is accessible via a repository
		// or service layer.
		// In this example, we'll just filter the list of students
		// to find the one with the specified ID.
		List<Student> students = getAllStudents();
		return students.stream()
				.filter(student -> student.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Student not found"));
	}

	@PostMapping("/")
	public Student createStudent(@RequestBody Student student) {
		// Generate a new ID for the student
		Long id = students.stream()
				.mapToLong(Student::getId)
				.max()
				.orElse(0L) + 1;

		// Create a new student object with the generated ID
		Student newStudent = new Student(
				id,
				student.getName(),
				student.getEmail(),
				student.getDob(),
				student.getAge()
		);

		students.add(newStudent);

		return newStudent;
	}
}

