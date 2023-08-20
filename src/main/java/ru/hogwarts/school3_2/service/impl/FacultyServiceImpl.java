package ru.hogwarts.school3_2.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.hogwarts.school3_2.model.Faculty;
import ru.hogwarts.school3_2.model.Student;
import ru.hogwarts.school3_2.service.FacultyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.chrono.JapaneseEra.values;


@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> storageFac;
    private Long size = 0L;

    public FacultyServiceImpl() {
        this.storageFac = new HashMap<>();
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(size++);
        storageFac.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        if (!storageFac.containsKey(id)) {
            return null;
        }
        storageFac.put(id, faculty);
        return faculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        if (!storageFac.containsKey(id)) {
            return null;
        }
        if (id == null || id == 0) {
            return null;
        }
        return storageFac.get(id);
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        if (id == null || id == 0) {
            throw new RuntimeException("введен пустой запрос");
        }
        if (!storageFac.containsKey(id)) {
            throw new RuntimeException("Сотрудник не найден");
        }
        storageFac.get(id);
        Faculty faculty = storageFac.get(id);
        storageFac.remove(id);
        size--;
        return faculty;
    }

    @Override
    public Collection<Faculty> facFilter(String color) {
        return storageFac.values().stream()
                .findAny().filter(e -> e.getColor().equals(color))
                .stream().collect(Collectors.toList());
    }
}
