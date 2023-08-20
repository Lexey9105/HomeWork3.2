package ru.hogwarts.school3_2.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.hogwarts.school3_2.model.Faculty;
import ru.hogwarts.school3_2.model.Student;
import ru.hogwarts.school3_2.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> storageStud;
    private Long size = 0L;

    public StudentServiceImpl() {
        this.storageStud = new HashMap<>();
    }

    @Override
    public Student createStudent(Student student) {
        student.setId(size++);
        storageStud.put(student.getId(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if(!storageStud.containsKey(id)){return null;}
        storageStud.put(id, student);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        if (!storageStud.containsKey(id)) {
            throw new RuntimeException("Сотрудник уже добавлен");
        }
        if (id == null || id == 0) {
            throw new RuntimeException("введен пустой запрос");
        }
        return  storageStud.get(id);
    }

    @Override
    public Student deleteStudent(Long id) {
        if (!storageStud.containsKey(id)) {
            throw new RuntimeException("Сотрудник уже добавлен");
        }
        if (id == null || id == 0) {
            throw new RuntimeException("введен пустой запрос");
        }
        Student student = storageStud.get(id);
        storageStud.remove(id);
        size--;
        return student;
    }

    @Override
    public Collection<Student> studFilter(int age) {
        return storageStud.values().stream()
                .findAny().filter(e -> e.getAge() == age)
                .stream().collect(Collectors.toList());
    }
}
