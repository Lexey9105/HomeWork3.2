package ru.hogwarts.school3_2.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Faculty createStudent(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping()
    public ResponseEntity<Faculty> updateStudent(@RequestBody Long id, @RequestBody Faculty faculty){
        Faculty upFaculty=facultyService.updateFaculty(id, faculty);
        if (faculty==null){return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getStudent(@PathVariable Long id){
        Faculty faculty=facultyService.getFaculty(id);
        if (faculty==null){return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }
    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }
    @GetMapping("{color}")
    public ResponseEntity<Collection<Faculty>> studFilter(@PathVariable String color){
        return ResponseEntity.ok(facultyService.facFilter(color));
    }
}
