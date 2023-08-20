package ru.hogwarts.school3_2.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school3_2.model.Student;
import ru.hogwarts.school3_2.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
private final StudentService studentService;
public StudentController (StudentService studentService){this.studentService=studentService;}


@PostMapping()
    public Student createStudent(@RequestBody Long id, @RequestBody Student student){
    return studentService.createStudent(student);
    }
    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Long id,@RequestBody Student student){
Student upStudent=studentService.updateStudent(id, student);
        if (student==null){return ResponseEntity.notFound().build();
        }
    return ResponseEntity.ok(student);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
    Student student=studentService.getStudent(id);
    if (student==null){return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id){
    return studentService.deleteStudent(id);
    }
@GetMapping("{age}")
    public ResponseEntity<Collection<Student>> studFilter(@PathVariable int age){
    return ResponseEntity.ok(studentService.studFilter(age));
    }
}
