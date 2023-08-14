package ru.hogwarts.school3_2.service;

import ru.hogwarts.school3_2.model.Faculty;
import ru.hogwarts.school3_2.model.Student;

import java.util.Collection;

public interface StudentService {

    Student createStudent(Long id,String name,int age);
    Student updateStudent(Long id,String name,int age);
    Student getStudent(Long id);
    Student deleteStudent(Long id);
    Collection<Student> studFilter(int age);
}
