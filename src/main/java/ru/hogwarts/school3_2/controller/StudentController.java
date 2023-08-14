package ru.hogwarts.school3_2.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school3_2.model.Student;
import ru.hogwarts.school3_2.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
private final StudentService studentService;
public StudentController (StudentService studentService){this.studentService=studentService;}


@PostMapping
    public Student createStudent(@RequestBody Long id, @RequestBody String name,@RequestBody int age){
    return studentService.createStudent(id,name,age);
    }
    @PutMapping()
    public Student updateStudent(@RequestBody Long id,@RequestBody String name,@RequestBody int age){
    return studentService.updateStudent(id, name, age);
    }
    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id){
    return studentService.getStudent(id);
    }
    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id){
    return studentService.deleteStudent(id);
    }
@GetMapping("{age}")
    public Collection<Student> studFilter(@PathVariable int age){
    return studentService.studFilter(age);
    }
}
