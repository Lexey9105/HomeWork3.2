package ru.hogwarts.school3_2.service;

import ru.hogwarts.school3_2.model.Faculty;
import ru.hogwarts.school3_2.model.Student;

import java.util.ArrayList;
import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Long id,String name,String color);
    Faculty updateFaculty(Long id,String name,String color);
    Faculty getFaculty(Long id);
    Faculty deleteFaculty(Long id);

    Collection<Faculty> facFilter(String color);
}
