package ru.hogwarts.school3_2.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school3_2.model.Faculty;
import ru.hogwarts.school3_2.model.Student;
import ru.hogwarts.school3_2.service.FacultyService;
import ru.hogwarts.school3_2.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController (FacultyService facultyService){this.facultyService=facultyService;}


    @PostMapping
    public Faculty createStudent(@RequestBody Long id, @RequestBody String name, @RequestBody String color){
        return facultyService.createFaculty(id,name,color);
    }
    @PutMapping()
    public Faculty updateStudent(@RequestBody Long id,@RequestBody String name,@RequestBody String color){
        return facultyService.updateFaculty(id, name, color);
    }
    @GetMapping("{id}")
    public Faculty getStudent(@PathVariable Long id){
        return facultyService.getFaculty(id);
    }
    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }
    @GetMapping("{color}")
    public Collection<Faculty> studFilter(@PathVariable String color){
        return facultyService.facFilter(color);
    }
}
